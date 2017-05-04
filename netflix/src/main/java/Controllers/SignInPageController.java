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
import Model.Employee;
import Services.AccountService;
import Services.EmployeeService;
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


    @RequestMapping(value = "/signinpage")
    protected ModelAndView getSignInPage() {

        ModelAndView modelandview = new ModelAndView("signinpage");
        return modelandview;
    }

    @RequestMapping(value = "/submitCredentials", method = RequestMethod.POST)
    protected ModelAndView submitCredentials(@RequestParam("id") Integer id, HttpServletRequest request) {
        ModelAndView modelandview;
        
        Account account = accountService.getAccountById(id);

        if (account != null) {
            
            HttpSession session = request.getSession();
            session.setAttribute("account", account);
            modelandview = new ModelAndView("index");
    
        }else{
            Employee employee = employeeService.getEmployeeById(id);
            if(employee != null){
                modelandview = new ModelAndView("customerrep");
            }else{
                modelandview = new ModelAndView("signinpage");
                modelandview.addObject("signinError", "Incorrect credentials entered. Please try again.");
            }
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
