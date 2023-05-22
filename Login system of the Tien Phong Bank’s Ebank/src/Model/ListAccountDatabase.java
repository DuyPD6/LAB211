package Model;

import java.util.ArrayList;

public class ListAccountDatabase {
    public ArrayList database() {
        ArrayList<Account> listAccount = new ArrayList<>();
        listAccount.add(new Account("0365614999", "Megamanx32"));
        return listAccount;
    }
}
