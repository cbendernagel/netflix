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

import Model.Customer;
import org.hibernate.criterion.Restrictions;
/**
 *
 * @author charles
 */
@Repository
public class CustomerDAO{
   
    private static final Logger logger = LoggerFactory.getLogger(CustomerDAO.class);
    
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
            this.sessionFactory = sf;
    }

    
    public void addCustomer(Customer u) {
            Session session = this.sessionFactory.getCurrentSession();
            session.persist(u);
            logger.info("Customer saved successfully, Customer Details="+u);
    }

    
    public void updateCustomer(Customer u) {
            Session session = this.sessionFactory.getCurrentSession();
            session.update(u);
            logger.info("Customer updated successfully, Customer Details="+u);
    }

    @SuppressWarnings("unchecked")
    public List<Customer> listCustomers() {
            Session session = this.sessionFactory.getCurrentSession();
            List<Customer> customersList = session.createQuery("from Customer").list();
            for(Customer u : customersList){
                    logger.info("Customer List::"+u);
            }
            return customersList;
    }

    
    public Customer getCustomerById(int id) {
            Session session = this.sessionFactory.getCurrentSession();		
            Customer u = (Customer) session.load(Customer.class, new Integer(id));
            logger.info("Customer loaded successfully, Customer details="+u);
            return u;
    }
    
    public Customer getCustomerByEmail(String email) {
            Session session = this.sessionFactory.getCurrentSession();	
            List customers = session.createCriteria(Customer.class).add(Restrictions.eq("email", email)).list();
            if (customers.isEmpty()){
                return null;
            }
            Customer u = (Customer) customers.get(0);
            logger.info("Customer loaded successfully, Customer details="+u);
            return u;
    }

    
    public void removeCustomer(int id) {
            Session session = this.sessionFactory.getCurrentSession();
            Customer u = (Customer) session.load(Customer.class, new Integer(id));
            if(null != u){
                    session.delete(u);
            }
            logger.info("Customer deleted successfully, person details="+u);
    }
    

}
