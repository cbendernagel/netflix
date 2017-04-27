/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Dao.AccountTypeDAO;
import Model.AccountType;

@Service
public class AccountTypeService {

	private AccountTypeDAO accountTypeDAO;

	public void setAccountTypeDAO(AccountTypeDAO accountTypeDAO) {
		this.accountTypeDAO = accountTypeDAO;
	}

	
	@Transactional
	public void addAccountType(AccountType u) {
		this.accountTypeDAO.addAccountType(u);
	}

	
	@Transactional
	public void updateAccountType(AccountType u) {
		this.accountTypeDAO.updateAccountType(u);
	}

	
	@Transactional
	public List<AccountType> listAccountTypes() {
		return this.accountTypeDAO.listAccountTypes();
	}

	
	@Transactional
	public AccountType getAccountTypeById(int id) {
		return this.accountTypeDAO.getAccountTypeById(id);
	}
        
        @Transactional
	public AccountType getAccountTypeByEmail(String email) {
		return this.accountTypeDAO.getAccountTypeByEmail(email);
	}
	
	@Transactional
	public void removeAccountType(int id) {
		this.accountTypeDAO.removeAccountType(id);
	}
        	
}
