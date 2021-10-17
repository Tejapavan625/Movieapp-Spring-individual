package com.movieapp.service;

/**
 * @author TejaPAVANKUMAR
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieapp.exception.directorNotFoundException;
import com.movieapp.model.Director;
import com.movieapp.repository.IDirectorRepository;

@Service
public class DirectorServiceImpl implements IDirectorService {

	@Autowired
	IDirectorRepository directorRepository;

	@Override
	public List<Director> getAll() {// To get Director Movie Details he worked
		return directorRepository.findAll();
	}

	@Override
	public Director addDirector(Director director) {// To Add Director
		return directorRepository.save(director);
	}

	@Override
	public void updateDirector(Director director) { //To Uppdate Director For a Movie
		 directorRepository.save(director);
	}

	@Override
	public void deleteDirector(int directorId) {//To Delete Director By Id
		directorRepository.deleteById(directorId);
	}

	@Override//get Director name
	public List<Director> getByDirectorName(String directorName) throws directorNotFoundException {
		
		List<Director> directorList= directorRepository.findByDirectorName(directorName);
		if(directorList.isEmpty()) {
			 throw new directorNotFoundException("Sorry director Name is No Where!!!");// throws exception if Director not found
			
			
		}
		 return  directorList;
	}

	@Override//get Director name and Movie Name
	public List<Director> getByDirectorNameAndMovieName(String directorName, String name)
			throws directorNotFoundException{
		List<Director> directorList=  directorRepository.findByDirectorNameAndMovieName(directorName, name);
		if(directorList.isEmpty()) {
			 throw new directorNotFoundException("Sorry Movie Name and Directoris No Where!!!"); // throws Exception if Director name and Movie name not found
			
			
		}
		 return  directorList;
	}

	@Override
	public List<Director> getByDirectorNameAndActorName(String directorName, String actor)// get Director name and Movie Actor
			throws directorNotFoundException {
		List<Director> directorList=directorRepository.findByDirectorNameAndActorName(directorName, actor);
		if(directorList.isEmpty()) {
			 throw new directorNotFoundException("Sorry Movie Actor  and Directoris No Where!!!");
			// throws exception if Director name and Movie Actor not found
				
			
		}
		 return  directorList;
	
	}

	



	


	
}
