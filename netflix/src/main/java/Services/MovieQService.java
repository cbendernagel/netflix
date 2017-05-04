/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Dao.MovieQDAO;
import Model.Account;
import Model.Movie;
import Model.MovieQ;

@Service
public class MovieQService {

	private MovieQDAO movieQDAO;

	public void setMovieQDAO(MovieQDAO movieQDAO) {
		this.movieQDAO = movieQDAO;
	}

	
	@Transactional
	public void addMovieQ(MovieQ u) {
		this.movieQDAO.addMovieQ(u);
	}

	
	@Transactional
	public void updateMovieQ(MovieQ u) {
		this.movieQDAO.updateMovieQ(u);
	}

	
	@Transactional
	public List<MovieQ> listMovieQs() {
		return this.movieQDAO.listMovieQs();
	}

	
	@Transactional
	public MovieQ getMovieQById(int id) {
		return this.movieQDAO.getMovieQById(id);
	}
        
        @Transactional
	public MovieQ getMovieQByEmail(String email) {
		return this.movieQDAO.getMovieQByEmail(email);
	}
        
        @Transactional
	public MovieQ getMovieQByAccMov(Account acc, Movie mov) {
		return this.movieQDAO.getMovieQByAccMov(acc, mov);
	}
	
	@Transactional
	public void removeMovieQ(int id) {
		this.movieQDAO.removeMovieQ(id);
	}
        	
}
