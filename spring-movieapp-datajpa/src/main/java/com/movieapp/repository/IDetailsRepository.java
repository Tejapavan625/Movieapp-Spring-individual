package com.movieapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.movieapp.model.Details;

@Repository
public interface IDetailsRepository extends JpaRepository<Details, Integer> {

	List<Details> findAll();

	List<Details> findByPlatform(String platform);

	// custom query

	// Function for Get Movie By Movie name and in which Ott Platform
	@Query("from Details d inner join d.movie m where m.name=?1 and d.platform=?2")
	List<Details> findByMovieNameAndPlatform(String name, String platform);

	// Function for Get Movie By Movie name and in which Ott Language
	@Query("from Details d inner join d.movie m where m.name=?1 and d.language=?2")
	List<Details> findByMovieNameAndLanguage(String name, String language);

}
