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

import Model.Rental;
import org.hibernate.criterion.Restrictions;
/**
 *
 * @author charles
 */
@Repository
public class RentalDAO{
   
    private static final Logger logger = LoggerFactory.getLogger(RentalDAO.class);
    
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
            this.sessionFactory = sf;
    }

    
    public void addRental(Rental u) {
            Session session = this.sessionFactory.getCurrentSession();
            session.persist(u);
            logger.info("Rental saved successfully, Rental Details="+u);
    }

    
    public void updateRental(Rental u) {
            Session session = this.sessionFactory.getCurrentSession();
            session.update(u);
            logger.info("Rental updated successfully, Rental Details="+u);
    }

    @SuppressWarnings("unchecked")
    public List<Rental> listRentals() {
            Session session = this.sessionFactory.getCurrentSession();
            List<Rental> rentalsList = session.createQuery("from Rental").list();
            for(Rental u : rentalsList){
                    logger.info("Rental List::"+u);
            }
            return rentalsList;
    }

    
    public Rental getRentalById(int id) {
            Session session = this.sessionFactory.getCurrentSession();		
            Rental u = (Rental) session.load(Rental.class, new Integer(id));
            logger.info("Rental loaded successfully, Rental details="+u);
            return u;
    }
    
    public Rental getRentalByEmail(String email) {
            Session session = this.sessionFactory.getCurrentSession();	
            List rentals = session.createCriteria(Rental.class).add(Restrictions.eq("email", email)).list();
            if (rentals.isEmpty()){
                return null;
            }
            Rental u = (Rental) rentals.get(0);
            logger.info("Rental loaded successfully, Rental details="+u);
            return u;
    }

    
    public void removeRental(int id) {
            Session session = this.sessionFactory.getCurrentSession();
            Rental u = (Rental) session.load(Rental.class, new Integer(id));
            if(null != u){
                    session.delete(u);
            }
            logger.info("Rental deleted successfully, person details="+u);
    }
    

}
