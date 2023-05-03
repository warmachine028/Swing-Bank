package swing.bank.components.Labels;

import javax.swing.*;
import java.awt.*;

public class TitleLabel extends Label {
    Font font = new Font("Oswald", Font.BOLD, 38);
    int x, y, width = 600, height = 50;

    public TitleLabel(String text, int x, int y, JFrame frame) {
        super(text);
        this.x = x;
        this.y = y;
        setProperties();
        frame.add(this);
    }

    public TitleLabel(String text, int x, int y, Color foregroundColor, JFrame frame) {
        this(text, x, y, frame);
        this.foregroundColor = foregroundColor;
        setForeground(foregroundColor);
    }

    @Override
    void setProperties() {
        setFont(font);
        setForeground(foregroundColor);
        setBounds(x, y, width, height);
    }
}
