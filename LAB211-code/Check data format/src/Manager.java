import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Validation.Validate;

class Manager {
    private Validate validate;
    private BufferedReader br;

    public Manager() {
        validate = new Validate();
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public void displayMenu() {
        System.out.println("===============Validate Program===============");
        validatePhoneNumber();
        validateDate();
        validateEmail();
        System.out.println("Everything is valid");
    }

    private void validatePhoneNumber() {
        String result = "";
        System.out.print("Phone number: ");
        do {
            try {
                String phoneCheck = br.readLine();
                result = validate.checkInputPhone(phoneCheck);
                System.out.println(result);
            } catch (IOException e) {
                System.out.println("An error occurred while reading input. Please try again.");
            }
        } while (!result.isEmpty());
    }

    private void validateDate() {
        String result = "";
        System.out.print("Date: ");
        do {
            try {
                String dateCheck = br.readLine();
                result = validate.checkInputDate(dateCheck);
                System.out.println(result);
            } catch (IOException e) {
                System.out.println("An error occurred while reading input. Please try again.");
            }
        } while (!result.isEmpty());
    }

    private void validateEmail() {
        String result = "";
        System.out.print("Email: ");
        do {
            try {
                String emailCheck = br.readLine();
                result = validate.checkInputEmail(emailCheck);
                System.out.println(result);
            } catch (IOException e) {
                System.out.println("An error occurred while reading input. Please try again.");
            }
        } while (!result.isEmpty());
    }
}
