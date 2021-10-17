package com.movieapp.model;

/**
 * @author TejaPAVANKUMAR
 *
 */

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Movie {

	@Id
	@GeneratedValue(generator = "movie_gen", strategy = GenerationType.AUTO)// Auto Id Generation
	@SequenceGenerator(name = "movie_gen", sequenceName = "movie_seq", initialValue = 1, allocationSize = 1)// Sequential order
	private Integer movieId;
	private String name;
	private String actor;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "details_id") 
	@JsonIgnore
	Details details; // one to one

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "director_id")
	@JsonIgnore // to Ignore Certain properties in Json files
	Director director;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "movie_genre", joinColumns = { @JoinColumn(name = "movie_id") }, inverseJoinColumns = {
			@JoinColumn(name = "genre_id") }) // Extra table will be Created in Many to Many
	@JsonIgnore
	private List<Genre> genreList;// Many to Many 

	public Movie(String name, String actor, Details details, Director director, List<Genre> genreList) {
		super();
		this.name = name;
		this.actor = actor;
		this.details = details;
		this.director = director;
		this.genreList = genreList;
	}

	public Movie(String name, String actor) {
		super();
		this.name = name;
		this.actor = actor;
	}

}
