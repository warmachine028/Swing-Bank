package swing.bank;

import swing.bank.components.Buttons.RadioButton;

import javax.naming.NameNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

    static void validateEmail(String email) throws NullPointerException {
        Pattern regex = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        if (!regex.matcher(email).matches())
            throw new NullPointerException("Invalid Email");
    }

    static void validateOptions(RadioButton radioButton, String fieldName) throws IllegalArgumentException {
        if (radioButton == null)
            throw new IllegalArgumentException("No " + fieldName + " selected");
    }
  
    static void validateDate(String date) throws IllegalArgumentException {
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
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(birthDate);

        // Calculate age based on current date
        Calendar currentDate = Calendar.getInstance();
        int age = currentDate.get(Calendar.YEAR) - calendar.get(Calendar.YEAR);

        if (age < 1)
            throw new IllegalArgumentException("Age Invalid.");
        if (age < 18)
            throw new IllegalArgumentException("Age must be more than 18 Years to sign up.");
        if (age > 100)
            throw new IllegalArgumentException("Age must be less than 100 Years to sign up.");
    }
    
    static void validateSelection(String selection, String fieldName) throws IllegalArgumentException {
        if (selection == null)
            throw new IllegalArgumentException("Please select " + fieldName);
    }
    
    static void validatePan(String panNumber) throws IllegalArgumentException {
        if (panNumber == null)
        throw new IllegalArgumentException("Please enter your PAN Number");
    }
    
    static void validateAadhaar(String aadhaarNumber) throws IllegalArgumentException {
        if (aadhaarNumber == null)
        throw new IllegalArgumentException("Please enter your Aadhaar Number");
    }
    
    static String validateSeniorCitizen(Date dateOfBirth) {
        String CurrentDate = "";
//        if (currentDate - dateOfBirth > 60)
//            return "Yes";
        return "No";
    }
}
