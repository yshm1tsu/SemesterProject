package services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Checker {

    public Checker() {
    }

    public boolean emailChecker(String email) {
        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$");
        Matcher matcher = pattern.matcher(email);
        if (email.matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$")) {
            return true;
        } else {
            return false;
        }
    }

}