package org;

import org.Exceptions.AccountHasBalanceException;
import org.Exceptions.CustomerDoesNotExistException;
import org.Model.User;
import org.Services.CustomerService;

public class Test {

    public static void main(String[] args) throws AccountHasBalanceException, CustomerDoesNotExistException {
        User user1 = new User("Zé");
        User user2 = new User("Moleque");

        CustomerService customerService = new CustomerService();

        customerService.addCustomer(user1);
        customerService.addCustomer(user2);

        while (true){

        }
    }
}
