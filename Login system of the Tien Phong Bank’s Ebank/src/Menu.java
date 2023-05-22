import java.util.Locale;

import Validation.Validate;

public class Menu {
    void displayMenu() {
        Validate validate = new Validate();
        Ebank ebank = new Ebank();
        Login login = new Login();
        do {
            System.out.println("--------------------Login Program--------------------");
            System.out.println("1. Vietnamese");
            System.out.println("2. English");
            System.out.println("3. Exit");
            String choice = validate.getChoice("Please choice one option: ", 1, 3);
            switch (choice) {
                case "1":
                    ebank.setLocale(Locale.forLanguageTag("vi"));
                    login.login(Locale.forLanguageTag("vi"));
                    break;
                case "2":
                    ebank.setLocale(Locale.forLanguageTag("en"));
                    login.login(Locale.forLanguageTag("en"));
                    break;
                case "3":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please check input !");
                    break;
            }
        } while (true);
    }
}
