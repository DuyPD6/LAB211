/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;
import java.time.LocalDate;
/**
 *
 * @author A715-41G
 */
public class Food implements Comparable<Food>{
    String ID;
    String Name;
    float weight;
    String type;
    int place;
    LocalDate expdate;
    
    public Food() {        
    }
    public Food(String ID, String Name, float weight, String type, int place, LocalDate expdate) {
        this.ID = ID;
        this.Name = Name;
        this.weight = weight;
        this.type = type;
        this.place = place;
        this.expdate = expdate;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public LocalDate getExpdate() {
        return expdate;
    }

    public void setExpdate(LocalDate expdate) {
        this.expdate = expdate;
    }
    @Override
    public int compareTo(Food o){
        return getID().compareTo(o.getID());
    }
    @Override
    public String toString() {
        return "ID=" + ID + ", Name=" + Name + ", weight=" + weight + "(kg), type=" + type + ", place=" + place + ", expdate=" + expdate;
    }
    
    
}
