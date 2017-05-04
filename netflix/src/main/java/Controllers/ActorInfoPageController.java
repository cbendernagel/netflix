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

import Model.Actor;
import Model.Movie;
import Services.ActorService;
import Services.MovieService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ActorInfoPageController {
    @Autowired
    MovieService movieService;
    @Autowired
    ActorService actorService;
    
    @RequestMapping(value = "/actorinfopage/{actorId}")
    protected ModelAndView getActorInfoPage(@PathVariable(value="actorId") int id, HttpServletRequest request){
        
        List<Movie> movies = movieService.listMovies();
        Actor actor = actorService.getActorById(id);
        for(Movie movie : movies){
            List<Actor> movieActors = actorService.getActorsByMovie(id);
            if(movieActors.contains(actor) != true){
                movies.remove(movie);
            }
        }
        
        request.setAttribute("moviesIn", movies);
        
        ModelAndView modelandview = new ModelAndView("actorinfopage");        
        return modelandview;
    }
   
}

