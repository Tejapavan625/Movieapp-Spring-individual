package com.movieapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.movieapp.model.Movie;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Integer> {
	
	
	//Function to Get Name
	List<Movie> findByName(String name);

	//Function to get Details Using Platform
	List<Movie> findByDetailsPlatform(String platform);

	
	//Function to get Details Using Language
	List<Movie> findByDetailsLanguage(String language);

	
	
	// Custom Query
	
	// Find Movie  Details Using Platform and Name
	@Query("from Movie m inner join m.details de where de.platform=?1 and m.name=?2")
	List<Movie> findByDetailsPlatformAndName(String platform, String name);

	// Find Movie By its Genre function
	@Query("from Movie m inner join m.genreList g where m.name =?1 and g.genre=?2")
	List<Movie> findByNameAndGenre(String name, String genre);
	
	//Find Movie Name and Director
	@Query("from Movie m inner join m.director d where m.name =?1 and d.directorName=?2")
	List<Movie> findByNameAndDirector(String name, String directorName);
}
