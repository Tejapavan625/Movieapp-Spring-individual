package com.movieapp.service;

import java.util.List;

import com.movieapp.exception.MovieNotFoundException;
import com.movieapp.model.Genre;

public interface IGenreService {
	Genre addGenre(Genre genre);

	void deleteGenre(int genreId);

	void updateGenre(Genre genre);

	List<Genre> getAll();

	Genre getByGenreId(int genreId);

	List<Genre> getByGenreNameAndMovieName(String genre, String name) throws MovieNotFoundException;

	List<Genre> getByGenreAndActor(String genre, String actor) throws MovieNotFoundException;

}
