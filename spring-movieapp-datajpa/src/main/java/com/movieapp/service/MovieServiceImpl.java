package com.movieapp.service;

/**
 * @author TejaPAVANKUMAR
 *
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieapp.exception.MovieNotFoundException;
import com.movieapp.model.Movie;
import com.movieapp.repository.IMovieRepository;
@Service
public class MovieServiceImpl implements IMovieService {

	IMovieRepository movieRepository;  // Object Movie Repository with Automatic Dependecy injection
	@Autowired
	public void setMovieRepository(IMovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	@Override
	public Movie addMovie(Movie movie) { // Add Movie
		return movieRepository.save(movie);
	}

    @Override
	public void deleteMovie(int movieId) { // Delete Movie By Id
		movieRepository.deleteById(movieId);
	}

	@Override
	public void updateMovie(Movie movie) { // Update Movie
		movieRepository.save(movie);
		
	}

	@Override
	public List<Movie> getAll() {// Get all Movies
		return  movieRepository.findAll();
	}
	
	@Override
	public Movie getByMovieId(int movieId) throws MovieNotFoundException { // get Movie By  MovieId
		Movie movie= movieRepository.findById(movieId).get();
		if(movie==null) {
			 throw new MovieNotFoundException("Sorry Movie Name is No Where!!!");
			 
		}
		return movie;
	}

	@Override
	public List<Movie> getByName(String name)  throws MovieNotFoundException{//Get Movie By Movie Name
		List<Movie> movieList= movieRepository.findByName(name);
		
		 if(movieList.isEmpty())
			 throw new MovieNotFoundException("Sorry Movie Name is No Where!!!");
		 return movieList;
	}

	@Override
	public List<Movie> getByLanguage(String language)  throws MovieNotFoundException{ // Get Movie By Movie lANGUAGE
		
		List<Movie> movieList= movieRepository.findByDetailsLanguage(language);
		 if(movieList.isEmpty())
			 throw new MovieNotFoundException("Sorry Language Name is No Where!!!");
		 return movieList;
	}

	@Override  //  Get Movie By Movie Platform and Movie Name
	public List<Movie> getByPlatformAndName(String platform, String name)  throws MovieNotFoundException {
		List<Movie> movieList= movieRepository.findByDetailsPlatformAndName(platform, name);
		 if(movieList.isEmpty())
			 throw new MovieNotFoundException("Sorry paltform, Name is No Where!!!");
		 return movieList;
	}

	@Override//Function for get By Movie name and Genre
	public List<Movie> getByNameAndGenre(String name, String genre) throws MovieNotFoundException {
		List<Movie> movieList=  movieRepository.findByNameAndGenre(name, genre);
		 if(movieList.isEmpty())
			 throw new MovieNotFoundException("Sorry name, genre is No Where!!!");
		 return movieList; 
				
	}

	@Override//Get Movie By Name and Director
	public List<Movie> getByNameAndDirector(String name, String directorName) throws MovieNotFoundException {
		List<Movie> movieList=  movieRepository.findByNameAndGenre(name, directorName);
		 if(movieList.isEmpty())
			 throw new MovieNotFoundException("Sorry name, Director name is No Where!!!");
		 return movieList; 
				
	}

	



	

}