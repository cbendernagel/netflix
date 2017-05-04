/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Dao.AccountDAO;
import Model.Account;
import Model.Customer;
import Model.Person;

@Service
public class AccountService {

	private AccountDAO accountDAO;

	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	
	@Transactional
	public void addAccount(Account u) {
		this.accountDAO.addAccount(u);
	}

	
	@Transactional
	public void updateAccount(Account u) {
		this.accountDAO.updateAccount(u);
	}

	
	@Transactional
	public List<Account> listAccounts() {
		return this.accountDAO.listAccounts();
	}

	
	@Transactional
	public Account getAccountById(int id) {
		return this.accountDAO.getAccountById(id);
	}
        
        @Transactional
	public Account getAccountByEmail(String email) {
		return this.accountDAO.getAccountByEmail(email);
	}
        
        @Transactional
	public Account getAccountByCustomer(Customer customer) {
		return this.accountDAO.getAccountByCustomer(customer);
	}
	
	@Transactional
	public void removeAccount(int id) {
		this.accountDAO.removeAccount(id);
	}
        	
}
