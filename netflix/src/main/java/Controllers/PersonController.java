/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

/**
 *
 * @author rrego
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Model.Person;
import Services.PersonService;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonController{
    
    private PersonService personService;
	
	@Autowired(required=true)
	@Qualifier(value="userService")
	public void setUserService(PersonService ps){
		this.personService = ps;
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ModelAndView listUsers() {
                                   ModelAndView modelandview = new ModelAndView("user");
		modelandview.addObject("user", new Person());
		modelandview.addObject("listUsers", this.personService.listPersons());
		return modelandview;
	}
	
	//For add and update user both
	@RequestMapping(value= "/user/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") Person p){
		
		if(p.getSsn() == 0){
			//new user, add it
			this.personService.addPerson(p);
		}else{
			//existing user, call update
			this.personService.updatePerson(p);
		}
		
		return "redirect:/users";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") int id){
		
        this.personService.removePerson(id);
        return "redirect:/users";
    }
 
    @RequestMapping("/edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.personService.getPersonById(id));
        model.addAttribute("listUsers", this.personService.listPersons());
        return "user";
    }
    
    
}

