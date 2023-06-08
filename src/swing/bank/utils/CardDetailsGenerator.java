package swing.bank.utils;

import com.devskiller.jfairy.Fairy;

import java.util.Random;

public class CardDetailsGenerator {
    /*
        (? <== ...) -> LookBehind: check if more pattern exists
        \\G -> ZeroBasedAssertion: matches (start of string / end of previous match) for first match
        . -> Delimiter: Matches any character
        {4} -> Quantifier: Match the pattern for 4 times
    */
    public static String generateCardNumber() {
        String cardNo = Fairy.create().creditCard().getCardNumber();
        return String.join("-", cardNo.split("(?<=\\G.{4})"));
    }

    public static int generateCardPin() {
        return new Random().nextInt(9000) + 1000;
    }

    public static void main(String[] args) {
        System.out.println(generateCardNumber() + generateCardPin());
    }
}
