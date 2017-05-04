/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Dao.AppearedInDAO;
import Model.Actor;
import Model.AppearedIn;
import Model.Movie;

@Service
public class AppearedInService {

	private AppearedInDAO appearedInDAO;

	public void setAppearedInDAO(AppearedInDAO appearedInDAO) {
		this.appearedInDAO = appearedInDAO;
	}

	
	@Transactional
	public void addAppearedIn(AppearedIn u) {
		this.appearedInDAO.addAppearedIn(u);
	}

	
	@Transactional
	public void updateAppearedIn(AppearedIn u) {
		this.appearedInDAO.updateAppearedIn(u);
	}

	
	@Transactional
	public List<AppearedIn> listAppearedIns() {
		return this.appearedInDAO.listAppearedIns();
	}

	
	@Transactional
	public AppearedIn getAppearedInById(int id) {
		return this.appearedInDAO.getAppearedInById(id);
	}
        
        @Transactional
	public List<AppearedIn> getAppearedInByActor(Actor actor) {
		return this.appearedInDAO.getAppearedInByActor(actor);
	}
	
        @Transactional
	public List<AppearedIn> getAppearedInByMovie(Movie movie) {
		return this.appearedInDAO.getAppearedInByMovie(movie);
	}
	
	@Transactional
	public void removeAppearedIn(int id) {
		this.appearedInDAO.removeAppearedIn(id);
	}
        	
}
