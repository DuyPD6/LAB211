package View;

import Validation.Validate;

public class Menu {
    public void displayMenu() {
        Validate validate = new Validate();
        View_Task task = new View_Task();
        do {
            System.out.println("==========================Task Program==========================");
            System.out.println("\t1.    Add Task");
            System.out.println("\t2.    Delete Task");
            System.out.println("\t3.    Display Task");
            System.out.println("\t4.    Exit");

            int choice = validate.getInt("Your choice: ", "Please input from 1 to 4!", 1, 4);
            switch (choice) {
                case 1:
                    task.addTask();
                    break;
                case 2:
                    task.deleteTask();
                    break;
                case 3:
                    task.getDataTask();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Invalid input!");
                    break;
            }
        } while (true);
    }
}
