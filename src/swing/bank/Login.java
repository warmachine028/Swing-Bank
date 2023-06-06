package swing.bank;

import swing.bank.components.Buttons.Button;
import swing.bank.components.Labels.FieldLabel;
import swing.bank.components.Labels.TitleLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

public class Login extends JFrame {
    JTextField cardNoTextField;
    JPasswordField pinTextField;

    Login() {
        /* Setting Properties of Login Window */
        setProperties();
        setLabels();
        setFields();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }

    private void setLabels() {
        ImageIcon icon = new ImageIcon(
                Objects.requireNonNull(
                        getClass().getClassLoader()
                                .getResource("icons/logo.png")
                )
        ), scaledIcon = new ImageIcon(
                icon.getImage()
                        .getScaledInstance(100, 100, Image.SCALE_DEFAULT)
        );
        JLabel iconLabel = new JLabel(scaledIcon);
        iconLabel.setBounds(70, 10, 100, 100);
        add(iconLabel);

        new TitleLabel("Welcome to Swing Bank", 200, 40, Color.GREEN, this);
        new FieldLabel("Card No.: ", 120, 150, 150, 30, this);
        new FieldLabel("PIN: ", 120, 220, 250, 30, this);
    }

    private void setFields() {
        cardNoTextField = new JTextField();
        pinTextField = new JPasswordField();

        /* Setting Properties and Location of components */

        cardNoTextField.setFont(new Font("Arial", Font.BOLD, 14));
        cardNoTextField.setBounds(300, 150, 230, 30);

        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        pinTextField.setBounds(300, 220, 230, 30);

        /* Adding Event Listeners */
        new Button("LOG IN", 300, 300, 100, this).addActionListener((event) -> System.out.println("Login"));
        new Button("SIGN UP", 430, 300, 100, this).addActionListener(this::handleSignUp);
        new Button("CLEAR", 300, 350, 230, this).addActionListener(this::handleClear);

        /* Adding Components to frame */
        add(cardNoTextField);
        add(pinTextField);
    }

    void handleClear(ActionEvent event) {
        cardNoTextField.setText("");
        pinTextField.setText("");
    }

    void handleSignUp(ActionEvent event) {
        setVisible(false);
        new SignUp(this);
    }

    private void setProperties() {
        setLayout(null);
        setIconImage(
                Toolkit.getDefaultToolkit()
                        .getImage(
                                getClass().getClassLoader()
                                        .getResource("icons/white icon.png")
                        )
        );
        setSize(800, 500);
        getContentPane().setBackground(Color.BLACK);
        setLocation(350, 200);
        setTitle("Swing Bank");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
