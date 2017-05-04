/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

/**
 *
 * @author reggs
 */

import Model.Account;
import Model.AccountType;
import Model.Customer;
import Model.Person;
import Services.AccountService;
import Services.AccountTypeService;
import Services.CustomerService;
import Services.PersonService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
    
    @Autowired
    AccountService accountService;
    @Autowired
    PersonService personService;
    @Autowired
    CustomerService customerService;
    @Autowired
    AccountTypeService accountTypeService;
    
    @RequestMapping(value = "/customer/{id}")
    protected ModelAndView getCustomerPage(@PathVariable(value="id") int id, HttpServletRequest request){
        
        Account account = accountService.getAccountById(id);
        request.setAttribute("account", account);
        List<AccountType> accountTypes = accountTypeService.listAccountTypes();
        request.setAttribute("accounttypes", accountTypes);
        ModelAndView modelandview = new ModelAndView("customer");        
        return modelandview;
    }
    
    @RequestMapping(value = "/changeaccounttype/{id}/{accounttype}")
    protected ModelAndView changeAccountType(@PathVariable(value="id") int id, @PathVariable(value="accounttype") String accountType, HttpServletRequest request){
        
        Account account = accountService.getAccountById(id);
        request.setAttribute("account", account);
        AccountType type = account.getAccountType();
        type.setType(accountType);
        accountTypeService.updateAccountType(type);
        List<AccountType> accountTypes = accountTypeService.listAccountTypes();
        ArrayList<String> types = new ArrayList();
        for(AccountType temp : accountTypes){
            if(types.contains(temp.getType()) != true){
                types.add(temp.getType());
            }
        }
        request.setAttribute("accounttypes", types);
        
        ModelAndView modelandview = new ModelAndView("customer");        
        return modelandview;
    }
    
    @RequestMapping(value = "/changetelephone/{id}")
    protected ModelAndView changeTelephone(@PathVariable(value="id") int id, @RequestParam("telephone") String telephone, HttpServletRequest request){
        
        Account account = accountService.getAccountById(id);
        Person person = account.getCustomer().getPerson();
        person.setTelephone(telephone);
        personService.updatePerson(person);  
        List<AccountType> accountTypes = accountTypeService.listAccountTypes();
        ArrayList<String> types = new ArrayList();
        for(AccountType temp : accountTypes){
            if(types.contains(temp.getType()) != true){
                types.add(temp.getType());
            }
        }
        request.setAttribute("accounttypes", types);
        request.setAttribute("account", account);
        ModelAndView modelandview = new ModelAndView("customer");        
        return modelandview;
    }
    
    @RequestMapping(value = "/changeccn/{id}")
    protected ModelAndView changeCcn(@PathVariable(value="id") int id, @RequestParam("ccn") String ccn, HttpServletRequest request){
        
        Account account = accountService.getAccountById(id);
        Customer customer = account.getCustomer();
        customer.setCcn(ccn);
        customerService.updateCustomer(customer);
        request.setAttribute("account", account);
        List<AccountType> accountTypes = accountTypeService.listAccountTypes();
        ArrayList<String> types = new ArrayList();
        for(AccountType temp : accountTypes){
            if(types.contains(temp.getType()) != true){
                types.add(temp.getType());
            }
        }
        request.setAttribute("accounttypes", types);
        ModelAndView modelandview = new ModelAndView("customer");        
        return modelandview;
    }
    
}
