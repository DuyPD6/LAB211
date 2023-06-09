import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import Model.Account;
import Model.ListAccountDatabase;

public class Login {
    private ResourceBundle resourceBundle;
    private ListAccountDatabase listAccount = new ListAccountDatabase();
    private List<Account> accountList = listAccount.getAccounts();

    public void login(Locale locale) {
        Ebank ebank = new Ebank();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        resourceBundle = ResourceBundle.getBundle("Languages/language", locale);
        String accountNumber = "";
        String password = "";
        String captcha = "";
        String generateCaptcha = "";
        String checkResult = null;
        boolean accountExist = false;

        System.out.println(resourceBundle.getString("accountNumber"));
        do {
            checkResult = null;
            try {
                accountNumber = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            checkResult = ebank.checkAccountNumber(accountNumber);
            if (checkResult != null) {
                System.out.println(checkResult);
            }
        } while (checkResult != null);

        System.out.println(resourceBundle.getString("Password"));
        do {
            checkResult = null;
            try {
                password = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            checkResult = ebank.checkPassword(password);
            if (checkResult != null) {
                System.out.println(checkResult);
            }
        } while (checkResult != null);

        do {
            generateCaptcha = ebank.generateCaptcha();
            System.out.println(resourceBundle.getString("Captcha") + generateCaptcha);
            System.out.print(resourceBundle.getString("inputCaptcha"));
            try {
                captcha = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            checkResult = ebank.checkCaptcha(captcha, generateCaptcha);
            if (checkResult != null) {
                System.out.println(checkResult);
            }
        } while (checkResult != null);

        for (Account account : accountList) {
            if (!account.getAccountNumber().equals(accountNumber) && !(account.getPassword().equals(password))) {
                accountExist = false;
            } else {
                accountExist = true;
                break;
            }
        }

        if (accountExist) {
            System.out.println(resourceBundle.getString("LoginSuccess"));
        } else {
            System.out.println(resourceBundle.getString("LoginFail"));
        }
    }
}