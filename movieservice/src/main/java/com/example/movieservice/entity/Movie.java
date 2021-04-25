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

	@JsonProperty("price")
	private double price;

	@JsonProperty("description")
	private String description;

	public Movie() {
		
	}
	
	public Movie(int id, double price, String description) {
		super();
		this.id = id;
		this.price = price;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
