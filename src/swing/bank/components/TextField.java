package swing.bank.components;

import javax.swing.*;
import java.awt.*;

public class TextField extends JTextField {
    Font font = new Font("Raleway", Font.BOLD, 14);
    public TextField(JFrame frame, int yAxis) {
        super();
        setProperties(yAxis);
        frame.add(this);
    }

    void setProperties(int y) {
        setFont(font);
        setBounds(300, y, 400, 30);
    }
}
