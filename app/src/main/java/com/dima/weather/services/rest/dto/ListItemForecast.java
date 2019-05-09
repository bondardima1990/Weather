package com.dima.weather.services.rest.dto;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ListItemForecast {

	@SerializedName("dt")
	private Integer dt;

	@SerializedName("rain")
	private RainForecast rain;

	@SerializedName("dt_txt")
	private String dtTxt;

	@SerializedName("rain")
	private SnowForecast snow;

	@SerializedName("weather")
	private List<WeatherItem> weather;

	@SerializedName("main")
	private MainForecast main;

	@SerializedName("clouds")
	private Clouds clouds;

	@SerializedName("sys")
	private SysForecast sys;

	@SerializedName("wind")
	private Wind wind;

	public void setDt(Integer dt){
		this.dt = dt;
	}

	public Integer getDt(){
		return dt;
	}

	public void setRain(RainForecast rain){
		this.rain = rain;
	}

	public RainForecast getRain(){
		return rain;
	}

	public void setDtTxt(String dtTxt){
		this.dtTxt = dtTxt;
	}

	public String getDtTxt(){
		return dtTxt;
	}

	public void setRain(SnowForecast snow){
		this.snow = snow;
	}

	public SnowForecast getSnow(){
		return snow;
	}

	public void setWeather(List<WeatherItem> weather){
		this.weather = weather;
	}

	public List<WeatherItem> getWeather(){
		return weather;
	}

	public void setMain(MainForecast main){
		this.main = main;
	}

	public MainForecast getMain(){
		return main;
	}

	public void setClouds(Clouds clouds){
		this.clouds = clouds;
	}

	public Clouds getClouds(){
		return clouds;
	}

	public void setSys(SysForecast sys){
		this.sys = sys;
	}

	public SysForecast getSys(){
		return sys;
	}

	public void setWind(Wind wind){
		this.wind = wind;
	}

	public Wind getWind(){
		return wind;
	}
}