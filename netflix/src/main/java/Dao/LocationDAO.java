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

import Model.Location;
import org.hibernate.criterion.Restrictions;
/**
 *
 * @author charles
 */
@Repository
public class LocationDAO{
   
    private static final Logger logger = LoggerFactory.getLogger(LocationDAO.class);
    
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
            this.sessionFactory = sf;
    }

    
    public void addLocation(Location u) {
            Session session = this.sessionFactory.getCurrentSession();
            session.persist(u);
            logger.info("Location saved successfully, Location Details="+u);
    }

    
    public void updateLocation(Location u) {
            Session session = this.sessionFactory.getCurrentSession();
            session.update(u);
            logger.info("Location updated successfully, Location Details="+u);
    }

    @SuppressWarnings("unchecked")
    public List<Location> listLocations() {
            Session session = this.sessionFactory.getCurrentSession();
            List<Location> locationsList = session.createQuery("from Location").list();
            for(Location u : locationsList){
                    logger.info("Location List::"+u);
            }
            return locationsList;
    }

    
    public Location getLocationById(int id) {
            Session session = this.sessionFactory.getCurrentSession();		
            try{
                Location u = (Location) session.load(Location.class, new Integer(id));
                logger.info("Location loaded successfully, Location details="+u);
                return u;
            }catch(Exception e)
            {
                return null;
            }
    }
    
    public void removeLocation(int id) {
            Session session = this.sessionFactory.getCurrentSession();
            Location u = (Location) session.load(Location.class, new Integer(id));
            if(null != u){
                    session.delete(u);
            }
            logger.info("Location deleted successfully, person details="+u);
    }
    

}
