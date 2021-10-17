package com.movieapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieapp.model.Movie;

import com.movieapp.service.IMovieService;

@RestController
@RequestMapping("/movie-restapi")
public class MovieController {
	@Autowired
	IMovieService movieService;
	

	@PostMapping("/movie")// Add Movie 
	public  ResponseEntity<String> addMovie(@RequestBody Movie movie) {
		 movieService.addMovie(movie);
		 HttpHeaders headers = new HttpHeaders();
			headers.add("desc", "Movie Added");// TO See Description for what u r doing
			return  ResponseEntity.status(HttpStatus.CREATED).headers(headers).body("Created");
	}
	
	@PutMapping("/movie")// Update Movie Data
	public ResponseEntity<String> updateMovie(@RequestBody Movie movie) {
		movieService.updateMovie(movie);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Movie Updated");// TO See Description for the Process done
		return  ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body("Updated");
		}
	
	@DeleteMapping("/movie/movieId/{movieId}")// TO Delete Movie By it's Id
	public ResponseEntity<String> deleteMovie(@PathVariable int movieId) {
		movieService.deleteMovie(movieId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Movie Deleted by Id");// TO See Description for Process done
		return  ResponseEntity.status(HttpStatus.OK).headers(headers).body("Deleted");		
		}
	@GetMapping("/movie")// To Get all  Movies 
	public ResponseEntity<List<Movie>> getAll() {
		List<Movie> movieList= movieService.getAll();
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get all Movies");// TO See Description for Process done
		return  ResponseEntity.status(HttpStatus.OK).headers(headers).body(movieList);	
		}
		

	
	@GetMapping("/movie/movieId/{movieId}")// Get Movie By Id
      public ResponseEntity<Movie> getByMovieId(@PathVariable("movieId") int movieId) {
		
		Movie movie= movieService.getByMovieId(movieId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get By MovieId");// TO See Description for Process done
		return  ResponseEntity.status(HttpStatus.OK).headers(headers).body(movie);		}
		

		
	
	
	@GetMapping("/movie/name/{name}/genre/{genre}")// Get Movie By Name and genre
    public ResponseEntity<List<Movie>> getByNameAndGenre(@PathVariable("name")String name, @PathVariable("genre") String genre) {
		List<Movie> movieList = movieService.getByNameAndGenre(name, genre);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get Movie by Name and Genre");// TO See Description for Process done
		return  ResponseEntity.status(HttpStatus.OK).headers(headers).body(movieList);	
		
	}

	@GetMapping("/movie/platform/{platform}/name/{name}")// Get Movie By Name and Ott Platform
    public ResponseEntity<List<Movie>> getByPlatformAndNaae(@PathVariable("platform") String platform,@PathVariable("name") String name) {
		List<Movie> movieList =  movieService.getByPlatformAndName(platform, name);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get Movie by Name and Platform");// TO See Description for Process done
		return  ResponseEntity.status(HttpStatus.OK).headers(headers).body(movieList);	
		
	}
	@GetMapping("/movie/name/{name}/directorName/{directorName}")// Get Movie By Name and Ott Platform
    public ResponseEntity<List<Movie>> getByNameAndDirector(@PathVariable("name") String name,@PathVariable("directorName") String directorName) {
		List<Movie> movieList =  movieService.getByPlatformAndName(name,directorName);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get Movie by Name and Director Name");// TO See Description for Process done
		return  ResponseEntity.status(HttpStatus.OK).headers(headers).body(movieList);	
		
	}
	
	
}
