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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class MovieInfoPageController {
    @Autowired
    MovieService movieService;
    @Autowired
    ActorService actorService;
    
    @RequestMapping(value = "/movieinfopage/{movieId}")
    protected ModelAndView getMovieInfoPage(@PathVariable(value="movieId") int id, HttpServletRequest request){
        
        Movie movie = movieService.getMovieById(id);
        request.setAttribute("movie", movie);
       
        List<Actor> movieActors = actorService.getActorsByMovie(id);
        request.setAttribute("actors", movieActors);
        
        ModelAndView modelandview = new ModelAndView("movieinfopage");        
        return modelandview;
    }
    
    @RequestMapping(value = "/movieinfopage", method = RequestMethod.POST)
    protected ModelAndView changeQueueState(HttpServletRequest request , HttpServletRequest response){
        ModelAndView modelandview;
        
        request.setAttribute("inQueue", 1);
        modelandview = new ModelAndView("movieinfopage");
        return modelandview;
    }
}
