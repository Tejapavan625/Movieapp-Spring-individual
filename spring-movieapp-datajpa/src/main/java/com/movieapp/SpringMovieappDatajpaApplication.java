package com.movieapp;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.movieapp.model.Details;
import com.movieapp.model.Director;
import com.movieapp.model.Genre;
import com.movieapp.model.Movie;
import com.movieapp.service.IDetailsService;
import com.movieapp.service.IDirectorService;
import com.movieapp.service.IGenreService;
import com.movieapp.service.IMovieService;

@SpringBootApplication
public class SpringMovieappDatajpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringMovieappDatajpaApplication.class, args);
	}

	@Autowired
	IMovieService movieService;

	@Autowired
	IDetailsService detailService;

	@Autowired
	IDirectorService directorService;

	@Autowired
	IGenreService genreService;

	@Override
	public void run(String... args) throws Exception {
		
		//Creating Details Object reference and Passing values

		Details details = new Details("Netflix", "Telugu", 90000, 8.9);
		Details details1 = new Details("Aha", "Telugu", 890000, 5.6);
		Details details2 = new Details("Prime", "Telugu", 87600, 7.5);
		Details details3 = new Details("Prime", "Telugu", 95600, 7.9);
 
		//Creating Director Object reference and Passing values

		Director director = new Director("Srinu");
		Director director1 = new Director("Kishore tirumula");
		Director director2 = new Director("Muragadas");
		Director director3 = new Director("S.J Surya");

		
		//Creating Genre Object reference and Passing values

		Genre genre = new Genre("Action");
		Genre genre1 = new Genre("Horror");
		Genre genre2 = new Genre("Rom-Com");
		Genre genre3 = new Genre("Love");

		ArrayList<Genre> genreList = new ArrayList<Genre>(Arrays.asList(genre));
		ArrayList<Genre> genreList1 = new ArrayList<Genre>(Arrays.asList(genre1));
		ArrayList<Genre> genreList2 = new ArrayList<Genre>(Arrays.asList(genre2));
		ArrayList<Genre> genreList3 = new ArrayList<Genre>(Arrays.asList(genre3));

		//Creating Movie Object reference and Passing values 
		new Movie("King", "Nag", details, director, genreList);
		new Movie("Red", "Ram", details1, director1, genreList2);
		new Movie("Stalin", "Chiru", details2, director2, genreList1);
		new Movie("Kushi", "PSPK", details3, director3, genreList3);
		

		detailService.getByNameAndPlatform("King", "Netflix").forEach(System.out::println);

		genreService.getByGenreAndActor("Love", "PSPK").forEach(System.out::println);
	}
}
