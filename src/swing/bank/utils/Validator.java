package swing.bank.utils;

import swing.bank.components.Buttons.RadioButton;

import javax.naming.NameNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class Validator {
    public static void validateName(String name) throws NameNotFoundException {
        validateName(name, "Name");
    }

    public static void validateName(String name, String fieldName) throws NameNotFoundException {
        name = name.trim();
        Pattern regex = Pattern.compile("[^a-zA-Z\\s]+");
        if (name.isEmpty())
            throw new NameNotFoundException(fieldName + " field is empty");
        if (name.split(" ").length < 2)
            throw new NameNotFoundException(fieldName + " field must contain a surname");
        if (regex.matcher(name).find())
            throw new NameNotFoundException(fieldName + " contains Illegal characters");

    }

    public static void validateEmail(String email) throws NullPointerException {
        Pattern regex = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        if (!regex.matcher(email).matches())
            throw new NullPointerException("Invalid Email");
    }

    public static void validateOptions(RadioButton radioButton, String fieldName) throws IllegalArgumentException {
        if (radioButton == null)
            throw new IllegalArgumentException("No " + fieldName + " selected");
    }
  
    public static void validateDate(String date) throws IllegalArgumentException {
        if (date == null)
            throw new IllegalArgumentException("No Date of Birth selected");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        Date birthDate;
        try {
            birthDate = dateFormat.parse(date);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid Date Format. Please pick a valid date.");
        }
        Calendar now = Calendar.getInstance(),
                dob = Calendar.getInstance();
        now.setTime(birthDate);

        // Calculate age based on current date
        int age = now.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        if (now.get(Calendar.MONTH) < dob.get(Calendar.MONTH) ||
                (now.get(Calendar.MONTH) == dob.get(Calendar.MONTH) &&
                        now.get(Calendar.DAY_OF_MONTH) < dob.get(Calendar.DAY_OF_MONTH)))
            age--;
        if (age < 1)
            throw new IllegalArgumentException("Age Invalid.");
        if (age < 18)
            throw new IllegalArgumentException("Age must be more than 18 Years to sign up.");
        if (age > 100)
            throw new IllegalArgumentException("Age must be less than 100 Years to sign up.");
    }
    
    public static void validateSelection(String selection, String fieldName) throws IllegalArgumentException {
        if (selection == null)
            throw new IllegalArgumentException("Please select " + fieldName);
    }
    
    public static void validatePan(String panNumber) throws IllegalArgumentException {
        if (panNumber == null)
            throw new IllegalArgumentException("Please enter your PAN Number");
    }
    
    public static void validateAadhaar(String aadhaarNumber) throws IllegalArgumentException {
        if (aadhaarNumber == null)
            throw new IllegalArgumentException("Please enter your Aadhaar Number");
    }

}
