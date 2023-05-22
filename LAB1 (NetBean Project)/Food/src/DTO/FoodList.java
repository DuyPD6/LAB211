/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author A715-41G
 */
public class FoodList extends ArrayList<Food>{
    public FoodList() {
        super();
    }    
    public void addFood(){
        //para
        String ID;
        String name;
        float weight;
        String type;
        int place;
        LocalDate expdate;
        //input
        System.out.println("Add new food:");
        do{
            ID = Input.inputNonBlankStr("ID : ");
            if (isIDExist(ID)) System.out.println("ID existed");
        } while (isIDExist(ID));
        name = Input.inputNonBlankStr("Name : ");
        weight = Input.inputWeight("Weight(kg) : ",0);
        type = Input.inputNonBlankStr("Type : ");
        place = Input.inputInt("Place (1: Freezer ; 2: Freezer Door; 3 : Regular; 4 : Door) : ", 1, 4);
        expdate = Input.inputValidDate("Expired Date (yyyy-mm-dd): ");
        //add
        this.add(new Food(ID, name, weight, type, place, expdate));
        System.out.println("Added successful");
        if (Input.inputPStr("Do you want to add another item (Y/N)? ","[YN]").equals("Y")) this.addFood();
        else System.out.println("End adding");
    }
    public void removeFood(){
        if (this.isEmpty()) {
            System.out.println("Empty list.");
        } else {
            String rID = Input.inputNonBlankStr("Type in ID of the food you want to remove : ");
            int pos = pos(rID);
            if (pos < 0) {
                System.out.println("The Food does not exist. Remove Unsuccessfull");
            } else {
                String warning = Input.inputPStr("Are you sure you want to remove" + this.get(pos).Name + "? (Y/N) : ","[YN]");
                if ("Y".equals(warning)) {
                    this.remove(pos);
                    System.out.println(rID + " is removed.");
                } else System.out.println("Remove call cancel ! ");
            }
        }
    }
    public void printAll() {
        if (this.isEmpty()) {
            System.out.println("Empty list.");
        } else {
            System.out.println("FOOD LIST");
            System.out.println("---------------------------------");
            for (int i = 0 ; i< this.size()-1; i++)
                for (int j = i+1 ; j < this.size(); j++){
                    if (this.get(i).expdate.isBefore(this.get(j).expdate)){
                        Food temp;
                        temp = this.get(i);
                        this.set(i, this.get(j));
                        this.set(j, temp);
                    }
                }                   
            for (Food x : this) {
                System.out.println(x.toString());
            }
            System.out.println("Total: " + this.size() + " item(s).");
        }
    }
    public void searchFood(){
        if (this.isEmpty()) {
            System.out.println("Empty list.");
        }else{
            String keyword;
            keyword = Input.inputNonBlankStr("What do you want to search : ");
            String reg = ".*("+ keyword +").*";
            boolean checkEmpty = true;
            for (Food x : this) {
                if (x.Name.matches(reg)) {
                    System.out.println(x.toString());
                    checkEmpty = false;
                }
            }
            if (checkEmpty) System.out.println("This food does not exist");
            if (Input.inputPStr("Do you want to continue searching (Y/N)? ","[YN]").equals("Y")) this.searchFood();
        }
    }
    public void searchFoodByWeight(){
        if (this.isEmpty()) {
            System.out.println("Empty list.");
        }else{
            float keyword;
            keyword = Input.inputWeight("What do you want to search (by weight) : ", 0);
            boolean checkEmpty = true;
            for (Food x : this) {
                if (x.weight >= keyword) {
                    System.out.println(x.toString());
                    checkEmpty = false;
                }
            }
            if (checkEmpty) System.out.println("This food does not exist");
            if (Input.inputPStr("Do you want to continue searching (Y/N)? ","[YN]").equals("Y")) this.searchFoodByWeight();
        }
    }
    public void savetoFile(){
        if (this.isEmpty()) { // If there's no data in list
            System.out.println("Empty list!");
        } else {
            System.out.print("Type in Name of file : ");
            Scanner sc = new Scanner(System.in);
            String filename = sc.nextLine().trim();
            filename = filename + ".txt";
            try {
                File f = new File(filename);
                FileWriter fw = new FileWriter(f);
                for (Food e : this) {
                    // Write data into file
                    fw.write(e.getID() + "," 
                            + e.getName() + "," 
                            + e.getWeight()+","
                            + e.getType() + ","
                            + e.getPlace() + ","
                            + e.getExpdate());
                    fw.write("\n");
                }
                System.out.println("Save successfull!");
                fw.close();
            } catch (Exception e) {
                System.out.println(e);
            }
            
        }        
    }
    public void loadfromFile (String filename){
        try {
            File f = new File(filename);
            Scanner myReader = new Scanner(f);
            while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            String[] split = data.split(",");
            String ID = split[0];
            String name = split[1];
            float weight = Float.parseFloat(split[2]);
            String type = split[3];
            int place = Integer.parseInt(split[4]);
            LocalDate expdate = LocalDate.parse(split[5],DateTimeFormatter.ISO_LOCAL_DATE);         
            this.add(new Food(ID, name, weight, type, place, expdate));
            }
        } catch (Exception e) {
                System.out.println(e);
            } 
    }
    private int pos(String ID) {
        if (!this.isEmpty()) {
            for (int i = 0; i < this.size(); i++) {
                if (this.get(i).getID().equals(ID)) {
                    return i;
                }
            }      
        }
        return -1;
    }    
    private boolean isIDExist(String ID){
        return search(ID) != null;
    }
    private Food search(String ID) {
        for (Food x : this) {
            if (x.getID().equals(ID)) {
                return x;
            }
        }
        return null;
    }    
}
