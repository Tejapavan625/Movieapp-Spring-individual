package com.movieapp.service;

import java.util.List;

import com.movieapp.exception.MovieNotFoundException;
import com.movieapp.model.Movie;

public interface IMovieService {
	Movie addMovie(Movie movie);

	void deleteMovie(int movieId);

	void updateMovie(Movie movie);

	List<Movie> getAll();

	Movie getByMovieId(int movieId);

	List<Movie> getByName(String name) throws MovieNotFoundException;

	List<Movie> getByLanguage(String language) throws MovieNotFoundException;

	List<Movie> getByPlatformAndName(String platform, String name) throws MovieNotFoundException;

	List<Movie> getByNameAndGenre(String name, String genre) throws MovieNotFoundException;

	List<Movie> getByNameAndDirector(String name, String directorName) throws MovieNotFoundException;
}
