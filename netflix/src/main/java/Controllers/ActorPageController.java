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
import Services.ActorService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


public class ActorPageController {
    
    @Autowired
    ActorService actorService;
    
    
    @RequestMapping(value = "/actorspage")
    protected ModelAndView getMovieGenrePage(HttpServletRequest request){
        
        List<Actor> movies = actorService.listActors();
    
        request.setAttribute("actors", movies);
                
        ModelAndView modelandview = new ModelAndView("actorspage");        
        return modelandview;
    }
    
}
