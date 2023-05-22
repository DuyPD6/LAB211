package Validation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Validate {
    private BufferedReader br;

    public Validate() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public int getInt(String msg, String err, int min, int max) {
        String input;
        int result;
        do {
            System.out.println(msg);
            try {
                input = br.readLine();
            } catch (IOException e) {
                System.err.println(err);
                continue;
            }
            if (input.isEmpty()) {
                System.err.println(err);
            } else {
                try {
                    result = Integer.parseInt(input);
                    if (result >= min && result <= max) {
                        break;
                    }else{
                        System.err.println(err);
                    }
                } catch (NumberFormatException e) {
                    System.err.println(err);
                    continue;
                }
            }
        } while (true);
        return result;
    }

    public String getString(String msg, String err, String regex) {
        String input = "";
        do {
            System.out.println(msg);
            try {
                input = br.readLine();
            } catch (IOException e) {
                System.err.println("Input is not valid");
                continue;
            }
            if (input.isEmpty()) {
                System.err.println("Input could not be empty!");
                continue;
            } else if (input.matches(regex)) {
                break;
            } else {
                System.err.println(err);
                continue;
            }
        } while (true);
        return input;
    }

    public Date getDate(String msg, String err, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = null;
        sdf.setLenient(false);
        while (true) {
            System.out.println(msg);
            try {
                String value = br.readLine();
                try {
                    date = sdf.parse(value);
                } catch (ParseException e) {
                    System.err.println(err);
                    continue;
                }
                Date now = new Date();
                if (date.before(now)) {
                    System.err.println("Date could not be in the past!");
                    continue;
                }
                break;
            } catch (IOException e) {
                System.err.println("Please input the format: " + format);
                continue;
            }
        }
        return date;
    }

    public String getTaskType(String msg, String err) {
        int taskTypeID = getInt(msg, err, 1, 4);
        String result = "";
        do {
            switch (taskTypeID) {
                case 1:
                    result = "Code";
                    break;
                case 2:
                    result = "Test";
                    break;
                case 3:
                    result = "Design";
                    break;
                case 4:
                    result = "Review";
                    break;
                default:
                    System.err.println(err);
                    result = "";
                    break;
            }
        } while (result.equals(""));
        return result;
    }

    public Double getDouble(String msg, String err, double min, double max) {
        double result;
        String input;
        String regex = "^(?:[89]|1[0-7])(?:\\.[05])?$";
        do {
            input = getString(msg, err, regex);
            if (input.isEmpty()) {
                System.err.println(err);
            } else {
                try {
                    result = Double.parseDouble(input);
                    if (result >= min && result <= max) {
                        break;
                    } else {
                        System.err.println(err);
                    }
                } catch (NumberFormatException e) {
                    System.err.println(err);
                }
            }
        } while (true);
        return result;
    }
}
