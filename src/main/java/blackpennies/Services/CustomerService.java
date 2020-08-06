package blackpennies.Services;

import blackpennies.Exceptions.CustomerDoesNotExistException;
import blackpennies.Model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class CustomerService {

    private Map<Integer, User> customersMap = new HashMap<>();


    public void addCustomer(User user){
        customersMap.put(user.getId(),user);
    }

    public void removeCustomer(int id){
        customersMap.remove(id);
    }

    public User getUser(Integer id) throws CustomerDoesNotExistException {
        if(customersMap.get(id) == null){
            throw new CustomerDoesNotExistException("Customer does not exist!");
        }
        return customersMap.get(id);
    }

    public boolean authenticate(User user) {
        return customersMap.containsValue(user) && user.getPassword().equals(customersMap.get(user.getId()).getPassword());
    }

    public List<User> getAll(){
        List<User> toReturn = new LinkedList<>(customersMap.values());
        return toReturn;
    }
}
