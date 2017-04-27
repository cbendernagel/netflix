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

import Model.AccountType;
import org.hibernate.criterion.Restrictions;
/**
 *
 * @author charles
 */
@Repository
public class AccountTypeDAO{
   
    private static final Logger logger = LoggerFactory.getLogger(AccountTypeDAO.class);
    
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
            this.sessionFactory = sf;
    }

    
    public void addAccountType(AccountType u) {
            Session session = this.sessionFactory.getCurrentSession();
            session.persist(u);
            logger.info("AccountType saved successfully, AccountType Details="+u);
    }

    
    public void updateAccountType(AccountType u) {
            Session session = this.sessionFactory.getCurrentSession();
            session.update(u);
            logger.info("AccountType updated successfully, AccountType Details="+u);
    }

    @SuppressWarnings("unchecked")
    public List<AccountType> listAccountTypes() {
            Session session = this.sessionFactory.getCurrentSession();
            List<AccountType> accountTypesList = session.createQuery("from AccountType").list();
            for(AccountType u : accountTypesList){
                    logger.info("AccountType List::"+u);
            }
            return accountTypesList;
    }

    
    public AccountType getAccountTypeById(int id) {
            Session session = this.sessionFactory.getCurrentSession();		
            AccountType u = (AccountType) session.load(AccountType.class, new Integer(id));
            logger.info("AccountType loaded successfully, AccountType details="+u);
            return u;
    }
    
    public AccountType getAccountTypeByEmail(String email) {
            Session session = this.sessionFactory.getCurrentSession();	
            List accountTypes = session.createCriteria(AccountType.class).add(Restrictions.eq("email", email)).list();
            if (accountTypes.isEmpty()){
                return null;
            }
            AccountType u = (AccountType) accountTypes.get(0);
            logger.info("AccountType loaded successfully, AccountType details="+u);
            return u;
    }

    
    public void removeAccountType(int id) {
            Session session = this.sessionFactory.getCurrentSession();
            AccountType u = (AccountType) session.load(AccountType.class, new Integer(id));
            if(null != u){
                    session.delete(u);
            }
            logger.info("AccountType deleted successfully, person details="+u);
    }
    

}
