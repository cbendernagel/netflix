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

import Model.Customer;
import Model.Movie;
import Services.CustomerService;
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

public class MailingListController {
    
    @Autowired
    CustomerService customerService;
    
    @RequestMapping(value = "/mailinglistpage")
    protected ModelAndView getMoviePage(HttpServletRequest request){
       
    
        List<Customer> customers = customerService.listCustomers();
                
        request.setAttribute("customers", customers);
        ModelAndView modelandview = new ModelAndView("moviespage");        
        return modelandview;
    }
}
