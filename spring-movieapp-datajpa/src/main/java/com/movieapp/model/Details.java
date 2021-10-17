package com.movieapp.model;


/**
 * @author TejaPAVANKUMAR
 *
 */

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
public class Details {


	@Id 
	@GeneratedValue(generator = "details_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "details_gen", sequenceName = "details_seq", initialValue = 1, allocationSize = 1)
	private Integer detailsId;
	private String platform;
	private String language;
	double budget;
	private double rating;
	
	// Having One to One relationship with Movie class
	@OneToOne(cascade = CascadeType.ALL)
	
	// To join details Id column in Movie class
	@JoinColumn(name = "details_id")
	 Movie movie;
	

	public Details(String platform, String language, double budget, double rating) {
		super();
		this.platform = platform;
		this.language = language;
		this.budget = budget;
		this.rating = rating;
	}




	@Override
	public String toString() {
		return "Details [Platform=" + platform + ", Language=" + language + ", Budget=" + budget + ", Rating=" + rating
				+ "]";
	}




}
