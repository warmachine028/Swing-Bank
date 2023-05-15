package swing.bank.components.Buttons;

import javax.swing.*;
import java.awt.*;

public class RadioButton extends JRadioButton {
    Color foregroundColor = Color.WHITE;
    Color backgroundColor = Color.BLACK;
    int x, y, width = 120, height = 30;
    RadioButton(String text) {
        super(text);
    }

    public RadioButton(String text, int x, int y, JFrame frame){
        this(text);
        this.x = x;
        this.y = y;
        setProperties();
        frame.add(this);
    }
    void setProperties() {
        setForeground(foregroundColor);
        setBackground(backgroundColor);
        setBounds(x, y, width, height);
    }
}
