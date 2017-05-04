/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Model.Movie;
import Model.MovieQ;
import Services.MovieQService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author reggs
 */
public class QueueController {
    
    @Autowired
    MovieQService movieQService;
    
    @RequestMapping(value = "/queue/{id}")
    protected ModelAndView getMovieQPage(HttpServletRequest request, @PathVariable(value="id") int id){
        
        List<MovieQ> movieQs = movieQService.listMovieQs();
        for(MovieQ movieQ : movieQs){
            if(movieQ.getId() != id){
                movieQs.remove(movieQ);
            }
        }
        request.setAttribute("movieQs", movieQs);
                
        ModelAndView modelandview = new ModelAndView("moviegenres");        
        return modelandview;
    }
    
}
