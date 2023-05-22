/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author A715-41G
 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Scanner;

/**
 *
 * @author A715-41G
 */
public class Input {
    public static Scanner sc = new Scanner(System.in);
    public Input() {
    }
    public static int inputInt(String msg, int min, int max){
        int data;
        do{
            System.out.print(msg);
            data= Integer.parseInt(sc.nextLine());
        } while (data<min || data >max);
        return data;
    }
    public static float inputWeight(String msg, int min){
        float data = -1;
        do{
            System.out.print(msg);
            try{
                data= Float.valueOf(sc.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Please type in a float :>>>");
            }
        } while (data<min);
        return data;
    }
    public static String inputNonBlankStr(String msg){
        String data;
        do{
            System.out.print(msg);
            data= sc.nextLine().trim();
        }while(data.length() < 1);
        return data;
    }
    public static String inputPStr(String msg, String pat){
        String data;
        do{
            System.out.print(msg);
            data= sc.nextLine().trim();
        }while(!data.matches(pat));
        return data;
    }
    public static LocalDate inputValidDate(String msg){
        String data;
        LocalDate date = null;
        do{
           System.out.print(msg);
           data= sc.nextLine().trim();
           if (!isValidDate(data)) System.out.println("Invalid Date");
           else {
               date = LocalDate.parse(data,DateTimeFormatter.ISO_LOCAL_DATE);
               if (date.isBefore(LocalDate.now())) System.out.println("Please don't type in date in the past, like you gonna eat expired food :>>");
           }
        }while (!isValidDate(data) || date.isBefore(LocalDate.now()));
        return LocalDate.parse(data,DateTimeFormatter.ISO_LOCAL_DATE);
    }
    private static boolean isValidDate(String date) {
        boolean valid;
        try {
            // ResolverStyle.STRICT for 30, 31 days checking, and also leap year.
            LocalDate.parse(date,DateTimeFormatter.ofPattern("uuuu-MM-dd").withResolverStyle(ResolverStyle.STRICT)
            );
            valid = true;
        } catch (DateTimeParseException e) {
            //e.printStackTrace();
            valid = false;
        }
        return valid;
    }        
}
