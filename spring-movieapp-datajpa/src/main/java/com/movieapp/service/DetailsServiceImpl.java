package com.movieapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieapp.exception.MovieNotFoundException;
import com.movieapp.model.Details;
import com.movieapp.repository.IDetailsRepository;

@Service
public class DetailsServiceImpl implements IDetailsService {

	@Autowired// automatic injection Dependency
	IDetailsRepository detailsRepository;

	@Override // Function to get Movie Details by Name and Platform
	public List<Details> getByNameAndPlatform(String name, String platform) throws MovieNotFoundException {
		List<Details> detailsList = detailsRepository.findByMovieNameAndPlatform(name, platform);
		if (detailsList.isEmpty()) {
			throw new MovieNotFoundException("Movie not found");
		}
		return detailsList;
	}

	@Override // FUNCTION TO GET DETAILS OF ALL Movies
	public List<Details> getAll() {
		return detailsRepository.findAll();
	}

	@Override // Function to get Movie By Platform
	public List<Details> getByPlatform(String platform) throws MovieNotFoundException {
		List<Details> detailsList = detailsRepository.findByPlatform(platform);
		if (detailsList.isEmpty()) {
			throw new MovieNotFoundException("Movie not found");
		}
		return detailsList;

	}
}
