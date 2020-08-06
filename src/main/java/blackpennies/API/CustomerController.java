package blackpennies.API;

import blackpennies.Exceptions.CustomerDoesNotExistException;
import blackpennies.Model.User;
import blackpennies.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/user")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }


    @RequestMapping(method = RequestMethod.GET, path = "/details", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserDetails() throws CustomerDoesNotExistException {
        User user = new User();
        user.setName("Derp");
        user.setEmail("neheheh");
        
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add")
    public ResponseEntity<?> addCustomer(){
        User user = new User();
        user.setName("Derp");
        user.setEmail("neheheh");
        customerService.addCustomer(user);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

}
