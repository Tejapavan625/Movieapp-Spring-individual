package com.movieapp.service;

/**
 * @author TejaPAVANKUMAR
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieapp.exception.MovieNotFoundException;
import com.movieapp.model.Genre;
import com.movieapp.repository.IGenreRepository;

@Service
public class GenreServiceImpl implements IGenreService {

	@Autowired
	IGenreRepository genreRepository;

	@Override// Get Genre by Genre and Actor
	public List<Genre> getByGenreAndActor(String genre, String actor) throws MovieNotFoundException {
		List<Genre> genrebyNameandActor= genreRepository.findByGenreAndActor(genre, actor);
		if( genrebyNameandActor.isEmpty()) {
			throw new MovieNotFoundException("Sorry Your Searching Result is Not There");
		}
		return genrebyNameandActor; 
		
	}

	@Override// get Genre By Id
	public Genre getByGenreId(int genreId) {
	return genreRepository.findById(genreId).get();
	}
  
	
	
	@Override
	public List<Genre> getAll() {// Get all GenreList available
		return genreRepository.findAll();
	}

	@Override// get by Genre and Movie name
	public List<Genre> getByGenreNameAndMovieName(String genre, String name) throws MovieNotFoundException{
		List<Genre> genrebyNameandMovieName=genreRepository.findByGenreNameAndMovieName(genre, name);
		if( genrebyNameandMovieName.isEmpty()) {
			throw new MovieNotFoundException("Sorry Your Searching Result is Not There");
		}
		return genrebyNameandMovieName;
		
	}



	@Override
	public void deleteGenre(int genreId) {// delete Genre by Id
		genreRepository.deleteById(genreId);
	}

	@Override
	public void updateGenre(Genre genre) {// Update Genre
		genreRepository.save(genre);
	}

	@Override
	public Genre addGenre(Genre genre) {// Add Genre
		return genreRepository.save(genre);
	}

	
}
