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

import Model.Account;
import Model.Customer;
import Model.Person;
import org.hibernate.criterion.Restrictions;
/**
 *
 * @author charles
 */
@Repository
public class AccountDAO{
   
    private static final Logger logger = LoggerFactory.getLogger(AccountDAO.class);
    
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
            this.sessionFactory = sf;
    }

    
    public void addAccount(Account u) {
            Session session = this.sessionFactory.getCurrentSession();
            session.persist(u);
            logger.info("Account saved successfully, Account Details="+u);
    }

    
    public void updateAccount(Account u) {
            Session session = this.sessionFactory.getCurrentSession();
            session.update(u);
            logger.info("Account updated successfully, Account Details="+u);
    }

    @SuppressWarnings("unchecked")
    public List<Account> listAccounts() {
            Session session = this.sessionFactory.getCurrentSession();
            List<Account> accountsList = session.createQuery("from Account").list();
            for(Account u : accountsList){
                    logger.info("Account List::"+u);
            }
            return accountsList;
    }

    
    public Account getAccountById(int id) {
            Session session = this.sessionFactory.getCurrentSession();		
            Account u = (Account) session.load(Account.class, new Integer(id));
            logger.info("Account loaded successfully, Account details="+u);
            return u;
    }
    
    public Account getAccountByEmail(String email) {
            Session session = this.sessionFactory.getCurrentSession();	
            List accounts = session.createCriteria(Account.class).add(Restrictions.eq("email", email)).list();
            if (accounts.isEmpty()){
                return null;
            }
            Account u = (Account) accounts.get(0);
            logger.info("Account loaded successfully, Account details="+u);
            return u;
    }
    
    public Account getAccountByCustomer(Customer customer)
    {
        Session session = this.sessionFactory.getCurrentSession();	
        List accounts = session.createCriteria(Account.class).add(Restrictions.eq("customer", customer)).list();
        if (accounts.isEmpty()){
            return null;
        }
        Account u = (Account) accounts.get(0);
        logger.info("Account loaded successfully, Account details="+u);
        return u;
    }

    
    public void removeAccount(int id) {
            Session session = this.sessionFactory.getCurrentSession();
            Account u = (Account) session.load(Account.class, new Integer(id));
            if(null != u){
                    session.delete(u);
            }
            logger.info("Account deleted successfully, person details="+u);
    }
    

}
