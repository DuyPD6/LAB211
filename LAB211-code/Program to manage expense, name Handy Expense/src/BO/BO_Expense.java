package BO;

import java.util.ArrayList;
import java.util.List;

import Model.Expense;

public class BO_Expense {
    private List<Expense> listExpenses;

    public BO_Expense() {
        listExpenses = new ArrayList<>();
    }

    public void addExpense(Expense expense) {
        listExpenses.add(expense);
    }

    public List<Expense> getListExpenses() {
        return listExpenses;
    }

    public boolean deleteExpense(int ID) {
        if (listExpenses.isEmpty()) {
            return false;
        }
        for (Expense expense : listExpenses) {
            if (expense.getID() == ID) {
                listExpenses.remove(expense);
                return true;
            }
        }
        return false;
    }

    public boolean checkExist(String date, Double amount, String content) {
        if (listExpenses.isEmpty()) {
            return false;
        }
        for (Expense expense : listExpenses) {
            if (expense.getNumber() == amount
                    || expense.getDate().equals(date.trim())
                    || expense.getContent().equalsIgnoreCase(content.trim())) {
                return true;
            }
        }
        return false;
    }
}
