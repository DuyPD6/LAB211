package Validation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;

import Model.Account;
import Model.ListAccountDatabase;

import java.text.SimpleDateFormat;

public class Validate {
    private BufferedReader br;

    public Validate() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String getChoice(String message, int min, int max) {
        String regex = "[1-3]{1}";
        String input = "";
        do {
            System.out.println(message);
            try {
                input = br.readLine();
                if (!input.matches(regex)) {
                    System.out.println("Invalid input! Please try again");
                    continue;
                } else {
                    return input;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (true);
    }

    public String getAccountNumber(String message, String err) {
        String accountNumber = "";
        String regex = "^[0-9]{10}$";
        do {
            System.out.println(message);
            try {
                accountNumber = br.readLine();
            } catch (IOException e) {
                System.out.println(err);
            }
            if (accountNumber.matches(regex)) {
                break;
            } else {
                System.out.println(err);
            }
        } while (true);
        return accountNumber;
    }

    public String getPassword(String message, String err) {
        String accountPassword = "";
        String regex = "^(?=.*[a-zA-Z0-9])[a-zA-Z0-9!@#$%^&*()-=_+\\[\\]{}|;:',.<>/?]{8,31}$";
        do {
            System.out.println(message);
            try {
                accountPassword = br.readLine();
            } catch (IOException e) {
                System.out.println(err);
            }
            if (accountPassword.matches(regex)) {
                break;
            } else {
                System.out.println(err);
            }
        } while (true);
        return accountPassword;
    }

    public String getCaptcha(String message, String err) {
        String captcha = "";
        System.out.println(message);
        try {
            captcha = br.readLine();
            if (captcha.trim().isEmpty()) {
                System.out.println(err);
            }
        } catch (Exception e) {
            System.out.println(err);
        }
        return captcha;
    }

    public boolean checkAccount(String accountNumber) {
        ListAccountDatabase listAccountFixed = new ListAccountDatabase();
        ArrayList<Account> accountList = listAccountFixed.database();
        if (accountList.isEmpty()) {
            return false;
        } else {
            for (Account account : accountList) {
                if (account.getAccountNumber().trim().equals(accountNumber.trim())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkPassword(String accountPassword) {
        ListAccountDatabase listAccountFixed = new ListAccountDatabase();
        ArrayList<Account> accountList = listAccountFixed.database();
        if (accountList.isEmpty()) {
            return false;
        } else {
            for (Account account : accountList) {
                if (account.getPassword().trim().equals(accountPassword.trim())) {
                    return true;
                }
            }
        }
        return false;
    }
}
