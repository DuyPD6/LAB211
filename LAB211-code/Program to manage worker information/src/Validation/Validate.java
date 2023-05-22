package Validation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Validate {
    private BufferedReader br;

    public Validate() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public int checkIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(br.readLine().trim());
                if (result < min || result > max) {
                    System.out.println("Please input number in range: " + min + " to " + max);
                } else {
                    return result;
                }
            } catch (IOException e) {
                System.out.println("An error occurred while reading user input: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Please input number in range: " + min + " to " + max);
            }
        }
    }

    public String checkInputString() {
        while (true) {
            try {
                String result = br.readLine().trim();
                if (result.isEmpty()) {
                    System.out.println("Cannot be empty");
                    System.out.println("Input again!");
                } else {
                    return result;
                }
            } catch (IOException e) {
                System.out.println("An error occurred while reading user input: " + e.getMessage());
            }
        }
    }

    public int checkInputSalary() {
        while (true) {
            String regex = "[0-9]+";
            try {
                String salary = br.readLine().trim();
                if (salary.matches(regex)) {
                    if (Integer.parseInt(salary) > 0) {
                        return Integer.parseInt(salary);
                    } else {
                        System.out.println("Salary change cannot be <= 0");
                    }
                } else {
                    System.out.println("Please input an integer number! ");
                }
            } catch (IOException e) {
                System.out.println("An error occurred while reading user input: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Please input an integer number! ");
            }
        }
    }

    public String checkInputName() {
        while (true) {
            try {
                String name = br.readLine().trim();
                String regex = "^[a-zA-Z ]+$";
                if (name.matches(regex)) {
                    return name;
                } else {
                    System.out.println("Please input a valid name!");
                }
            } catch (IOException e) {
                System.out.println("An error occurred while reading user input: " + e.getMessage());
            }
        }
    }
}
