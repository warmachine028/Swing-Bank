package swing.bank.components;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {
    int x, y, width, height = 30;
    Color foregroundColor = Color.WHITE,
          backgroundColor = Color.BLACK;

    public Button(String text, int x, int y, int width, JFrame frame) {
        super(text);
        this.x = x;
        this.y = y;
        this.width = width;
        setProperties();
        frame.add(this);
    }

    void setProperties() {
        setBackground(backgroundColor);
        setForeground(foregroundColor);
        setBounds(x, y, width, height);
    }

}
