package swing.bank.components.Labels;

import javax.swing.*;
import java.awt.*;

public abstract class Label extends JLabel {
    Color foregroundColor = Color.WHITE;
    Label(String text){
        super(text);
    }
    abstract void setProperties();
}