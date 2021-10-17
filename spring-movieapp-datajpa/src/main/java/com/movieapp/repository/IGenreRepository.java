package com.movieapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.movieapp.model.Genre;

@Repository
public interface IGenreRepository extends JpaRepository<Genre, Integer> {

// Custom Query

	// Function bye Genre and Its Actor
	@Query("from Genre g inner join g.movieList m where g.genre=?1 and m.actor=?2")
	List<Genre> findByGenreAndActor(String genre, String actor);

	// Function By Genre and Movie name
	@Query("from Genre g inner join g.movieList m where g.genre=?1 and m.name=?2")
	List<Genre> findByGenreNameAndMovieName(String genre, String name);

}
