package View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

import Controller.ChangeBase;
import Validation.Validate;

public class Menu {

    public void displayMenu() {
        Validate validate = new Validate();
        ChangeBase changeBase = new ChangeBase();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputBase, outputBase;
        String inputValue, choose;

        do {
            try {
                System.out.println("Please choose the base of input number (2, 10, 16): ");
                inputBase = validate.checkInteger(true, "Please write base of input number again! ").toString();

                System.out.println("Please choose the base of output number: (2, 10, 16): ");
                outputBase = validate.checkInteger(true, "Please write base of output number again! ").toString();

                System.out.println("Please enter the input value: ");
                inputValue = validate.checkValue(inputBase,
                        "You wrote wrong format (0 and 1 for base 2, 0 to 10 for base 10, 0 to F for base 16! )")
                        .toUpperCase().toString();

                BigInteger base10Value = changeBase.anyToBase10(inputBase, inputValue);
                String outputValue = changeBase.base10ToAny(outputBase, base10Value).toString();

                System.out.println("\n" + inputValue + " from base " + inputBase + " to base " + outputBase + " is: "
                        + outputValue);

                System.out.println("\n---------------------------------\nInput 'y' to run again, else to exit!");
                choose = br.readLine().toUpperCase().trim();

                if (!choose.equals("Y")) {
                    System.exit(0);
                }
            } catch (IOException e) {
                System.out.println("An error occurred while reading user input: " + e.getMessage());
            }
        } while (true);
    }
}
