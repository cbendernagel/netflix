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

import Model.AppearedIn;
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
    
    public AppearedIn getAppearedInByEmail(String email) {
            Session session = this.sessionFactory.getCurrentSession();	
            List appearedIns = session.createCriteria(AppearedIn.class).add(Restrictions.eq("email", email)).list();
            if (appearedIns.isEmpty()){
                return null;
            }
            AppearedIn u = (AppearedIn) appearedIns.get(0);
            logger.info("AppearedIn loaded successfully, AppearedIn details="+u);
            return u;
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
