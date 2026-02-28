package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Movie;
import com.example.demo.service.MovieService;

@Controller
public class MovieController {
	private MovieService movieService;

	public MovieController(MovieService movieService) {
		super();
		this.movieService = movieService;
	}
	
	@GetMapping("/movieDetails")
	public String movieDetails(Model model) {
		List<Movie> movies = movieService.fetchMovie();
		model.addAttribute("movies", movies);
		return "movieDetails";
	}
	
	@GetMapping("/addMovieDetails")
	public String showAddForm(Model model) {
		model.addAttribute("movie", new Movie());
		return "addMovieDetails";
	}
	
	@PostMapping("/saveMovieDetails")
	public String saveMovieDetails(Movie movie) {
		movieService.saveMovie(movie);
		return "redirect:/movieDetails";
	}
	
	@GetMapping("/updateMovieDetails/{id}")
	public String updateMovieDetails(@PathVariable Long id, Model model) {
		Movie movie = movieService.getMovieById(id);
		model.addAttribute("movie", movie);
		return "addMovieDetails";
	}
	
	@GetMapping("/deleteMovieDetails/{id}")
	public String deleteMovieDetails(@PathVariable Long id) {
		movieService.deleteMovie(id);
		return "redirect:/movieDetails";
	}
}
