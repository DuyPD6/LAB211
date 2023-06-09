package Model;

import java.util.ArrayList;
import java.util.List;

public class ListAccountDatabase {
    public List<Account> getAccounts() {
        List<Account> listAccount = new ArrayList<>();
        listAccount.add(new Account("0365614999", "Megamanx32"));
        return listAccount;
    }
}