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

import Model.Actor;
import org.hibernate.criterion.Restrictions;
/**
 *
 * @author charles
 */
@Repository
public class ActorDAO{
   
    private static final Logger logger = LoggerFactory.getLogger(ActorDAO.class);
    
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
            this.sessionFactory = sf;
    }

    
    public void addActor(Actor u) {
            Session session = this.sessionFactory.getCurrentSession();
            session.persist(u);
            logger.info("Actor saved successfully, Actor Details="+u);
    }

    
    public void updateActor(Actor u) {
            Session session = this.sessionFactory.getCurrentSession();
            session.update(u);
            logger.info("Actor updated successfully, Actor Details="+u);
    }

    @SuppressWarnings("unchecked")
    public List<Actor> listActors() {
            Session session = this.sessionFactory.getCurrentSession();
            List<Actor> actorsList = session.createQuery("from Actor").list();
            for(Actor u : actorsList){
                    logger.info("Actor List::"+u);
            }
            return actorsList;
    }

    
    public Actor getActorById(int id) {
            Session session = this.sessionFactory.getCurrentSession();		
            Actor u = (Actor) session.load(Actor.class, new Integer(id));
            logger.info("Actor loaded successfully, Actor details="+u);
            return u;
    }
    
    public Actor getActorByEmail(String email) {
            Session session = this.sessionFactory.getCurrentSession();	
            List actors = session.createCriteria(Actor.class).add(Restrictions.eq("email", email)).list();
            if (actors.isEmpty()){
                return null;
            }
            Actor u = (Actor) actors.get(0);
            logger.info("Actor loaded successfully, Actor details="+u);
            return u;
    }

    
    public void removeActor(int id) {
            Session session = this.sessionFactory.getCurrentSession();
            Actor u = (Actor) session.load(Actor.class, new Integer(id));
            if(null != u){
                    session.delete(u);
            }
            logger.info("Actor deleted successfully, person details="+u);
    }
    
    @SuppressWarnings("unchecked")
    public List<Actor> listActorsByMovie(int id) {
            Session session = this.sessionFactory.getCurrentSession();
            List<Actor> actorsList = session.createQuery("from Actor").list();
            for(Actor u : actorsList){
                    logger.info("Actor List::"+u);
            }
            return actorsList;
    }
    

}
