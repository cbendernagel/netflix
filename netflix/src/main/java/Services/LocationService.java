/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Dao.LocationDAO;
import Model.Location;

@Service
public class LocationService {

	private LocationDAO locationDAO;

	public void setLocationDAO(LocationDAO locationDAO) {
		this.locationDAO = locationDAO;
	}

	
	@Transactional
	public void addLocation(Location u) {
		this.locationDAO.addLocation(u);
	}

	
	@Transactional
	public void updateLocation(Location u) {
		this.locationDAO.updateLocation(u);
	}

	
	@Transactional
	public List<Location> listLocations() {
		return this.locationDAO.listLocations();
	}

	
	@Transactional
	public Location getLocationById(Integer id) {
		return this.locationDAO.getLocationById(id);
	}
	
	@Transactional
	public void removeLocation(int id) {
		this.locationDAO.removeLocation(id);
	}
        	
}
