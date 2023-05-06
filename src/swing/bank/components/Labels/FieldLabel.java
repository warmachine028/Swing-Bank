package swing.bank.components.Labels;

import javax.swing.*;
import java.awt.*;

public class FieldLabel extends Label {
    int x, y, height, width, size = 28;
    public FieldLabel(String text, int x, int y, int width, int height, JFrame frame) {
        super(text);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        setProperties();
        frame.add(this);
    }
    public FieldLabel(String text, int x, int y, int width, int height, int size, JFrame frame) {
        this(text, x, y, width, height, frame);
        this.size = size;
        setProperties();
    }

    @Override
    void setProperties() {
        Font font = new Font("Raleway", Font.BOLD, size);
        setFont(font);
        setForeground(foregroundColor);
        setBounds(x, y, width, height);
    }
}