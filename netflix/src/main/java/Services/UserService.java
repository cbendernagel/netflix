/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Dao.PersonDAO;
import Model.Person;

@Service
public class UserService {

	private PersonDAO userDAO;

	public void setUserDAO(PersonDAO userDAO) {
		this.userDAO = userDAO;
	}

	
	@Transactional
	public void addUser(Person u) {
		this.userDAO.addUser(u);
	}

	
	@Transactional
	public void updateUser(Person u) {
		this.userDAO.updateUser(u);
	}

	
	@Transactional
	public List<Person> listUsers() {
		return this.userDAO.listUsers();
	}

	
	@Transactional
	public Person getUserById(int id) {
		return this.userDAO.getUserById(id);
	}
        
        @Transactional
	public Person getUserByEmail(String email) {
		return this.userDAO.getUserByEmail(email);
	}
	
	@Transactional
	public void removeUser(int id) {
		this.userDAO.removeUser(id);
	}
        	
}
