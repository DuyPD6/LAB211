package Validation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Validate {
    private BufferedReader br;

    public Validate() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public BigInteger checkInteger(boolean base, String err) throws IOException {
        String number = "";
        String regex = base ? "^(2|10|16)$" : "[0-9]";

        do {
            number = br.readLine().trim();
            if (number.matches(regex)) {
                return new BigInteger(number);
            } else {
                System.out.println(err);
            }
        } while (!number.matches(regex));

        return BigInteger.ZERO;
    }

    public String checkValue(String inputBase, String err) throws IOException {
        String value = "";
        String regex = "";

        switch (inputBase.trim()) {
            case "2":
                regex = "[01]+";
                break;
            case "10":
                regex = "[0-9]+";
                break;
            case "16":
                regex = "[0-9A-F]+";
                break;
            default:
                System.out.println("Error input base!");
                System.exit(0);
        }

        do {
            value = br.readLine().toUpperCase().trim();
            if (value.matches(regex)) {
                return value;
            } else {
                System.out.println(err);
            }
        } while (!value.matches(regex));

        return err;
    }

    public void closeBufferedReader() throws IOException {
        br.close();
    }
}
