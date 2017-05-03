/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

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

public class MovieQPageController {
    @Autowired
    MovieQService movieQService;
    
    @RequestMapping(value = "/queue/{userid}")
    protected ModelAndView getMovieInfoPage(@PathVariable(value="movieId") int id, HttpServletRequest request){
        
        MovieQ movieQ = movieQService.getMovieQById(id);
        request.setAttribute("movieq", movieQ);
        
        ModelAndView modelandview = new ModelAndView("queue");        
        return modelandview;
    }
    
}
