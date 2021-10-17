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

import com.movieapp.model.Details;
import com.movieapp.service.IDetailsService;

@RestController
@RequestMapping("/movie-restapi")
public class DetailsController {

	@Autowired
	IDetailsService detailsService;

	@GetMapping("/details")
	public ResponseEntity<List<Details>> getAll() {
		List<Details> detailsList = detailsService.getAll();
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get All Details");// TO See Description for what u r doing
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(detailsList);

	}

	@GetMapping("/details/platform/{platform}")
	ResponseEntity<List<Details>> getByPlatform(String platform) {

		List<Details> detailsList = detailsService.getByPlatform(platform);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get By Platform");// TO See Description for what u r doing
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(detailsList);
	}

	@GetMapping("/details/name/{name}/platform/{platform}")
	ResponseEntity<List<Details>> getByNameAndPlatform(@PathVariable String name, @PathVariable String platform) {

		List<Details> detailsList = detailsService.getByNameAndPlatform(name, platform);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get All  Details");// TO See Description for what u r doing
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(detailsList);

	}

}
