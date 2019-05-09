package com.dima.weather.services.rest.dto;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ResponseForecast {

	@SerializedName("city")
	private CityForecast city;

	@SerializedName("cnt")
	private Integer cnt;

	@SerializedName("cod")
	private String cod;

	@SerializedName("message")
	private Double message;

	@SerializedName("list")
	private List<ListItemForecast> list;

	public void setCity(CityForecast city){
		this.city = city;
	}

	public CityForecast getCity(){
		return city;
	}

	public void setCnt(Integer cnt){
		this.cnt = cnt;
	}

	public Integer getCnt(){
		return cnt;
	}

	public void setCod(String cod){
		this.cod = cod;
	}

	public String getCod(){
		return cod;
	}

	public void setMessage(Double message){
		this.message = message;
	}

	public Double getMessage(){
		return message;
	}

	public void setList(List<ListItemForecast> list){
		this.list = list;
	}

	public List<ListItemForecast> getList(){
		return list;
	}
}