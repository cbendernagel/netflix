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
import Model.Customer;
import Model.Employee;
import Model.Person;
import Services.AccountService;
import Services.CustomerService;
import Services.EmployeeService;
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
public class SignInPageController {


    @Autowired
    AccountService accountService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    PersonService personService;
    @Autowired
    CustomerService customerService;


    @RequestMapping(value = "/signinpage")
    protected ModelAndView getSignInPage() {

        ModelAndView modelandview = new ModelAndView("signinpage");
        return modelandview;
    }

    @RequestMapping(value = "/submitCredentials", method = RequestMethod.POST)
    protected ModelAndView submitCredentials(@RequestParam("ssn") String ssn, HttpServletRequest request) {
        ModelAndView modelandview;
        HttpSession session = request.getSession();
        
        Person person;
        
        if((person = personService.getPersonById(ssn)) != null)
        {
            if(customerService.getCustomerByPerson(person) != null)
            {
                Customer customer = customerService.getCustomerByPerson(person);
                Account account = accountService.getAccountByCustomer(customer);
                session.setAttribute("account", account);
                modelandview = new ModelAndView("index");
            }
            else if(employeeService.getEmployeeByPerson(person) != null)
            {
                Employee employee = employeeService.getEmployeeByPerson(person);
                session.setAttribute("employee", employee);
                if(employee.getType().equals("Manager")){
                    modelandview = new ModelAndView("manager");
                }else{
                    modelandview = new ModelAndView("customerrep");
                }
            }
            else
            {
                modelandview = new ModelAndView("signinpage");
                modelandview.addObject("signinError", "Incorrect credentials entered. Please try again.");
            }
        }
        else
        {
            modelandview = new ModelAndView("signinpage");
            modelandview.addObject("signinError", "Incorrect credentials entered. Please try again.");
        }
        return modelandview;
    }


    @RequestMapping(value = "/logout")
    protected ModelAndView logout(HttpServletRequest request) {

        HttpSession session = request.getSession();
        session.invalidate();

        ModelAndView modelandview = new ModelAndView("index");
        return modelandview;
    }
}
