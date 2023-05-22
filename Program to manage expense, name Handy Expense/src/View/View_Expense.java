package View;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import BO.BO_Expense;
import Model.Expense;
import Validation.Validate;

public class View_Expense {
    private BO_Expense expenseBO = new BO_Expense();
    private Validate validate = new Validate();

    public void addExpense() {
        System.out.println("-----------------------Add an expense-----------------------");
        int id = 1;
        boolean checkIfExpenseExisted;
        List<Expense> listExpenses = expenseBO.getListExpenses();
        if (!listExpenses.isEmpty()) {
            id = listExpenses.get(listExpenses.size() - 1).getID() + 1;
        }

        Date dateInput = validate.getDate("Enter Date: ", "Please enter the past!", "dd-MM-yyyy");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
        String date = sdf.format(dateInput);

        double amount = Double.parseDouble(
                validate.getDouble("Enter Amount: ", "Please enter an positive number!", 0, Double.MAX_VALUE));
        String content = validate.getContent("Enter Content: ");
        checkIfExpenseExisted = expenseBO.checkExist(date, amount, content);
        Expense expense = new Expense(id, date, amount, content);
        if (!checkIfExpenseExisted == false) {
            String confirm = validate.checkYesNo("This content is existed. Y to add this content or N to cancel",
                    "Please only input Y or N!").trim();
            if (confirm.equalsIgnoreCase("y")) {
                expenseBO.addExpense(expense);
                System.out.println("Add successfully");
            } else if (confirm.equalsIgnoreCase("n")) {
                System.out.println("Cancel successfully");
            } else {
                System.out.println("Input is not valid!");
            }
        } else {
            expenseBO.addExpense(expense);
            System.out.println("Add successfully");
        }
    }

    public void displayAllExpenses() {
        List<Expense> listExpenses = expenseBO.getListExpenses();
        if (listExpenses.isEmpty()) {
            System.out.println("List is empty. Please add an expense!");
        } else {
            System.out.println("-----------------------Display all expenses-----------------------");
            double total = 0;
            System.out.format("%-5s %-23s %-30s %s%n", "ID", "Date", "Amount of money", "Content");
            for (Expense expense : listExpenses) {
                System.out.format("%-5s %-23s %-30s %s%n", expense.getID(), expense.getDate(),
                        expense.getNumber(), expense.getContent());
                total += expense.getNumber();
            }
            System.out.format("%67s %.2f%n", "Total:", total);
        }
    }

    public void deleteExpense() {
        List<Expense> listExpenses = expenseBO.getListExpenses();
        boolean isIDExisted = false;
        if (listExpenses.isEmpty()) {
            System.out.println("List is empty. Please add an expense!");
        } else {
            System.out.println("-----------------------Delete an expense-----------------------");
            int deleteID = Integer
                    .parseInt(validate.getDouble("Enter ID", "Must be positive value!", 0, Double.MAX_VALUE));
            isIDExisted = expenseBO.deleteExpense(deleteID);
        }
        if (isIDExisted == false) {
            System.out.println("Expense is not existed!");
        } else {
            System.out.println("Expense is deleted");
        }
    }
}
