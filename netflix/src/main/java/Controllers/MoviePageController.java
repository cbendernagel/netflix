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

import Model.Movie;
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

public class MoviePageController {
    
    @Autowired
    MovieService movieService;
    
    @RequestMapping(value = "/moviespage")
    protected ModelAndView getMovieGenrePage(HttpServletRequest request){
        
        List<Movie> movies = movieService.listMovies();
        List<String> genres = new ArrayList();
        for(Movie movie : movies){
            if(genres.contains(movie.getType()) != true){
                genres.add(movie.getType());
            }
        }
    
        request.setAttribute("genres", genres);
        request.setAttribute("movies", movies);
                
        ModelAndView modelandview = new ModelAndView("moviegenres");        
        return modelandview;
    }
    
    @RequestMapping(value = "/moviespage/{genre}")
    protected ModelAndView getMovieGenrePage(HttpServletRequest request, @PathVariable(value="genre") int genre){
        
        List<Movie> movies = movieService.listMovies();
        List<String> genres = new ArrayList();
        for(Movie movie : movies){
            if(genres.contains(movie.getType()) != true){
                genres.add(movie.getType());
            }
        }
        request.setAttribute("currentgenre", genre);
        request.setAttribute("genres", genres);
        request.setAttribute("movies", movies);
                
        ModelAndView modelandview = new ModelAndView("moviegenres");        
        return modelandview;
    }
    
}
