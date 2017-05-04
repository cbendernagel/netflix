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
import Model.Movie;
import Services.AccountService;
import Services.MovieService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


public class CustomerController {
    
    @Autowired
    AccountService accountService;
    
    @RequestMapping(value = "/customer/{id}")
    protected ModelAndView getCustomerPage(@PathVariable(value="id") int id, HttpServletRequest request){
        
        Account account = accountService.getAccountById(id);
        request.setAttribute("account", account);
        
        ModelAndView modelandview = new ModelAndView("customer");        
        return modelandview;
    }
    
    
}
