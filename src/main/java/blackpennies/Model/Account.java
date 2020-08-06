package blackpennies.Model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;


public class Account {

    private double balance;

    private User user;

    public double getBalance() {
        return balance;
    }

    public boolean canCredit(double amount) {
        return amount < balance;
    }

    public void addBalance(double amount){
        balance += amount;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean removeBalance(double amount) {
        if(!canCredit(amount)){
            return false;
        }
        balance -= amount;
        return true;
    }
}
