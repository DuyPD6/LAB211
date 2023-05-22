/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import DTO.FoodList;
import DTO.Menu;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;

/**
 *
 * @author A715-41G
 */
public class LAB1 {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        FoodList list = new FoodList();
        String filename = "food.txt";
        list.loadfromFile(filename);
        ArrayList<String> options = new ArrayList<>();
        options.add("Add new food");
        options.add("Remove by ID");
        options.add("Search by name");
        options.add("Print the list in descending order of expired date");
        options.add("Save to file");
        options.add("Search by weight");
        options.add("Quit");
        Menu menu = new Menu();
        int userChoice;
        do{
        userChoice = menu.getChoice(options);
        switch (userChoice){
            case 1: list.addFood(); break;
            case 2: list.removeFood();break;
            case 3: list.searchFood();break;
            case 4: list.printAll();break;
            case 5: list.savetoFile();break;
            case 6: list.searchFoodByWeight();break;
        }
        } while(userChoice >= 1 && userChoice < options.size());
        System.out.println("Credit Food Management - @2021 <SE160148 - Trinh Tuan Kiet");      
    }

}
