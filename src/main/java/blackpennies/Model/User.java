package blackpennies.Model;

import blackpennies.Exceptions.AccountHasBalanceException;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;


public class User {

    public static int globalId;
    private int id;
    private String name;
    private String password;
    private String email;

    private Account account;

    public User(){
        id = setID();
        account = new Account();
        account.setUser(this);
    }

    private int setID() {
        return ++globalId;
    }

    public void removeAccount() throws AccountHasBalanceException {
        if(account.getBalance() > 0.0){
            throw new AccountHasBalanceException("You still have money!");
        }
        account.setUser(null);
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
