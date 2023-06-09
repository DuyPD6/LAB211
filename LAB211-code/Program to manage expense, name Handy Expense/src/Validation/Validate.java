package Validation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validate {
    private BufferedReader br;

    public Validate() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String getChoice(String msg, String err, int min, int max) {
        String num = "";
        boolean check;
        String regex = "^[" + min + "-" + max + "]$";
        do {
            check = true;
            System.out.println(msg);
            try {
                num = br.readLine();
                if (!num.matches(regex)) {
                    System.out.println(err);
                    check = false;
                }
            } catch (IOException e) {
                System.out.println(err);
            }
        } while (!check);
        return num;
    }

    public String checkYesNo(String msg, String err) {
        String regex = "^[YyNn]";
        String output = "";
        boolean check;
        System.out.println(msg);
        do {
            check = true;
            try {
                output = br.readLine();
                if (!output.matches(regex)) {
                    System.out.println(err);
                    check = false;
                }
            } catch (IOException e) {
                System.out.println(err);
            }
        } while (!check);
        return output;
    }

    public String getDouble(String msg, String err, double min, double max) {
        String num = "";
        boolean check;
        String regex = String.format("^(?:%s|%s|\\d+(?:\\.\\d+)?)$", String.valueOf(min), String.valueOf(max));

        do {
            check = true;
            System.out.println(msg);
            try {
                num = br.readLine();
                if (!num.matches(regex)) {
                    System.out.println(err);
                    check = false;
                }
            } catch (IOException e) {
                System.out.println(err);
            }
        } while (!check);
        return num;
    }

    public Date getDate(String msg, String err, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = null;
        sdf.setLenient(false);
        while (true) {
            try {
                System.out.println(msg);
                String value = br.readLine();
                date = sdf.parse(value);
                Date now = new Date();
                if (date.after(now)) {
                    System.out.println(err);
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Please input a real day format: day/month/year");
            }
        }
        return date;
    }

    public String getContent(String msg) {
        String content = "";
        do {
            System.out.println(msg);
            try {
                content = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (content.trim().equals(""));
        return content;
    }
}
