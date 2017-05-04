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
public class ManagerController{
    
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
    
    
    @RequestMapping(value = "/manager")
    protected ModelAndView getManager(){
    
        ModelAndView modelandview = new ModelAndView("manager");        
        return modelandview;
    }
        
    
    
}
