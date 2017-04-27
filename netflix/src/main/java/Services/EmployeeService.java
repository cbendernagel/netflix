/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Dao.EmployeeDAO;
import Model.Employee;

@Service
public class EmployeeService {

	private EmployeeDAO employeeDAO;

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	
	@Transactional
	public void addEmployee(Employee u) {
		this.employeeDAO.addEmployee(u);
	}

	
	@Transactional
	public void updateEmployee(Employee u) {
		this.employeeDAO.updateEmployee(u);
	}

	
	@Transactional
	public List<Employee> listEmployees() {
		return this.employeeDAO.listEmployees();
	}

	
	@Transactional
	public Employee getEmployeeById(int id) {
		return this.employeeDAO.getEmployeeById(id);
	}
        
        @Transactional
	public Employee getEmployeeByEmail(String email) {
		return this.employeeDAO.getEmployeeByEmail(email);
	}
	
	@Transactional
	public void removeEmployee(int id) {
		this.employeeDAO.removeEmployee(id);
	}
        	
}
