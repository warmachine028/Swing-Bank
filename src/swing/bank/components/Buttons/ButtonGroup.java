package swing.bank.components.Buttons;

import javax.swing.*;
import java.util.Enumeration;

public class ButtonGroup extends javax.swing.ButtonGroup {

    public ButtonGroup(boolean disabled, RadioButton... buttons) {
        this(buttons);
        disable();
    }

    public ButtonGroup(RadioButton... buttons) {
        for (RadioButton button : buttons)
            add(button);
    }

    void disable() {
        Enumeration<AbstractButton> buttons = this.getElements();
        while (buttons.hasMoreElements()) {
            AbstractButton button = buttons.nextElement();
            button.setEnabled(false);
        }
    }
}
