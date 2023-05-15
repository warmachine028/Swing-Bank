package swing.bank.components.Buttons;

public class ButtonGroup extends javax.swing.ButtonGroup {
    public ButtonGroup(RadioButton... buttons) {
        for (RadioButton button : buttons)
            add(button);
    }
}
