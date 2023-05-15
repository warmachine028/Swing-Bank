package swing.bank;

import swing.bank.components.Labels.*;
import swing.bank.components.Buttons.*;
import swing.bank.components.Buttons.ButtonGroup;
import swing.bank.components.Buttons.Button;
import swing.bank.components.TextField;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import com.toedter.calendar.JDateChooser;

public class SignUp extends JFrame {
    TextField nameTextField, fNameTextField, emailTextField, addressField,
            cityTextField, stateTextField, pinTextField;
    JDateChooser datePicker;

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
        long formNo = Math.abs(new Random().nextLong() % 9000L + 1000L);
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
        addressField = new TextField(this, 440);
        cityTextField = new TextField(this, 490);
        stateTextField = new TextField(this, 540);
        pinTextField = new TextField(this, 590);

        datePicker = new JDateChooser();
        datePicker.setBounds(300, 240, 400, 30);
        datePicker.setBackground(new Color(105, 105, 105));

        RadioButton male = new RadioButton("Male", 300, 290, this);
        RadioButton female = new RadioButton("Female", 450, 290, this);
        new ButtonGroup(male, female);

        RadioButton married = new RadioButton("Married", 300, 390, this);
        RadioButton single = new RadioButton("Single", 450, 390, this);
        RadioButton other = new RadioButton("Other", 600, 390, this);
        new ButtonGroup(married, single, other);
        new Button("Next", 620, 660, 80, this)
                .setBackground(Color.RED);

        add(datePicker);
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
