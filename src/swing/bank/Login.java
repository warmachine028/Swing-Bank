package swing.bank;

import swing.bank.components.Buttons.Button;
import swing.bank.components.Labels.FieldLabel;
import swing.bank.components.Labels.TitleLabel;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Login extends JFrame {
    JTextField cardNoTextField;
    JPasswordField pinTextField;
    Button logInButton, clearButton, signUpButton;

    Login() {
        /* Setting Properties of Login Window */
        setProperties();

        /* Creating Components */
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("icons/logo.png"))),
                scaledIcon = new ImageIcon(icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        JLabel iconLabel = new JLabel(scaledIcon);
        new TitleLabel("Welcome to Swing Bank", 200, 40, Color.GREEN, this);
        new FieldLabel("Card No.: ", 120, 150, 150, 30, this);
        new FieldLabel("PIN: ", 120, 220, 250, 30, this);

        cardNoTextField = new JTextField();
        pinTextField = new JPasswordField();

        logInButton = new Button("LOG IN", 300, 300, 100, this);
        signUpButton = new Button("SIGN UP", 430, 300, 100, this);
        clearButton = new Button("CLEAR", 300, 350, 230, this);

        /* Setting Properties and Location of components */
        iconLabel.setBounds(70, 10, 100, 100);

        cardNoTextField.setFont(new Font("Arial", Font.BOLD, 14));
        cardNoTextField.setBounds(300, 150, 230, 30);

        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        pinTextField.setBounds(300, 220, 230, 30);

        /* Adding Event Listeners */
        logInButton.addActionListener((event) -> System.out.println("Login"));
        clearButton.addActionListener((event) -> {
            cardNoTextField.setText("");
            pinTextField.setText("");
        });
        signUpButton.addActionListener((event) -> {
            setVisible(false);
            new SignUp();
        });

        /* Adding Components to frame */
        add(iconLabel);
        add(cardNoTextField);
        add(pinTextField);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }


    private void setProperties() {
        setLayout(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(
                getClass().getClassLoader().getResource("icons/white icon.png")));
        setSize(800, 500);
        getContentPane().setBackground(Color.BLACK);
        setLocation(350, 200);
        setTitle("Swing Bank");
    }
}
