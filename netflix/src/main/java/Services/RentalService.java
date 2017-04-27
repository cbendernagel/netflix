/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Dao.RentalDAO;
import Model.Rental;

@Service
public class RentalService {

	private RentalDAO rentalDAO;

	public void setRentalDAO(RentalDAO rentalDAO) {
		this.rentalDAO = rentalDAO;
	}

	
	@Transactional
	public void addRental(Rental u) {
		this.rentalDAO.addRental(u);
	}

	
	@Transactional
	public void updateRental(Rental u) {
		this.rentalDAO.updateRental(u);
	}

	
	@Transactional
	public List<Rental> listRentals() {
		return this.rentalDAO.listRentals();
	}

	
	@Transactional
	public Rental getRentalById(int id) {
		return this.rentalDAO.getRentalById(id);
	}
        
        @Transactional
	public Rental getRentalByEmail(String email) {
		return this.rentalDAO.getRentalByEmail(email);
	}
	
	@Transactional
	public void removeRental(int id) {
		this.rentalDAO.removeRental(id);
	}
        	
}
