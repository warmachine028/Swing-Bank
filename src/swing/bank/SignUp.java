package swing.bank;

import com.toedter.calendar.JDateChooser;
import swing.bank.components.Buttons.Button;
import swing.bank.components.Buttons.ButtonGroup;
import swing.bank.components.Buttons.RadioButton;
import swing.bank.components.Labels.FieldLabel;
import swing.bank.components.Labels.SubTitleLabel;
import swing.bank.components.Labels.TitleLabel;
import swing.bank.components.TextField;
import swing.bank.utils.ButtonGroupUtils;

import javax.naming.NameNotFoundException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.Date;

public class SignUp extends JFrame {
    TextField nameTextField, fNameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pinCodeTextField;
    JDateChooser datePicker;
    ButtonGroup gender, maritalStatus;
    JFrame loginFrame;
    String formNo;

    SignUp(JFrame previousFrame) {
        loginFrame = previousFrame;
        setProperties();
        setLabels();
        setFields();
        setVisible(true);
    }

    public static void main(String[] args) {
        new SignUp(null);
    }

    private void setLabels() {
        formNo = String.format("%04d", Connector.generateFormNumber());
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
        datePicker.setDateFormatString("dd-MM-yyyy");
        datePicker.setBounds(300, 240, 400, 30);
        datePicker.setMaxSelectableDate(new Date());
        add(datePicker);

        gender = new ButtonGroup(
                new RadioButton("Male", 300, 290, this),
                new RadioButton("Female", 450, 290, this)
        );

        maritalStatus = new ButtonGroup(
                new RadioButton("Married", 300, 390, this),
                new RadioButton("Single", 450, 390, this),
                new RadioButton("Other", 600, 390, this)
        );

        // Buttons
        Button back = new Button("BACK", 380, 660, 80, this);
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.addActionListener(this::handleBack);
        Button clear = new Button("CLEAR", 500, 660, 80, this);
        clear.setBackground(Color.WHITE);
        clear.setForeground(Color.BLACK);
        clear.addActionListener(this::handleClear);
        Button next = new Button("NEXT", 620, 660, 80, this);
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.addActionListener(this::handleSubmit);
    }

    void handleBack(ActionEvent event) {
        if (loginFrame == null)
            return;
        setVisible(false);
        loginFrame.setVisible(true);
    }

    void handleClear(ActionEvent event) {
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
    }

    void handleSubmit(ActionEvent event) {
        String name = nameTextField.getText(),
                fName = fNameTextField.getText(),
                dateOfBirth = ((JTextField) datePicker.getDateEditor().getUiComponent()).getText(),
                gender,
                email = emailTextField.getText(),
                maritalStatus,
                address = addressTextField.getText(),
                city = cityTextField.getText(),
                state = stateTextField.getText(),
                pinCode = pinCodeTextField.getText();

        RadioButton selectedGender = getSelection(this.gender), selectedMaritalStatus = getSelection(this.maritalStatus);
        try {
            Validator.validateName(name);
            Validator.validateName(fName, "Father's Name");
            Validator.validateDate(dateOfBirth);
            Validator.validateOptions(selectedGender, "gender");
            Validator.validateEmail(email);
            Validator.validateOptions(selectedMaritalStatus, "marital status");

            gender = selectedGender.getText();
            maritalStatus = selectedMaritalStatus.getText();
            String[] date = dateOfBirth.split("-"); // User Format -> dd-mm-yyyy
            String dob = String.format("%s-%s-%s", date[2], date[1], date[0]); // SQL Format -> yyyy-mm-dd

            Connector connection = new Connector();
            String query = String.format(
                    "INSERT INTO Users (name, fName, dob, gender, email, maritalStatus, address, city, state, pinCode) " +
                            "VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                    name, fName, dob, gender, email, maritalStatus, address, city, state, pinCode
            );
            connection.statement.executeUpdate(query);
            openNextFrame();
        } catch (NameNotFoundException | NullPointerException | IllegalArgumentException exception) {
            JOptionPane.showMessageDialog(
                    this,
                    exception.getMessage(),
                    "Invalid Input",
                    JOptionPane.WARNING_MESSAGE);
        } catch (SQLException exception) {
            System.out.println(exception.getCause() + exception.getMessage());
        }
    }

    void openNextFrame() {
        setVisible(false);
        new AdditionalInformation(this, formNo);
    }

    void setProperties() {
        setLayout(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage("icons/white icon.png"));
        setSize(850, 800);
        setLocation(350, 10);
        getContentPane().setBackground(Color.BLACK);
        setLocation(350, 200);
        setTitle("Swing Bank-Initial Details");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
