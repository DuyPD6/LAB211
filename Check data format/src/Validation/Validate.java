package Validation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validate {
    private BufferedReader br;
    private static final String PHONE_VALID_REGEX = "^[0-9]{10}$";
    private static final String EMAIL_VALID_REGEX = "^[A-Za-z0-9]+@[A-Za-z]+(\\.[0-9A-Za-z]{2,4})+$";

    public Validate() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String checkInputPhone(String phoneCheck) {
        try {
            if (!phoneCheck.matches(PHONE_VALID_REGEX)) {
                return "Phone number must be 10 digits!";
            } else {
                return "";
            }
        } catch (NumberFormatException e) {
            System.out.println("Phone number must be number");
        }
        return null;
    }

    public String checkInputDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dateFinal = null;
        sdf.setLenient(false);
        try {
            dateFinal = sdf.parse(date);
        } catch (Exception e) {
            return "Date must be correct format: dd/MM/yyyy";
        }
        return "";
    }

    public String checkInputEmail(String email) {
        if (!email.matches(EMAIL_VALID_REGEX)) {
            return "Email must be correct format!";
        } else {
            return "";
        }
    }

    public void closeBufferedReader() {
        try {
            br.close();
        } catch (IOException e) {
            System.out.println("An error occurred while closing the input stream.");
        }
    }
}
