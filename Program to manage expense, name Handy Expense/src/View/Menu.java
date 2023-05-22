package View;

import Validation.Validate;

public class Menu {
    public void displayMenu() {
        Validate validate = new Validate();
        View_Expense controller = new View_Expense();
        while (true) {
            System.out.println("========================Handy Expense Program========================");
            System.out.println("1.   Add an expense");
            System.out.println("2.   Display all expenses");
            System.out.println("3.   Delete an expense");
            System.out.println("4.   Quit");
            String choice = validate.getChoice("Your choice: ", "Please input 1-4!", 1, 4).trim();

            switch (choice) {
                case "1":
                    controller.addExpense();
                    break;
                case "2":
                    controller.displayAllExpenses();
                    break;
                case "3":
                    controller.deleteExpense();
                    break;
                case "4":
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}
