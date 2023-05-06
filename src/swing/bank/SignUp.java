package swing.bank;

import swing.bank.components.Labels.FieldLabel;
import swing.bank.components.Labels.TitleLabel;
import swing.bank.components.TextField;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.util.Random;~~~

public class SignUp extends JFrame {
    TextField nameTextField, fNameTextField, emailTextField,
              addressField, cityTextField, stateTextField, pinTextField;

    SignUp() {
        setProperties();
        long formNo = Math.abs(new Random().nextLong() % 9000L + 1000L);
        new TitleLabel("APPLICATION FORM No.: " + formNo, 140, 20, this);

        JLabel personalDetails = new JLabel("PAGE 1: Personal Details"),
                email = new JLabel("Email ID: "),
                marital = new JLabel("Marital Status: "),
                address = new JLabel("Address: "),
                city = new JLabel("City: "),
                state = new JLabel("State: "),
                pinCode = new JLabel("Pin Code: ");

        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setForeground(ColorUIResource.WHITE);
        personalDetails.setBounds(290, 80, 400, 30);

        new FieldLabel("Name: ", 100, 140, 200, 30, 20, this);
        new FieldLabel("Father's Name: ", 100, 190, 200, 30, 20, this);
        new FieldLabel("Date of Birth: ", 100, 240, 200, 30, 20, this);
        new FieldLabel("Gender: ", 100, 290, 200, 30, 20, this);


        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setForeground(ColorUIResource.WHITE);
        email.setBounds(100, 340, 200, 30);

        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setForeground(ColorUIResource.WHITE);
        marital.setBounds(100, 390, 200, 30);

        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setForeground(ColorUIResource.WHITE);
        address.setBounds(100, 440, 200, 30);

        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setForeground(ColorUIResource.WHITE);
        city.setBounds(100, 490, 200, 30);

        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setForeground(ColorUIResource.WHITE);
        state.setBounds(100, 540, 200, 30);

        pinCode.setFont(new Font("Raleway", Font.BOLD, 20));
        pinCode.setForeground(ColorUIResource.WHITE);
        pinCode.setBounds(100, 590, 200, 30);

        setTextFields();
        add(personalDetails);
        add(email);
        add(marital);
        add(address);
        add(city);
        add(state);
        add(pinCode);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SignUp();
    }

    void setTextFields() {
        nameTextField = new TextField(this, 140);
        fNameTextField = new TextField(this, 190);
        emailTextField = new TextField(this, 340);
        addressField = new TextField(this, 440);
        cityTextField = new TextField(this, 490);
        stateTextField = new TextField(this, 540);
        pinTextField = new TextField(this, 590);
    }

    void setProperties() {
        setLayout(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage("src/icons/white icon.png"));
        setSize(850, 800);
        setLocation(350, 10);
        getContentPane().setBackground(Color.BLACK);
        setLocation(350, 200);
        setTitle("Swing Bank");

    }
}
