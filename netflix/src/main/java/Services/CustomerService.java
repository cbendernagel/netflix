/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Dao.CustomerDAO;
import Model.Customer;
import Model.Person;

@Service
public class CustomerService {

	private CustomerDAO customerDAO;

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	
	@Transactional
	public void addCustomer(Customer u) {
		this.customerDAO.addCustomer(u);
	}

	
	@Transactional
	public void updateCustomer(Customer u) {
		this.customerDAO.updateCustomer(u);
	}

	
	@Transactional
	public List<Customer> listCustomers() {
		return this.customerDAO.listCustomers();
	}

	
	@Transactional
	public Customer getCustomerById(int id) {
		return this.customerDAO.getCustomerById(id);
	}
        
        @Transactional
	public Customer getCustomerByEmail(String email) {
		return this.customerDAO.getCustomerByEmail(email);
	}
        
        @Transactional
	public Customer getCustomerByPerson(Person person) {
		return this.customerDAO.getCustomerByPerson(person);
	}
	
	@Transactional
	public void removeCustomer(int id) {
		this.customerDAO.removeCustomer(id);
	}
        	
}
