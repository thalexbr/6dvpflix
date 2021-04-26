package com.example.movieservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "tbl_movie")
public class Movie {

	@Id
	@JsonProperty("id")
	private int id;

	@JsonProperty("likes")
	private double likes;
	
	@JsonProperty("views")
	private double views;

	@JsonProperty("description")
	private String description;

	public Movie() {
		
	}
	
	public Movie(int id, double likes, String description) {
		super();
		this.id = id;
		this.likes = likes;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getLikes() {
		return likes;
	}

	public void setLikes(double likes) {
		this.likes = likes;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getViews() {
		return views;
	}

	public void setViews(double views) {
		this.views = views;
	}

}
