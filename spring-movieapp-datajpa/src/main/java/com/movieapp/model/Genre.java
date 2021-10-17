package com.movieapp.model;

/**
 * @author TejaPAVANKUMAR
 *
 */

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Genre {
	@Id
	@GeneratedValue(generator = "genre_gen", strategy = GenerationType.AUTO)// Auto Generation Id
	@SequenceGenerator(name = "genre_gen", sequenceName = "genre_seq", initialValue = 10, allocationSize = 1)// Sequential order
	private Integer genreId;
	private String genre;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "genreList", fetch = FetchType.EAGER)
	private Set<Movie> movieList;// Many To Many

	@Override
	public String toString() {
		return "Genre [Genere=" + genre + "]";
	}

	public Genre(String genre) {
		super();
		this.genre = genre;
	}

}
