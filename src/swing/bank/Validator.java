package swing.bank;

import swing.bank.components.Buttons.RadioButton;

import javax.naming.NameNotFoundException;
import java.util.regex.Pattern;

public class Validator {
    static void validateName(String name) throws NameNotFoundException {
        validateName(name, "Name");
    }

    static void validateName(String name, String fieldName) throws NameNotFoundException {
        name = name.trim();
        Pattern regex = Pattern.compile("[^a-zA-Z\\s]+");
        if (name.isEmpty())
            throw new NameNotFoundException(fieldName + " field is empty");
        if (name.split(" ").length < 2)
            throw new NameNotFoundException(fieldName + " field must contain a surname");
        if (regex.matcher(name).find())
            throw new NameNotFoundException(fieldName + " contains Illegal characters");

    }

    static void validateEmail(String email) {
        Pattern regex = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        if (!regex.matcher(email).matches())
            throw new NullPointerException("Invalid Email");
    }

    static void validateOptions(RadioButton radioButton, String fieldName) {
        if (radioButton == null)
            throw new IllegalArgumentException("No " + fieldName + " selected");
    }
}
