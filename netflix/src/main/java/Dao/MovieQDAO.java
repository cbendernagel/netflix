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

import Model.MovieQ;
import org.hibernate.criterion.Restrictions;
/**
 *
 * @author charles
 */
@Repository
public class MovieQDAO{
   
    private static final Logger logger = LoggerFactory.getLogger(MovieQDAO.class);
    
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
            this.sessionFactory = sf;
    }

    
    public void addMovieQ(MovieQ u) {
            Session session = this.sessionFactory.getCurrentSession();
            session.persist(u);
            logger.info("MovieQ saved successfully, MovieQ Details="+u);
    }

    
    public void updateMovieQ(MovieQ u) {
            Session session = this.sessionFactory.getCurrentSession();
            session.update(u);
            logger.info("MovieQ updated successfully, MovieQ Details="+u);
    }

    @SuppressWarnings("unchecked")
    public List<MovieQ> listMovieQs() {
            Session session = this.sessionFactory.getCurrentSession();
            List<MovieQ> movieQsList = session.createQuery("from MovieQ").list();
            for(MovieQ u : movieQsList){
                    logger.info("MovieQ List::"+u);
            }
            return movieQsList;
    }

    
    public MovieQ getMovieQById(int id) {
            Session session = this.sessionFactory.getCurrentSession();		
            MovieQ u = (MovieQ) session.load(MovieQ.class, new Integer(id));
            logger.info("MovieQ loaded successfully, MovieQ details="+u);
            return u;
    }
    
    public MovieQ getMovieQByEmail(String email) {
            Session session = this.sessionFactory.getCurrentSession();	
            List movieQs = session.createCriteria(MovieQ.class).add(Restrictions.eq("email", email)).list();
            if (movieQs.isEmpty()){
                return null;
            }
            MovieQ u = (MovieQ) movieQs.get(0);
            logger.info("MovieQ loaded successfully, MovieQ details="+u);
            return u;
    }

    
    public void removeMovieQ(int id) {
            Session session = this.sessionFactory.getCurrentSession();
            MovieQ u = (MovieQ) session.load(MovieQ.class, new Integer(id));
            if(null != u){
                    session.delete(u);
            }
            logger.info("MovieQ deleted successfully, person details="+u);
    }
    

}
