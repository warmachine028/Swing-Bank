package swing.bank.components;

import javax.swing.*;
import java.awt.*;

public class ComboBox<T> extends JComboBox<T> {

    int x = 300, y, width = 400, height = 30;
    Color backgroundColor = Color.WHITE;

    public ComboBox(T[] items, int y, JFrame frame) {
        super(items);
        this.y = y;
        setProperties();
        frame.add(this);
    }

    void setProperties() {
        setBackground(backgroundColor);
        setBounds(x, y, width, height);
        setSelectedItem(null);
    }
}
