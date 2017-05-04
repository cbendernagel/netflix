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
import Model.Rental;
import Services.AccountService;
import Services.OrderService;
import Services.RentalService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController {
    @Autowired
    AccountService accountService;
    @Autowired
    OrderService orderService;
    @Autowired
    RentalService rentalService;
    
    @RequestMapping(value = "/account/{accountId}")
    protected ModelAndView getAccountPage(@PathVariable(value="accountId") int id, HttpServletRequest request){
        
        Account account = accountService.getAccountById(id);
        request.setAttribute("account", account);
        List<Rental> orders = new ArrayList();
        List<Rental> rentals = rentalService.listRentals();
        for(Rental rental : rentals){
            if(rental.getAccount().getId() == id){
                orders.add(rental);
            }
        }
        request.setAttribute("rentals", orders);
        
        ModelAndView modelandview = new ModelAndView("movieinfopage");        
        return modelandview;
    }
    
}
