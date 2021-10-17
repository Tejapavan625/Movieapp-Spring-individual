package com.movieapp.service;

import java.util.List;

import com.movieapp.exception.directorNotFoundException;
import com.movieapp.model.Director;

public interface IDirectorService {

	List<Director> getAll();

	Director addDirector(Director director);

	void updateDirector(Director director);

	void deleteDirector(int directorId);

	List<Director> getByDirectorName(String directorName) throws directorNotFoundException;

	List<Director> getByDirectorNameAndMovieName(String directorName, String name) throws directorNotFoundException;

	List<Director> getByDirectorNameAndActorName(String directorName, String name) throws directorNotFoundException;
}
