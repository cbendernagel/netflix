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
import Services.AccountTypeService;
import Services.CustomerService;
import Services.LocationService;
import Services.PersonService;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
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
    AccountTypeService accountTypeService;
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
    protected ModelAndView register(@RequestParam("email") String email, @RequestParam("address") String address,@RequestParam("firstname") String firstname,@RequestParam("lastname") String lastname, @RequestParam("city") String city , @RequestParam("ccn") String ccn , @RequestParam("state") String state,@RequestParam("zip") String zip, @RequestParam("accounttype") String accounttype, @RequestParam("telephone") String telephone, @RequestParam("ssn") String ssn, HttpServletRequest request){
        ModelAndView modelandview;
        
        if (customerService.getCustomerByEmail(email) != null){
            request.setAttribute("UsedEmail", "The email You have selected is already attached to an account");
            modelandview = new ModelAndView("signuppage");
            return modelandview;
        }
        else{
            Location l;
            if(locationService.getLocationById(Integer.parseInt(zip)) != null)
            {
               l = locationService.getLocationById(Integer.parseInt(zip));
            }
            else
            {
                l = new Location();
                l.setZipcode(Integer.parseInt(zip));
                l.setCity(city);
                l.setState(state);
                locationService.addLocation(l);
            }
            Account a = new Account();
            Person p = new Person();
            Customer c = new Customer();
            AccountType accountType = new AccountType();
            accountType.setType(accounttype);
            accountTypeService.addAccountType(accountType);
            
            p.setSsn(ssn);
            p.setLastName(lastname);
            p.setFirstName(firstname);
            p.setAddress(address);
            p.setLocation(l);
            p.setTelephone(telephone);
                
            c.setCcn(ccn);
            c.setEmail(email);
            c.setPerson(p);
            
            a.setCustomer(c);
            a.setAccountType(accountType);
            Calendar calendar = Calendar.getInstance();
            java.util.Date now = calendar.getTime();
            Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
            a.setTimestamp(currentTimestamp);
            
            personService.addPerson(p);
            customerService.addCustomer(c);
            accountService.addAccount(a);
            
            HttpSession session = request.getSession();
            session.setAttribute("account", a);   
            modelandview = new ModelAndView("index");
            return modelandview;
        }
    }
    
    
}
