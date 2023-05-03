package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    JTextField cardNoTextField;
    JPasswordField pinTextField;
    JButton logInButton, clearButton, signUpButton;
    Login() {
        /* Setting Properties of Login Window */
        setProperties();

        /* Creating Components */
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png")),
                scaledIcon = new ImageIcon(
                        icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)
                );
        JLabel iconLabel = new JLabel(scaledIcon),
                title = new JLabel("Welcome to BMS"),
                cardNoLabel = new JLabel("Card No: "),
                pinLabel = new JLabel("PIN: ");
        cardNoTextField = new JTextField();
        pinTextField = new JPasswordField();
        logInButton = new JButton("LOG IN");
        clearButton = new JButton("CLEAR");
        signUpButton = new JButton("SIGN UP");

        /* Setting Properties and Location of components */
        iconLabel.setBounds(70, 10, 100, 100);

        title.setFont(new Font("Oswald", Font.BOLD, 38));
        title.setBounds(200, 40, 400, 40);

        cardNoLabel.setFont(new Font("Raleway", Font.BOLD, 28));
        cardNoLabel.setBounds(120, 150, 150, 30);

        cardNoTextField.setFont(new Font("Arial", Font.BOLD, 14));
        cardNoTextField.setBounds(300, 150, 230, 30);

        pinLabel.setFont(new Font("Raleway", Font.BOLD, 28));
        pinLabel.setBounds(120, 220, 250, 30);

        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        pinTextField.setBounds(300, 220, 230, 30);

        logInButton.setBackground(Color.BLACK);
        logInButton.setForeground(Color.WHITE);
        logInButton.setBounds(300, 300, 100, 30);

        clearButton.setBackground(Color.BLACK);
        clearButton.setForeground(Color.WHITE);
        clearButton.setBounds(430, 300, 100, 30);

        signUpButton.setBackground(Color.BLACK);
        signUpButton.setForeground(Color.WHITE);
        signUpButton.setBounds(300, 350, 230, 30);


        /* Adding Event Listeners */
        logInButton.addActionListener(this);
        clearButton.addActionListener(this);
        signUpButton.addActionListener(this);

        setVisible(true);
        /* Adding Components to frame */
        add(iconLabel);
        add(title);
        add(cardNoLabel);
        add(pinLabel);
        add(cardNoTextField);
        add(pinTextField);
        add(logInButton);
        add(clearButton);
        add(signUpButton);
    }

    public static void main(String[] args) {
        new Login();
    }

    void onClear() {
        cardNoTextField.setText("");
        pinTextField.setText("");
    }

    void onLogin() {
        System.out.println("Login");
    }

    void onSignUp() {
        System.out.println("SignUp");
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        var clickedButton = event.getSource();
        if (clickedButton == clearButton)
            onClear();
        if (clickedButton == logInButton)
            onLogin();
        if (clickedButton == signUpButton)
            onSignUp();
    }

    private void setProperties() {
        setLayout(null);
        setSize(800, 500);
        getContentPane().setBackground(Color.WHITE);
        setLocation(350, 200);
        setTitle("Bank Management System");
    }
}
