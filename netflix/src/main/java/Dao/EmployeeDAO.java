/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Customer;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import Model.Employee;
import Model.Person;
import org.hibernate.criterion.Restrictions;
/**
 *
 * @author charles
 */
@Repository
public class EmployeeDAO{
   
    private static final Logger logger = LoggerFactory.getLogger(EmployeeDAO.class);
    
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
            this.sessionFactory = sf;
    }

    
    public void addEmployee(Employee u) {
            Session session = this.sessionFactory.getCurrentSession();
            session.persist(u);
            logger.info("Employee saved successfully, Employee Details="+u);
    }

    
    public void updateEmployee(Employee u) {
            Session session = this.sessionFactory.getCurrentSession();
            session.update(u);
            logger.info("Employee updated successfully, Employee Details="+u);
    }

    @SuppressWarnings("unchecked")
    public List<Employee> listEmployees() {
            Session session = this.sessionFactory.getCurrentSession();
            List<Employee> employeesList = session.createQuery("from Employee").list();
            for(Employee u : employeesList){
                    logger.info("Employee List::"+u);
            }
            return employeesList;
    }

    
    public Employee getEmployeeById(int id) {
            Session session = this.sessionFactory.getCurrentSession();		
            Employee u = (Employee) session.load(Employee.class, new Integer(id));
            logger.info("Employee loaded successfully, Employee details="+u);
            return u;
    }
    
    public Employee getEmployeeByEmail(String email) {
            Session session = this.sessionFactory.getCurrentSession();	
            List employees = session.createCriteria(Employee.class).add(Restrictions.eq("email", email)).list();
            if (employees.isEmpty()){
                return null;
            }
            Employee u = (Employee) employees.get(0);
            logger.info("Employee loaded successfully, Employee details="+u);
            return u;
    }
    
    public Employee getEmployeeByPerson(Person person)
    {
        Session session = this.sessionFactory.getCurrentSession();	
        List employees = session.createCriteria(Employee.class).add(Restrictions.eq("person", person)).list();
        if (employees.isEmpty()){
            return null;
        }
        Employee u = (Employee) employees.get(0);
        logger.info("Account loaded successfully, Account details="+u);
        return u;
    }

    
    public void removeEmployee(int id) {
            Session session = this.sessionFactory.getCurrentSession();
            Employee u = (Employee) session.load(Employee.class, new Integer(id));
            if(null != u){
                    session.delete(u);
            }
            logger.info("Employee deleted successfully, person details="+u);
    }
    

}
