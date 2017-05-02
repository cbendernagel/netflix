/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Dao.ActorDAO;
import Model.Actor;

@Service
public class ActorService {

	private ActorDAO actorDAO;

	public void setActorDAO(ActorDAO actorDAO) {
		this.actorDAO = actorDAO;
	}

	
	@Transactional
	public void addActor(Actor u) {
		this.actorDAO.addActor(u);
	}

	
	@Transactional
	public void updateActor(Actor u) {
		this.actorDAO.updateActor(u);
	}

	
	@Transactional
	public List<Actor> listActors() {
		return this.actorDAO.listActors();
	}

	
	@Transactional
	public Actor getActorById(int id) {
		return this.actorDAO.getActorById(id);
	}
        
        @Transactional
	public Actor getActorByEmail(String email) {
		return this.actorDAO.getActorByEmail(email);
	}
	
	@Transactional
	public void removeActor(int id) {
		this.actorDAO.removeActor(id);
	}
        
        @Transactional
	public List<Actor> getActorsByMovie(int id) {
		return this.actorDAO.listActorsByMovie(id);
	}
        
}
