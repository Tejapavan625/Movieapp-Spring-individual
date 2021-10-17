package com.movieapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieapp.model.Genre;
import com.movieapp.service.IGenreService;

@RestController
@RequestMapping("/movie-restapi")
public class GenreController {
	@Autowired
	IGenreService genreService;

	@GetMapping("/genres") // To Get All Genre
	public ResponseEntity<List<Genre>> getAll() {

		List<Genre> genre = genreService.getAll();
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get All Details");// TO See Description for what u r doing
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(genre);

	}

	@GetMapping("/genres/genreId/{genreId}") // To get Genre By ID
	ResponseEntity<Genre> getByGenreId(@PathVariable int genreId) {
		Genre genre = genreService.getByGenreId(genreId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get By GenreId");// TO See Description for what u r doing
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(genre);

	}

	@GetMapping("/genres/genre/{genre}/name/{name}") // Get By Genre and Movie name
	ResponseEntity<List<Genre>> getByGenreNameAndMovieName(@PathVariable String genre, @PathVariable String name) {
		List<Genre> genreList = genreService.getByGenreNameAndMovieName(genre, name);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get By Genre and Name");// TO See Description for what u r doing
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(genreList);

	}

	@GetMapping("/genres/genre/{genre}/actor/{actor}") // Get By Genre and Movie Actor
	ResponseEntity<List<Genre>> getByGenreAndActor(@PathVariable String genre, @PathVariable String actor) {
		List<Genre> genreList = genreService.getByGenreAndActor(genre, actor);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get By Genre and Actor");// TO See Description for what u r doing
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(genreList);
	}
}
