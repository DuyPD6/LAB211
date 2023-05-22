package Model;

import java.util.Objects;

public class History extends Worker implements Comparable<History> {
    private String status;
    private String date;

    public History() {
    }

    public History(String status, String date) {
        this.status = status;
        this.date = date;
    }

    public History(String id, String name, int age, int salary, String workLocation, String status, String date) {
        super(id, name, age, salary, workLocation);
        this.status = status;
        this.date = date;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public History status(String status) {
        setStatus(status);
        return this;
    }

    public History date(String date) {
        setDate(date);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " status='" + getStatus() + "'" +
                ", date='" + getDate() + "'" +
                "}";
    }

    @Override
    public int compareTo(History o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

}
