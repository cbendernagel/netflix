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

import Model.Employee;
import Model.Rental;
import Model.Movie;
import Services.RentalService;
import Services.MovieService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerRepController {
    
    @Autowired
    MovieService movieService;
    @Autowired
    RentalService rentalService;
    
    @RequestMapping(value = "/customerrep")
    protected ModelAndView getCustomerRepPage(HttpServletRequest request){
        
        List<Rental> rentals = rentalService.listRentals();
    
        request.setAttribute("rental", rentals);
                
        ModelAndView modelandview = new ModelAndView("customerrep");        
        return modelandview;
    }
    
    @RequestMapping(value = "/moviespage/{rental.id}")
    protected ModelAndView getRentalPage(HttpServletRequest request, @PathVariable(value="rental") int rentalId){
        
        Rental rental = rentalService.getRentalById(rentalId);
        HttpSession session = request.getSession();
        Employee employee = (Employee) session.getAttribute("employee");
        Movie m = rental.getMovie();
        Integer x = m.getNumCopies();
        rental.getMovie().setNumCopies(x);
        rental.setEmployee(employee);
                
        ModelAndView modelandview = new ModelAndView("moviespage");        
        return modelandview;
    }
    
    
}
