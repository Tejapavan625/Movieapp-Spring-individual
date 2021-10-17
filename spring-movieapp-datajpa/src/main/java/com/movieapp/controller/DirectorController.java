package com.movieapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieapp.model.Director;
import com.movieapp.service.IDirectorService;

@RestController
@RequestMapping("/movie-restapi")
public class DirectorController {
	@Autowired
	IDirectorService directorService;

	@GetMapping("/director")
	ResponseEntity<List<Director>> getAll() {
		List<Director> directorList = directorService.getAll();
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get All  Details");// TO See Description for what u r doing
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(directorList);
	}
@PostMapping("/director")
	ResponseEntity<String> addDirector(Director director) {
		directorService.addDirector(director);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Director Updated");// TO See Description for what u r doing
		return  ResponseEntity.status(HttpStatus.CREATED).headers(headers).body("Added");
		 

	}
@PutMapping("/director")
	ResponseEntity<String> updateDirector(Director director) {
		  directorService.updateDirector(director);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Director Updated");// TO See Description for what u r doing
		return  ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body("Updated");
		 
		
	}
 @DeleteMapping("/director/directorId/{directorId}")
	ResponseEntity<String> deleteDirector(int directorId) {
		 directorService.deleteDirector(directorId);
			HttpHeaders headers = new HttpHeaders();
			headers.add("desc", "Deleted By Id");// TO See Description for what u r doing
			return  ResponseEntity.status(HttpStatus.OK).headers(headers).body("Deleted");
			 
			
	}
	@GetMapping("/director/directorName/{directorName}")
	ResponseEntity<List<Director>>  getByDirectorName(String directorName) {
		List<Director> directorList = directorService.getByDirectorName(directorName);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get By NAME");// TO See Description for what u r doing
		return  ResponseEntity.status(HttpStatus.OK).headers(headers).body(directorList);	}
		
	@GetMapping("/director/directorName/{directorName}/name/{name}")
	ResponseEntity<List<Director>>  getByDirectorNameAndMovieName(String directorName, String name) {
		List<Director> directorList =directorService.getByDirectorNameAndMovieName(directorName, name);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get By NAME and Movie");// TO See Description for what u r doing
		return  ResponseEntity.status(HttpStatus.OK).headers(headers).body(directorList)
		;
	}

}
