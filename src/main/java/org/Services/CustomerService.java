package org.Services;

import org.Exceptions.CustomerDoesNotExistException;
import org.Model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CustomerService {

    private Map<Integer, User> customersMap = new HashMap<>();


    public void addCustomer(User user){
        customersMap.put(user.getId(),user);
    }

    public void removeCustomer(User user){
        customersMap.remove(user.getId());
    }

    public User getUser(Integer id) throws CustomerDoesNotExistException {
        if(customersMap.get(id) == null){
            throw new CustomerDoesNotExistException("Customer does not exist!");
        }
        return customersMap.get(id);
    }
}
