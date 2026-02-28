package com.example.demo.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	private String genre;
	
	private String director;
	
	@Column
	private Integer releaseYear;
	
	private Double rating;

	public Movie(String title, String genre, String director, Integer releaseYear, Double rating) {
		super();
		this.title = title;
		this.genre = genre;
		this.director = director;
		this.releaseYear = releaseYear;
		this.rating = rating;
	}
	
}
