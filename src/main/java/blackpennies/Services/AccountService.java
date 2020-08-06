package blackpennies.Services;

import blackpennies.Exceptions.CustomerDoesNotExistException;
import blackpennies.Exceptions.NotEnoughBalanceException;
import blackpennies.Model.Account;

import blackpennies.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public Account getAccount(Integer uid) throws CustomerDoesNotExistException {
        return customerService.getUser(uid).getAccount();
    }


    public void addBalance(Integer uid, double amount) throws CustomerDoesNotExistException {
        if(customerService.getUser(uid) == null){
            throw new CustomerDoesNotExistException("Customer does not exist");
        }
        User user = customerService.getUser(uid);
        Account account = user.getAccount();
        account.addBalance(amount);

    }


    public void removeBalance(int uid, double amount) throws CustomerDoesNotExistException, NotEnoughBalanceException {
        if(customerService.getUser(uid) == null){
            throw  new CustomerDoesNotExistException("Customer does not exist");
        }

        User user = customerService.getUser(uid);
        Account account = user.getAccount();

        if(!account.removeBalance(amount)){
            throw new NotEnoughBalanceException("Not enough balance!");
        }
        account.removeBalance(amount);

    }
}
