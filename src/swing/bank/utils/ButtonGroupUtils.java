package swing.bank.utils;

import swing.bank.components.Buttons.ButtonGroup;
import swing.bank.components.Buttons.RadioButton;

import javax.swing.*;
import java.util.Enumeration;

public class ButtonGroupUtils {
    public static RadioButton getSelection(ButtonGroup buttonGroup) {
        RadioButton selectedButton = null;
        Enumeration<AbstractButton> buttons = buttonGroup.getElements();
        while (buttons.hasMoreElements()) {
            RadioButton button = (RadioButton) buttons.nextElement();
            if (button.isSelected()) {
                selectedButton = button;
                break;
            }
        }
        return selectedButton;
    }
}
