import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Validation.Validate;

class Manager {
    void displayMenu() {
        Validate validate = new Validate();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String result = "";
        System.out.println("===============Validate Program===============");
        try {
            System.out.print("Phone number: ");
            do {
                String phoneCheck = br.readLine();
                result = validate.checkInputPhone(phoneCheck);
                System.out.println(result);
            } while (!result.isEmpty());

            System.out.print("Date: ");
            do {
                String dateCheck = br.readLine();
                result = validate.checkInputDate(dateCheck);
                System.out.println(result);
            } while (!result.isEmpty());

            System.out.print("Email: ");
            do {
                String emailCheck = br.readLine();
                result = validate.checkInputEmail(emailCheck);
                System.out.println(result);
            } while (!result.isEmpty());
            System.out.println("Everything is valid");
        } catch (IOException e) {
            System.out.println("An error occurred while reading input. Please try again.");
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                System.out.println("An error occurred while closing the input stream.");
            }
        }
    }
}
