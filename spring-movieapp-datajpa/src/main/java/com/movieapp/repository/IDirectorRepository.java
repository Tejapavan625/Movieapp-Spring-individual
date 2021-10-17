package com.movieapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.movieapp.model.Director;

@Repository
public interface IDirectorRepository extends JpaRepository<Director, Integer> {

	List<Director> findByDirectorName(String directorName);

	// Custom Query

	// Function to find Director and Movie details By Director name and Movie Name

	@Query("from Director d inner join d.movieList m where d.directorName=?1 and m.name=?2")
	List<Director> findByDirectorNameAndMovieName(String directorName, String name);

	// Function to find Director and Movie details By Director name and Actor Name

	@Query("from Director d inner join d.movieList m where d.directorName=?1 and m.actor=?2")
	List<Director> findByDirectorNameAndActorName(String directorName, String actor);

}
