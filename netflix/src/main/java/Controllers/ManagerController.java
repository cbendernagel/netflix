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
import Model.Movie;
import Services.MovieService;
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
    @Autowired
    MovieService movieService;
    
    
    @RequestMapping(value = "/manager")
    protected ModelAndView getManager(){
    
        ModelAndView modelandview = new ModelAndView("manager");        
        return modelandview;
    }
        
    @RequestMapping(value = "/addMovie", method = RequestMethod.POST)
    protected ModelAndView addMovie(@RequestParam("moviename") String moviename,@RequestParam("type") String type ,@RequestParam("rating") int rating,@RequestParam("distrFee") float distrFee, @RequestParam("numCopies")int numCopies, HttpServletRequest request){
        ModelAndView modelandview;

            Movie m = new Movie();
            m.setName(moviename);
            m.setType(type);
            m.setDistrFee(distrFee);
            m.setRating(rating);
            m.setNumCopies(numCopies);
            movieService.addMovie(m);
        
        modelandview = new ModelAndView("manager");
        return modelandview;
    }
    
    @RequestMapping(value = "/editMovie", method = RequestMethod.POST)
    protected ModelAndView editMovie(@RequestParam("id") int id, @RequestParam("moviename") String moviename,@RequestParam("type") String type ,@RequestParam("rating") int rating,@RequestParam("distrFee") float distrFee, @RequestParam("numCopies")int numCopies, HttpServletRequest request){
        ModelAndView modelandview;
        
        if(movieService.getMovieById(id)!= null){
            Movie m = movieService.getMovieById(id);
            m.setName(moviename);
            m.setType(type);
            m.setDistrFee((float)distrFee);
            m.setRating(rating);
            m.setNumCopies(numCopies);
            movieService.updateMovie(m);
        }
        else{
            request.setAttribute("NoId", "No movie matches with given Id");
            modelandview = new ModelAndView("manager");
            return modelandview;
        }
        
        modelandview = new ModelAndView("manager");
        return modelandview;
    }
    
    @RequestMapping(value = "/deleteMovie", method = RequestMethod.POST)
    protected ModelAndView deleteMovie(@RequestParam("id") int id,HttpServletRequest request){
        ModelAndView modelandview;
        
        if(movieService.getMovieById(id)!= null){
            movieService.removeMovie(id);
        }else{
            request.setAttribute("NoId", "No movie matches with given Id");
            modelandview = new ModelAndView("manager");
            return modelandview;
        }
        modelandview = new ModelAndView("manager");
        return modelandview;
    }
}
