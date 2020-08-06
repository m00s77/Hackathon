package org.Model;

import org.Exceptions.AccountHasBalanceException;
import org.springframework.stereotype.Repository;

@Repository
public class User {

    private static int globalId;
    private int id;
    private String name;
    private String password;
    private String email;
    private Account account;

    public User(String name){
        id = setId();
        this.name = name;
        account = new Account();
    }

    private int setId() {
        return ++globalId;
    }

    public void removeAccount() throws AccountHasBalanceException {
        if(account.getBalance() > 0.0){
            throw new AccountHasBalanceException("You still have money!");
        }
        account = null;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public int getId() {
        return id;
    }
}
