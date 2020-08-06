package org.Model;

import org.springframework.stereotype.Repository;

@Repository
public class Account {

    private double balance;



    public double getBalance() {
        return balance;
    }

    public boolean canCredit(double amount) {
        return amount < balance;
    }

    public void addBalance(double amount){
        balance += amount;
    }


    public boolean removeBalance(double amount) {
        if(!canCredit(amount)){
            return false;
        }
        balance -= amount;
        return true;
    }
}
