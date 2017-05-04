package Controllers;

/**
 *
 * @author reggs
 */

import Model.Account;
import Model.Actor;
import Model.Movie;
import Model.Rental;
import Services.ActorService;
import Services.MovieService;
import Services.RentalService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MovieInfoPageController {
    @Autowired
    MovieService movieService;
    @Autowired
    ActorService actorService;
    @Autowired
    RentalService rentalService;
    
    @RequestMapping(value = "/movieinfopage/{movieId}")
    protected ModelAndView getMovieInfoPage(@PathVariable(value="movieId") int id, HttpServletRequest request){
        
        HttpSession session = request.getSession();  
        Movie movie = movieService.getMovieById(id);
        request.setAttribute("movie", movie);
        Account account = (Account) session.getAttribute("account");
        
        List<Actor> movieActors = actorService.getActorsByMovie(id);
        request.setAttribute("actors", movieActors);
        
        ModelAndView modelandview = new ModelAndView("movieinfopage");        
        return modelandview;
    }
    
    @RequestMapping(value = "/rent/{movieId}")
    protected ModelAndView requestRental(@PathVariable(value="movieId") int id, HttpServletRequest request){
        Rental rental = new Rental();
        HttpSession session = request.getSession();  
        Movie movie = movieService.getMovieById(id);
        request.setAttribute("movie", movie);
        Account account = (Account) session.getAttribute("account");
        rental.setAccount(account);
        rental.setMovie(movie);
        
        rentalService.addRental(rental);
        
        ModelAndView modelandview = new ModelAndView("movieinfopage");        
        return modelandview;
    }
}
