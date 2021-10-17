package com.movieapp.service;

import java.util.List;

import com.movieapp.exception.MovieNotFoundException;
import com.movieapp.model.Details;

public interface IDetailsService {

	
	//Function to get Movie By Platform
	List<Details> getByPlatform(String platform) throws MovieNotFoundException;
	
//Function to get Total Details Of Movie
	List<Details> getAll();

	
	
	//Function to Get Details by Name and Platform
	List<Details> getByNameAndPlatform(String name, String platform) throws MovieNotFoundException;

}
