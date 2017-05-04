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
import Model.AppearedIn;
import Model.Movie;
import Services.ActorService;
import Services.AppearedInService;
import Services.MovieService;
import java.util.ArrayList;
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
    @Autowired
    AppearedInService appearedInService;
    
    @RequestMapping(value = "/actorinfopage/{actorId}")
    protected ModelAndView getActorInfoPage(@PathVariable(value="actorId") int id, HttpServletRequest request){
        
        Actor actor = actorService.getActorById(id);
        ArrayList<Movie> movies = new ArrayList<Movie>();
        
        List<AppearedIn> appearedIn = appearedInService.getAppearedInByActor(actor);
        
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

