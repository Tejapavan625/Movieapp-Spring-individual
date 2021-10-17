package com.movieapp.model;

/**
 * @author TejaPAVANKUMAR
 *
 */

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
public class Director {

	@Id
	@GeneratedValue(generator = "director_gen", strategy = GenerationType.AUTO)// Autogenrated Id
	@SequenceGenerator(name = "director_gen", sequenceName = "director_seq", initialValue = 100, allocationSize = 1)
	private Integer directorId;
	private String directorName;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "director_id")
	private Set<Movie> movieList; // OneTOMany 

	public Director(String directorName) {
		super();
		this.directorName = directorName;
	}

	@Override
	public String toString() {
		return "Director [DirectorId=" + directorId + ",DirectorName=" + directorName + "]";
	}

}
