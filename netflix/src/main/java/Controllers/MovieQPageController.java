/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Model.Account;
import Model.Actor;
import Model.Movie;
import Model.MovieQ;
import Services.ActorService;
import Services.MovieQService;
import Services.MovieService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
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
/**
 *
 * @author reggs
 */

@Controller
public class MovieQPageController {
    @Autowired
    MovieQService movieQService;
    @Autowired
    MovieService movieService;
    
    @RequestMapping(value = "/queue/{movieId}")
    protected ModelAndView getMovieQPage(@PathVariable(value="movieId") int id, HttpServletRequest request){
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        Movie movie = movieService.getMovieById(id);
        MovieQ movieQ = new MovieQ();
        movieQ.setAccount(account);
        movieQ.setMovie(movie);
        
        ModelAndView modelandview = new ModelAndView("moviespage");        
        return modelandview;
    }
    
    @RequestMapping(value = "/dequeue/{movieId}")
    protected ModelAndView getMovieDQPage(@PathVariable(value="movieId") int id, HttpServletRequest request){
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        Movie movie = movieService.getMovieById(id);
        
        MovieQ movieQ = movieQService.getMovieQByAccMov(account, movie);
        
        movieQService.removeMovieQ(movieQ.getId());
        
        ModelAndView modelandview = new ModelAndView("moviespage");        
        return modelandview;
    }
    
    
    
}
