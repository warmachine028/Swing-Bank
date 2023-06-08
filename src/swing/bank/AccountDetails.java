package swing.bank;

import swing.bank.components.Buttons.Button;
import swing.bank.components.Buttons.ButtonGroup;
import swing.bank.components.Buttons.CheckBox;
import swing.bank.components.Buttons.RadioButton;
import swing.bank.components.Labels.FieldLabel;
import swing.bank.components.Labels.SubTitleLabel;
import swing.bank.utils.ButtonGroupUtils;
import swing.bank.utils.Validator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

public class AccountDetails extends JFrame {
    ButtonGroup type;
    JFrame additionalInformationFrame;
    String signUpFormNumber;

    CheckBox atm, internetBank, mobileBank, alerts, chequeBook, eStatement;

    AccountDetails(JFrame previousFrame, String formNo) {
        additionalInformationFrame = previousFrame;
        signUpFormNumber = formNo;
        setProperties();
        setLabels();
        setFields();
        setVisible(true);
    }


    public static void main(String[] args) {
        new AccountDetails(null, "1");
    }

    private void setLabels() {
        String cardNumber = "XXXX-XXXX-XXXX-3142",
                pinNumber = "XXXX";
        Font fieldFont = new Font("Raleway", Font.PLAIN, 20),
                subTitleFont = new Font("Raleway", Font.PLAIN, 14);
        new SubTitleLabel("PAGE 3: Account Details", 290, 80, this);

        new FieldLabel("Account Type: ", 100, 140, 200, 30, 20, this);

        new FieldLabel("Card Number: ", 100, 290, 200, 30, 20, this);
        new FieldLabel(cardNumber, 330, 290, 230, 30, this).setFont(fieldFont);
        new FieldLabel("Your 16 digit card number", 330, 310, 300, 30, this).setFont(subTitleFont);

        new FieldLabel("PIN: ", 100, 340, 230, 30, 20, this);
        new FieldLabel(pinNumber, 330, 340, 230, 30, this).setFont(fieldFont);

        new FieldLabel("Services Required", 100, 400, 230, 30, 20, this);

    }

    private void setFields() {
        type = new ButtonGroup(
                new RadioButton("Savings Account", 100, 180, 200, this),
                new RadioButton("Current Account", 300, 180, 200, this),
                new RadioButton("Fixed Deposit Account", 100, 220, 200, this),
                new RadioButton("Recurring Deposit Account", 300, 220, 200, this)
        );

        // Checkboxes
        atm = new CheckBox("ATM Card", 110, 430, this);
        internetBank = new CheckBox("Internet Banking", 110, 460, this);
        mobileBank = new CheckBox("Mobile Banking", 110, 490, this);
        alerts = new CheckBox("Email & SMS Alerts", 110, 520, this);
        chequeBook = new CheckBox("Cheque Book", 110, 550, this);
        eStatement = new CheckBox("E Statement", 110, 580, this);

        Button cancel = new Button("CANCEL", 500, 680, 80, this);
        cancel.setBackground(Color.WHITE);
        cancel.setForeground(Color.BLACK);

        Button submit = new Button("SUBMIT", 620, 680, 80, this);
        submit.setBackground(Color.WHITE);
        submit.setForeground(Color.BLACK);
        submit.setEnabled(false);
        submit.addActionListener(this::handleSubmit);
        new CheckBox("I hereby declare the above entered details are correct to the best of my knowledge",
                80, 630, this
        ).addItemListener(e -> submit.setEnabled(e.getStateChange() == ItemEvent.SELECTED));
    }

    void handleSubmit(ActionEvent event) {
        RadioButton type = ButtonGroupUtils.getSelection(this.type);
        try {
            Validator.validateOptions(type, "account type");
        } catch (IllegalArgumentException exception) {
            JOptionPane.showMessageDialog(
                    this,
                    exception.getMessage(),
                    "Invalid Input",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private void setProperties() {
        setLayout(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage("icons/white icon.png"));
        setSize(850, 800);
        setLocation(350, 10);
        getContentPane().setBackground(Color.BLACK);
        setLocation(350, 200);
        setTitle("Swing Bank-Account Details");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
