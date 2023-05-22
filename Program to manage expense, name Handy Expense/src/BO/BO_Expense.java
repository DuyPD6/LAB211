package BO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import Model.Expense;

public class BO_Expense {
    private List<Expense> listExpenses = null;

    public BO_Expense() {
        listExpenses = new ArrayList<Expense>();
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

    public boolean checkExist(String date, Double amoount, String content) {
        if (listExpenses.isEmpty()) {
            return false;
        }
        for (Expense expense : listExpenses) {
            if (expense.getNumber() == amoount
                    || expense.getDate().equals(date.trim())
                    || (expense.getContent()).equalsIgnoreCase(content.trim())) {
                return true;
            }
        }
        return false;
    }

}
