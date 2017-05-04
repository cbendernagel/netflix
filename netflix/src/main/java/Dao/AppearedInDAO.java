/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Actor;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import Model.AppearedIn;
import Model.Movie;
import org.hibernate.criterion.Restrictions;
/**
 *
 * @author charles
 */
@Repository
public class AppearedInDAO{
   
    private static final Logger logger = LoggerFactory.getLogger(AppearedInDAO.class);
    
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
            this.sessionFactory = sf;
    }

    
    public void addAppearedIn(AppearedIn u) {
            Session session = this.sessionFactory.getCurrentSession();
            session.persist(u);
            logger.info("AppearedIn saved successfully, AppearedIn Details="+u);
    }

    
    public void updateAppearedIn(AppearedIn u) {
            Session session = this.sessionFactory.getCurrentSession();
            session.update(u);
            logger.info("AppearedIn updated successfully, AppearedIn Details="+u);
    }

    @SuppressWarnings("unchecked")
    public List<AppearedIn> listAppearedIns() {
            Session session = this.sessionFactory.getCurrentSession();
            List<AppearedIn> appearedInsList = session.createQuery("from AppearedIn").list();
            for(AppearedIn u : appearedInsList){
                    logger.info("AppearedIn List::"+u);
            }
            return appearedInsList;
    }

    
    public AppearedIn getAppearedInById(int id) {
            Session session = this.sessionFactory.getCurrentSession();		
            AppearedIn u = (AppearedIn) session.load(AppearedIn.class, new Integer(id));
            logger.info("AppearedIn loaded successfully, AppearedIn details="+u);
            return u;
    }
    
    public List<AppearedIn> getAppearedInByActor(Actor actor) {
            Session session = this.sessionFactory.getCurrentSession();	
            List appearedIns = session.createCriteria(AppearedIn.class).add(Restrictions.eq("actor", actor)).list();
            if (appearedIns.isEmpty()){
                return null;
            }
            logger.info("AppearedIn loaded successfully, AppearedIn details="+appearedIns);
            return appearedIns;
    }
    
    public List<AppearedIn> getAppearedInByMovie(Movie movie) {
            Session session = this.sessionFactory.getCurrentSession();	
            List appearedIns = session.createCriteria(AppearedIn.class).add(Restrictions.eq("movie", movie)).list();
            if (appearedIns.isEmpty()){
                return null;
            }
            logger.info("AppearedIn loaded successfully, AppearedIn details="+appearedIns);
            return appearedIns;
    }

    
    public void removeAppearedIn(int id) {
            Session session = this.sessionFactory.getCurrentSession();
            AppearedIn u = (AppearedIn) session.load(AppearedIn.class, new Integer(id));
            if(null != u){
                    session.delete(u);
            }
            logger.info("AppearedIn deleted successfully, person details="+u);
    }
    

}
