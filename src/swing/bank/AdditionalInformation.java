package swing.bank;

import swing.bank.components.Buttons.Button;
import swing.bank.components.Buttons.ButtonGroup;
import swing.bank.components.Buttons.RadioButton;
import swing.bank.components.ComboBox;
import swing.bank.components.Labels.FieldLabel;
import swing.bank.components.Labels.SubTitleLabel;
import swing.bank.components.TextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

public class AdditionalInformation extends JFrame {
    String signUpFormNumber;
    TextField panTextField, aadhaarTextField;
    ComboBox<String> religion, category, income, qualification, occupation;
    ButtonGroup existingHolder;
    JFrame signUpFrame;

    AdditionalInformation(JFrame previousFrame, String formNo) {
        signUpFrame = previousFrame;
        signUpFormNumber = formNo;
        setProperties();
        setLabels();
        setFields();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Connector();
        new AdditionalInformation(null, null);
    }

    private void setLabels() {
        new SubTitleLabel("PAGE 2: Additional Details", 290, 80, this);

        new FieldLabel("Religion: ", 50, 140, 300, 30, 20, this);
        new FieldLabel("Category: ", 50, 190, 300, 30, 20, this);
        new FieldLabel("Annual Income: ", 50, 240, 300, 30, 20, this);
        new FieldLabel("Educational Qualification: ", 50, 290, 300, 30, 20, this);
        new FieldLabel("Occupation: ", 50, 340, 300, 30, 20, this);
        new FieldLabel("PAN Number: ", 50, 390, 300, 30, 20, this);
        new FieldLabel("Aadhaar Number: ", 50, 440, 300, 30, 20, this);
        new FieldLabel("Existing account Holder ?", 50, 490, 300, 30, 20, this);
    }

    private void setFields() {
        String[] religions = {"Hindu", "Muslim", "Sikh", "Other"};
        String[] categories = {"General", "OBC", "SC", "ST", "Other"};
        String[] incomes = {"No Fixed Income", "< 1,50,000", "< 2,50,000", "< 5,00,000", "< 10,00,000", "More than 10,00,000"};
        String[] qualifications = {"Non Graduate", "Graduate", "Post Graduate", "Doctorate", "Other"};
        String[] occupations = {"Student", "Salaried", "Self Employed", "Business", "Retired", "Other"};

        religion = new ComboBox<>(religions, 140, this);
        category = new ComboBox<>(categories, 190, this);
        income = new ComboBox<>(incomes, 240, this);
        qualification = new ComboBox<>(qualifications, 290, this);
        occupation = new ComboBox<>(occupations, 340, this);
        panTextField = new TextField(this, 390);
        aadhaarTextField = new TextField(this, 440);
        existingHolder = new ButtonGroup(
                new RadioButton("Yes", 470, 490, this),
                new RadioButton("No", 620, 490, this)
        );

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
        if (signUpFrame == null)
            return;
        setVisible(false);
        signUpFrame.setVisible(true);
    }

    void handleClear(ActionEvent event) {
        religion.setSelectedItem(null);
        category.setSelectedItem(null);
        income.setSelectedItem(null);
        qualification.setSelectedItem(null);
        occupation.setSelectedItem(null);
        panTextField.setText("");
        aadhaarTextField.setText("");
        existingHolder.clearSelection();
    }

    void handleSubmit(ActionEvent event) {
        String religion = (String) this.religion.getSelectedItem(),
                category = (String) this.category.getSelectedItem(),
                income = (String) this.income.getSelectedItem(),
                qualification = (String) this.qualification.getSelectedItem(),
                occupation = (String) this.occupation.getSelectedItem(),
                pan = panTextField.getText(),
                aadhaar = aadhaarTextField.getText(),
                existingHolder,
                seniorCitizenship;
        RadioButton existingHolderStatus = getSelection(this.existingHolder);
        try {
            Connector connection = new Connector();
            String query = String.format("SELECT dob FROM Users WHERE formNo = '%s'", signUpFormNumber);
            ResultSet result = connection.statement.executeQuery(query);
            result.next();
            Validator.validateSelection(religion, "a religion");
            Validator.validateSelection(category, "a category");
            Validator.validateSelection(income, "an income");
            Validator.validateSelection(qualification, "a qualification");
            Validator.validateSelection(occupation, "an occupation");
            Validator.validatePan(pan);
            Validator.validateAadhaar(aadhaar);
            Validator.validateOptions(existingHolderStatus, "existing account holder status");
            seniorCitizenship = Validator.validateSeniorCitizen(result.getDate("dob"));
            existingHolder = existingHolderStatus.getText();

            query = String.format(
                    "INSERT INTO AdditionalDetails (formNo, religion, category, income, qualification," +
                            " occupation, pan, aadhaar, existingHolder, seniorCitizen) " +
                            "VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                    signUpFormNumber, religion, category, income, qualification, occupation, pan, aadhaar,
                    existingHolder, seniorCitizenship
            );
            connection.statement.executeUpdate(query);

        } catch (NullPointerException | IllegalArgumentException exception) {
            JOptionPane.showMessageDialog(
                    this,
                    exception.getMessage(),
                    "Invalid Input",
                    JOptionPane.WARNING_MESSAGE);
        } catch (SQLException exception) {
            System.out.println(exception.getCause() + exception.getMessage());
        }
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
        setTitle("Swing Bank-Additional Details");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
