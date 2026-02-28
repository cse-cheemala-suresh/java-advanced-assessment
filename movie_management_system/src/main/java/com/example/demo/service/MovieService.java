package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepository;

@Service
public class MovieService {
	private MovieRepository movieRepository;

	public MovieService(MovieRepository movieRepository) {
		super();
		this.movieRepository = movieRepository;
	}
	
	public List<Movie> fetchMovie(){
		return movieRepository.findAll();
	}
	
	public void saveMovie(Movie movie) {
		movieRepository.save(movie);
	}
	
	public Movie getMovieById(Long id) {
		return movieRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Movie Data Not Found"));
	}
	
	public void deleteMovie(Long id) {
		movieRepository.deleteById(id);
	}
}
