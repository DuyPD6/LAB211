package Model;

import java.util.Objects;

public class Worker {
    private String id;
    private String name;
    private int age;
    private int salary;
    private String workLocation;

    public Worker() {
    }

    public Worker(String id, String name, int age, int salary, String workLocation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.workLocation = workLocation;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return this.salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getWorkLocation() {
        return this.workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    public Worker id(String id) {
        setId(id);
        return this;
    }

    public Worker name(String name) {
        setName(name);
        return this;
    }

    public Worker age(int age) {
        setAge(age);
        return this;
    }

    public Worker salary(int salary) {
        setSalary(salary);
        return this;
    }

    public Worker workLocation(String workLocation) {
        setWorkLocation(workLocation);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", age='" + getAge() + "'" +
                ", salary='" + getSalary() + "'" +
                ", workLocation='" + getWorkLocation() + "'" +
                "}";
    }
}
