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
import Services.AccountService;
import Services.AccountTypeService;
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
    AccountTypeService accountTypeService;

    @RequestMapping(value = "/signinpage")
    protected ModelAndView getSignInPage() {

        ModelAndView modelandview = new ModelAndView("signinpage");
        return modelandview;
    }

    @RequestMapping(value = "/submitCredentials", method = RequestMethod.POST)
    protected ModelAndView submitCredentials(@RequestParam("id") Integer id, @RequestParam("password") String password, HttpServletRequest request) {
        ModelAndView modelandview;
        
        Account account = accountService.getAccountById(id);

        if (account != null) {
            
            HttpSession session = request.getSession();
            session.setAttribute("account", account);
            
            AccountType accountType = accountTypeService.getAccountTypeById(id);
            String type = accountType.getType();
            switch (type) {
                case "manager":
                    modelandview = new ModelAndView("manager");
                    break;
                case "customerrep":
                    modelandview = new ModelAndView("customerrep");
                    break;
                default:
                    modelandview = new ModelAndView("index");
                    break;
            }

            
        } else {
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
