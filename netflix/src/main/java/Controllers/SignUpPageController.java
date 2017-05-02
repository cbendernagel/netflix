/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

/**
 *
 * @author rrego
 */
import Model.Account;
import Model.Customer;
import Model.Location;
import Model.Person;
import Services.AccountService;
import Services.CustomerService;
import Services.LocationService;
import Services.PersonService;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignUpPageController{
    
    @Autowired
    PersonService personService;
    @Autowired
    LocationService locationService;
    @Autowired
    CustomerService customerService;
    @Autowired
    AccountService accountService;
    
    
    
    @RequestMapping(value = "/signuppage")
    protected ModelAndView getSignUpPage(){
    
    ModelAndView modelandview = new ModelAndView("signuppage");        
        return modelandview;
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    protected ModelAndView register(@RequestParam("address") String address, @RequestParam("city") String city,  @RequestParam("state") String state, @RequestParam("zip") Integer zip, @RequestParam("ssn") Integer ssn, @RequestParam("credit") Integer credit, @RequestParam("accountType") String accountType, @RequestParam("telephone") Integer telephone, @RequestParam("email") String email, @RequestParam("password") String password,@RequestParam("firstname") String firstname,@RequestParam("lastname") String lastname, HttpServletRequest request){
        ModelAndView modelandview;
        
        if (personService.getPersonByEmail(email) != null){
            request.setAttribute("UsedEmail", "The email You have selected is already attached to an account");
            modelandview = new ModelAndView("signuppage");
            return modelandview;
        }
        else{
            Person p = new Person(); 
            p.setFirstName(firstname);
            p.setLastName(lastname);
            p.setAddress(address);
            p.setSsn(ssn);
            
            Location l = new Location();
            l.setState(state);
            l.setCity(city);
            l.setZipcode(zip);
            
            p.setLocation(l);
            p.setTelephone(telephone);
            
            Customer c = new Customer();
            c.setEmail(email);
            c.setCcn(credit);
            
            Account a = new Account();
            //a.setTimestamp();
            
            
            personService.addPerson(p);
            locationService.addLocation(l);
            customerService.addCustomer(c);
            accountService.addAccount(a);
            
            HttpSession session = request.getSession();
            session.setAttribute("person", p);   
            modelandview = new ModelAndView("index");
            return modelandview;
        }
        
    }
    
    
}

