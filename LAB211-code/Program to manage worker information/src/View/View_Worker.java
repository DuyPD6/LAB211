package View;

import java.util.List;

import BO.BO_Worker;
import Model.History;
import Model.Worker;
import Validation.Validate;

public class View_Worker {
    Validate validate = new Validate();
    BO_Worker bo = new BO_Worker();

    public void displayMenu() {
        System.out.println("1.  Add Worker: ");
        System.out.println("2.  Up Salary: ");
        System.out.println("3.  Down Salary: ");
        System.out.println("4.  Display Information Salary: ");
        System.out.println("5.  Exit!");
        System.out.println("Enter your choice: ");
        int choice = validate.checkIntLimit(1, 5);
        if (choice == 1) {
            addWorker();
        } else if (choice == 2) {
            upSalary();
        } else if (choice == 3) {
            downSalary();
        } else if (choice == 4) {
            printListHistory();
        } else if (choice == 5) {
            System.exit(0);
        } else {
            System.out.println("Please input from 1 to 5!");
        }
    }

    public void addWorker() {
        System.out.println("Enter code: ");
        String id = validate.checkInputString();
        while (bo.checkIDExisted(id)) {
            System.out.println("Worker is existed! ");
            System.out.println("Input again: ");
            id = validate.checkInputString();
        }
        System.out.println("Enter name: ");
        String name = validate.checkInputName();

        System.out.println("Enter age: ");
        int age = validate.checkIntLimit(18, 50);

        System.out.println("Enter salary: ");
        int salary = validate.checkInputSalary();

        System.out.println("Enter work location: ");
        String workLocation = validate.checkInputString();

        bo.addWorker(id, name, age, salary, workLocation);
        System.out.println("Add Successfully! ");
    }

    public void upSalary() {
        String result = "";
        System.out.println("Enter code: ");
        String id = validate.checkInputString();
        Worker worker = bo.getWorkerByCode(id);
        if (worker == null) {
            System.out.println("ID is not existed! ");

        } else {
            System.out.println("Enter new salary: ");
            do {
                int newSalary = validate.checkInputSalary();
                result = bo.changeSalary(newSalary, "1");
                System.out.println(result);
            } while (result != "Add Successfully");
            bo.addHistory("UP", bo.getCurrentDate(), worker.getId(), worker.getName(), worker.getAge(),
                    worker.getSalary(), worker.getWorkLocation());
        }
    }

    public void downSalary() {
        String result = "";
        System.out.println("Enter code: ");
        String id = validate.checkInputString();
        Worker worker = bo.getWorkerByCode(id);
        if (worker == null) {
            System.out.println("ID is not existed!");
        } else {
            System.out.println("Enter salary: ");
            do {
                int newSalary = validate.checkInputSalary();
                result = bo.changeSalary(newSalary, "0");
                System.out.println(result);
            } while (result != "Add Successfully");
            bo.addHistory("DOWN", bo.getCurrentDate(), worker.getId(), worker.getName(), worker.getAge(),
                    worker.getSalary(), worker.getWorkLocation());
        }
    }

    public void printListHistory() {
        List<History> listHistories = bo.getAllHistories();
        if (listHistories.isEmpty()) {
            System.out.println("List is empty. Please modify a history!");
        } else {
            System.out.println(
                    "--------------------------------------------------Display imformation salary--------------------------------------------------");
            System.out.printf("%-15s%-15s%-5s%-15s%-10s%-20s\n", "Code", "Name", "Age", "Salary", "Status", "Date");
            for (History history : listHistories) {
                System.out.printf("%-15s%-15s%-5s%-15s%-10s%-20s\n", history.getId(), history.getName(),
                        history.getAge(), history.getSalary(), history.getStatus(), history.getDate());
            }
        }
    }
}
