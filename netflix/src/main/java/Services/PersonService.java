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
public class PersonService {

	private PersonDAO personDAO;

	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	
	@Transactional
	public void addPerson(Person u) {
		this.personDAO.addPerson(u);
	}

	
	@Transactional
	public void updatePerson(Person u) {
		this.personDAO.updatePerson(u);
	}

	
	@Transactional
	public List<Person> listPersons() {
		return this.personDAO.listPersons();
	}

	
	@Transactional
	public Person getPersonById(int id) {
		return this.personDAO.getPersonById(id);
	}
        
        @Transactional
	public Person getPersonByEmail(String email) {
		return this.personDAO.getPersonByEmail(email);
	}
	
	@Transactional
	public void removePerson(int id) {
		this.personDAO.removePerson(id);
	}
        	
}
