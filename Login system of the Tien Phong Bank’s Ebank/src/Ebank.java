import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

public class Ebank {
    private static ResourceBundle resources;

    public void setLocale(Locale locale) {
        resources = ResourceBundle.getBundle("Languages/language_" + locale, locale);
    }

    public String checkAccountNumber(String accountNumber) {
        String regex = "^[0-9]{10}$";
        if (accountNumber.matches(regex)) {
            return null;
        } else {
            return resources.getString("inputNumberError");
        }
    }

    public String checkPassword(String password) {
        if (resources == null) {
            throw new IllegalStateException("Locale has not been set. Call setLocale() before using this method.");
        }
        String regex = "^[a-zA-Z0-9]*(([a-zA-Z]+[0-9]+)|[0-9]+[a-zA-Z]+)[a-zA-Z0-9]*$";
        if (password.matches(regex)) {
            return null;
        } else {
            return resources.getString("inputPasswordError");
        }
    }

    public String generateCaptcha() {
        if (resources == null) {
            throw new IllegalStateException("Locale has not been set. Call setLocale() before using this method.");
        }
        String finalCaptcha = "";

        String temp = "";
        for (char c = 'a'; c <= 'z'; c++) {
            temp += c;
        }

        for (char c = 'A'; c <= 'Z'; c++) {
            temp += c;
        }

        for (char c = '0'; c <= '9'; c++) {
            temp += c;
        }
        do {
            String captcha = "";
            boolean lowerChar = false;
            boolean upperChar = false;
            boolean digit = false;

            for (int i = 0; i < 5; i++) {
                Random random = new Random();
                int index = random.nextInt(temp.length());
                char newChar = temp.charAt(index);

                if (newChar >= 'a' && newChar <= 'z') {
                    lowerChar = true;
                } else if (newChar >= 'A' && newChar <= 'Z') {
                    upperChar = true;
                } else {
                    digit = true;
                }
                captcha += newChar;
            }
            if (digit && lowerChar && upperChar) {
                finalCaptcha = captcha;
                break;
            } else {
                continue;
            }
        } while (true);
        return finalCaptcha;
    }

    public String checkCaptcha(String captchaInput, String captchaGenerate) {
        if (resources == null) {
            throw new IllegalStateException("Locale has not been set. Call setLocale() before using this method.");
        }
        if (captchaInput.isEmpty()) {
            return resources.getString("CaptchaError");
        } else if (captchaGenerate.contains(captchaInput.trim())) {
            return null;
        } else {
            return resources.getString("CaptchaError");
        }
    }

}
