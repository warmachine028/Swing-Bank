package swing.bank.components.Buttons;

import javax.swing.*;
import java.awt.*;

public class CheckBox extends JCheckBox {
    Font font = new Font("Raleway", Font.BOLD, 16);
    int x, y, width= 900, height= 30;
    Color foregroundColor = Color.WHITE,
            backgroundColor = Color.BLACK;

    public CheckBox(String text, int x, int y, JFrame frame) {
        super(text);
        this.x = x;
        this.y = y;
        setProperties();
        frame.add(this);
    }

    void setProperties() {
        setForeground(foregroundColor);
        setBackground(backgroundColor);
        setFont(font);
        setBounds(x, y, width, height);
    }
}
