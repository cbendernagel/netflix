/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import Model.Movie;
import org.hibernate.criterion.Restrictions;
/**
 *
 * @author charles
 */
@Repository
public class MovieDAO{
   
    private static final Logger logger = LoggerFactory.getLogger(MovieDAO.class);
    
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
            this.sessionFactory = sf;
    }

    
    public void addMovie(Movie u) {
            Session session = this.sessionFactory.getCurrentSession();
            session.persist(u);
            logger.info("Movie saved successfully, Movie Details="+u);
    }

    
    public void updateMovie(Movie u) {
            Session session = this.sessionFactory.getCurrentSession();
            session.update(u);
            logger.info("Movie updated successfully, Movie Details="+u);
    }

    @SuppressWarnings("unchecked")
    public List<Movie> listMovies() {
            Session session = this.sessionFactory.getCurrentSession();
            List<Movie> moviesList = session.createQuery("from Movie").list();
            for(Movie u : moviesList){
                    logger.info("Movie List::"+u);
            }
            return moviesList;
    }

    
    public Movie getMovieById(int id) {
            Session session = this.sessionFactory.getCurrentSession();		
            Movie u = (Movie) session.load(Movie.class, new Integer(id));
            logger.info("Movie loaded successfully, Movie details="+u);
            return u;
    }
    
    public Movie getMovieByEmail(String email) {
            Session session = this.sessionFactory.getCurrentSession();	
            List movies = session.createCriteria(Movie.class).add(Restrictions.eq("email", email)).list();
            if (movies.isEmpty()){
                return null;
            }
            Movie u = (Movie) movies.get(0);
            logger.info("Movie loaded successfully, Movie details="+u);
            return u;
    }

    
    public void removeMovie(int id) {
            Session session = this.sessionFactory.getCurrentSession();
            Movie u = (Movie) session.load(Movie.class, new Integer(id));
            if(null != u){
                    session.delete(u);
            }
            logger.info("Movie deleted successfully, person details="+u);
    }
    
    @SuppressWarnings("unchecked")
    public List<Movie> listMoviesByTimesRented() {
            Session session = this.sessionFactory.getCurrentSession();
            List<Movie> moviesList = session.createQuery("from Movie").list();
            for(Movie u : moviesList){
                    logger.info("Movie List::"+u);
            }
            return moviesList;
    }
}
