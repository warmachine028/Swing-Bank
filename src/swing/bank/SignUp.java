package swing.bank;

import com.toedter.calendar.JDateChooser;
import swing.bank.components.Buttons.Button;
import swing.bank.components.Buttons.ButtonGroup;
import swing.bank.components.Buttons.RadioButton;
import swing.bank.components.Labels.FieldLabel;
import swing.bank.components.Labels.SubTitleLabel;
import swing.bank.components.Labels.TitleLabel;
import swing.bank.components.TextField;

import javax.naming.NameNotFoundException;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Random;

public class SignUp extends JFrame {
    long formNo;
    TextField nameTextField, fNameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pinCodeTextField;
    JDateChooser datePicker;
    ButtonGroup gender, maritalStatus;

    SignUp() {
        setProperties();
        setLabels();
        setFields();
        setVisible(true);
    }

    public static void main(String[] args) {
        new SignUp();
    }

    private void setLabels() {
        formNo = Math.abs(new Random().nextLong() % 9000L + 1000L);
        new TitleLabel("APPLICATION FORM No.: " + formNo, 140, 20, this);
        new SubTitleLabel("PAGE 1: Personal Details", 290, 80, this);

        new FieldLabel("Name: ", 100, 140, 200, 30, 20, this);
        new FieldLabel("Father's Name: ", 100, 190, 200, 30, 20, this);
        new FieldLabel("Date of Birth: ", 100, 240, 200, 30, 20, this);
        new FieldLabel("Gender: ", 100, 290, 200, 30, 20, this);
        new FieldLabel("Email: ", 100, 340, 200, 30, 20, this);
        new FieldLabel("Marital Status: ", 100, 390, 200, 30, 20, this);
        new FieldLabel("Address: ", 100, 440, 200, 30, 20, this);
        new FieldLabel("City: ", 100, 490, 200, 30, 20, this);
        new FieldLabel("State: ", 100, 540, 200, 30, 20, this);
        new FieldLabel("Pin Code: ", 100, 590, 200, 30, 20, this);
    }

    private void setFields() {
        nameTextField = new TextField(this, 140);
        fNameTextField = new TextField(this, 190);
        emailTextField = new TextField(this, 340);
        addressTextField = new TextField(this, 440);
        cityTextField = new TextField(this, 490);
        stateTextField = new TextField(this, 540);
        pinCodeTextField = new TextField(this, 590);

        datePicker = new JDateChooser();
        datePicker.setBounds(300, 240, 400, 30);

        gender = new ButtonGroup(
                new RadioButton("Male", 300, 290, this),
                new RadioButton("Female", 450, 290, this)
        );

        maritalStatus = new ButtonGroup(
                new RadioButton("Married", 300, 390, this),
                new RadioButton("Single", 450, 390, this),
                new RadioButton("Other", 600, 390, this)
        );

        Button clear = new Button("CLEAR", 500, 660, 80, this);
        clear.setBackground(Color.WHITE);
        clear.setForeground(Color.BLACK);
        clear.addActionListener((event) -> {
            nameTextField.setText("");
            fNameTextField.setText("");
            datePicker.setDate(null);
            gender.clearSelection();
            emailTextField.setText("");
            maritalStatus.clearSelection();
            addressTextField.setText("");
            cityTextField.setText("");
            stateTextField.setText("");
            pinCodeTextField.setText("");
        });
        Button next = new Button("Next", 620, 660, 80, this);
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.addActionListener((event) -> {
            String formNo = String.valueOf(this.formNo),
                    name = nameTextField.getText(),
                    fName = fNameTextField.getText(),
                    dob = ((JTextField) datePicker.getDateEditor().getUiComponent()).getText(),
                    gender,
                    email = emailTextField.getText(),
                    maritalStatus,
                    address = addressTextField.getText(),
                    city = cityTextField.getText(),
                    state = stateTextField.getText(),
                    pinCode = pinCodeTextField.getText();
            RadioButton selectedGender = getSelection(this.gender),
                    selectedMaritalStatus = getSelection(this.maritalStatus);
            try {
                Validator.validateName(name);
                Validator.validateName(fName, "Father's Name");
                Validator.validateEmail(email);
                Validator.validateOptions(selectedGender, "gender");
                Validator.validateOptions(selectedMaritalStatus, "marital status");

                gender = selectedGender.getText();
                maritalStatus = selectedMaritalStatus.getText();
                // ! Add other Validators Later

                Connector connection = new Connector();
                String query = String.format(
                        "INSERT INTO SignUpForms " +
                                "VALUES('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                        formNo, name, fName, dob, gender, email, maritalStatus, address, city, state, pinCode
                );
                connection.statement.executeUpdate(query);

            } catch (NameNotFoundException | NullPointerException exception) {
                JOptionPane.showMessageDialog(
                        this,
                        exception.getMessage(),
                        "Invalid Input",
                        JOptionPane.WARNING_MESSAGE);
            } catch (SQLException exception) {
                System.out.println(exception.getMessage());
            } finally {

            }
        });

        add(datePicker);
    }

    RadioButton getSelection(ButtonGroup buttonGroup) {
        RadioButton selectedButton = null;
        Enumeration<AbstractButton> buttons = buttonGroup.getElements();
        while (buttons.hasMoreElements()) {
            RadioButton button = (RadioButton) buttons.nextElement();
            if (button.isSelected()) {
                selectedButton = button;
                break;
            }
        }
        return selectedButton;
    }

    void setProperties() {
        setLayout(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage("icons/white icon.png"));
        setSize(850, 800);
        setLocation(350, 10);
        getContentPane().setBackground(Color.BLACK);
        setLocation(350, 200);
        setTitle("Swing Bank");
    }

}
