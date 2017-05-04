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

import Model.Person;
import org.hibernate.criterion.Restrictions;
/**
 *
 * @author charles
 */
@Repository
public class PersonDAO{
   
    private static final Logger logger = LoggerFactory.getLogger(PersonDAO.class);
    
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
            this.sessionFactory = sf;
    }

    
    public void addPerson(Person u) {
            Session session = this.sessionFactory.getCurrentSession();
            session.persist(u);
            logger.info("Person saved successfully, Person Details="+u);
    }

    
    public void updatePerson(Person u) {
            Session session = this.sessionFactory.getCurrentSession();
            session.update(u);
            logger.info("Person updated successfully, Person Details="+u);
    }

    @SuppressWarnings("unchecked")
    public List<Person> listPersons() {
            Session session = this.sessionFactory.getCurrentSession();
            List<Person> personsList = session.createQuery("from Person").list();
            for(Person u : personsList){
                    logger.info("Person List::"+u);
            }
            return personsList;
    }

    
    public Person getPersonById(String ssn) {
            Session session = this.sessionFactory.getCurrentSession();		
            Person u = (Person) session.load(Person.class, ssn);
            logger.info("Person loaded successfully, Person details="+u);
            return u;
    }
    
    public Person getPersonByEmail(String email) {
            Session session = this.sessionFactory.getCurrentSession();	
            List persons = session.createCriteria(Person.class).add(Restrictions.eq("email", email)).list();
            if (persons.isEmpty()){
                return null;
            }
            Person u = (Person) persons.get(0);
            logger.info("Person loaded successfully, Person details="+u);
            return u;
    }

    
    public void removePerson(int id) {
            Session session = this.sessionFactory.getCurrentSession();
            Person u = (Person) session.load(Person.class, new Integer(id));
            if(null != u){
                    session.delete(u);
            }
            logger.info("Person deleted successfully, person details="+u);
    }
    

}
