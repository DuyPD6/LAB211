package Model;

import java.util.Objects;

public class Expense {
    private int ID;
    private String date;
    private double number;
    private String content;

    public Expense() {
    }

    public Expense(int ID, String date, double number, String content) {
        this.ID = ID;
        this.date = date;
        this.number = number;
        this.content = content;
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getNumber() {
        return this.number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "{" +
                " ID='" + getID() + "'" +
                ", date='" + getDate() + "'" +
                ", number='" + getNumber() + "'" +
                ", content='" + getContent() + "'" +
                "}";
    }
}
