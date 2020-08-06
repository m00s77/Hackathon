package org.Services;

import org.Exceptions.CustomerDoesNotExistException;
import org.Exceptions.NotEnoughBalanceException;
import org.Model.Account;
import org.Model.User;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountService {

    private Account account;
    private CustomerService customerService;

    public void addBalance(int id, double amount) throws CustomerDoesNotExistException {
        account = customerService.getUser(id).getAccount();
        account.addBalance(amount);
    }

    public void removeBalance(int id, double amount) throws CustomerDoesNotExistException, NotEnoughBalanceException {
        account = customerService.getUser(id).getAccount();

        if(!account.removeBalance(amount)){
            throw new NotEnoughBalanceException("Not enough balance!");
        }
        account.removeBalance(amount);
    }

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
}
