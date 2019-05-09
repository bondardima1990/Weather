package com.dima.weather.services.rest.dto;

import com.google.gson.annotations.SerializedName;

public class CityForecast {

	@SerializedName("country")
	private String country;

	@SerializedName("coord")
	private Coord coord;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private Integer id;

	@SerializedName("population")
	private Integer population;

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setCoord(Coord coord){
		this.coord = coord;
	}

	public Coord getCoord(){
		return coord;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return id;
	}

	public void setPopulation(Integer population){
		this.population = population;
	}

	public Integer getPopulation(){
		return population;
	}
}