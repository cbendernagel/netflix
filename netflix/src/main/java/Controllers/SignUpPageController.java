/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

/**
 *
 * @author reggs
 */
import Model.Account;
import Model.AccountType;
import Model.Customer;
import Model.Location;
import Model.Person;
import Services.AccountService;
import Services.CustomerService;
import Services.LocationService;
import Services.PersonService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignUpPageController{
    
    @Autowired
    AccountService accountService;
    @Autowired
    AccountService accountTypeService;
    @Autowired
    PersonService personService;
    @Autowired
    LocationService locationService;
    @Autowired
    CustomerService customerService;
    
    
    @RequestMapping(value = "/signuppage")
    protected ModelAndView getSignUpPage(){
    
        ModelAndView modelandview = new ModelAndView("signuppage");        
        return modelandview;
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    protected ModelAndView register(@RequestParam("email") String email, @RequestParam("address") String address,@RequestParam("firstname") String firstname,@RequestParam("lastname") String lastname, @RequestParam("city") String city , @RequestParam("ccn") Integer ccn , @RequestParam("tate") String state,@RequestParam("zip") Integer zip, @RequestParam("accounttype") String accounttype, @RequestParam("telephone") Integer telephone, @RequestParam("ssn") Integer ssn, HttpServletRequest request){
        ModelAndView modelandview;
        
        if (accountService.getAccountByEmail(email) != null){
            request.setAttribute("UsedEmail", "The email You have selected is already attached to an account");
            modelandview = new ModelAndView("signuppage");
            return modelandview;
        }
        else{
            
            Account a = new Account();
            Person p = new Person();
            Customer c = new Customer();
            Location l = new Location();
            AccountType accountType = new AccountType();
            
            a.setCustomer(c);
            a.setAccountType(accountType);
            a.setId(ssn);
    
            p.setLastName(lastname);
            p.setFirstName(firstname);
            p.setAddress(address);
            p.setLocation(l);
            p.setTelephone(telephone);
                
            c.setCcn(ccn);
            c.setEmail(email);
            c.setPerson(p);
            
            l.setCity(city);
            l.setState(state);
            l.setZipcode(zip);
    
            personService.addPerson(p);
            accountService.addAccount(a);
            locationService.addLocation(l);
            customerService.addCustomer(c);
            
            HttpSession session = request.getSession();
            session.setAttribute("account", a);   
            modelandview = new ModelAndView("index");
            return modelandview;
        }
    }
    
    
}
