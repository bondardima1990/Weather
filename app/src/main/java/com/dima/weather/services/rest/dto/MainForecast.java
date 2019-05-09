package com.dima.weather.services.rest.dto;
;
import com.google.gson.annotations.SerializedName;

public class MainForecast {

	@SerializedName("temp")
	private Double temp;

	@SerializedName("temp_min")
	private Double tempMin;

	@SerializedName("grnd_level")
	private Double grndLevel;

	@SerializedName("temp_kf")
	private Double tempKf;

	@SerializedName("humidity")
	private Integer humidity;

	@SerializedName("pressure")
	private Double pressure;

	@SerializedName("sea_level")
	private Double seaLevel;

	@SerializedName("temp_max")
	private Double tempMax;

	public void setTemp(Double temp){
		this.temp = temp;
	}

	public Double getTemp(){
		return temp;
	}

	public void setTempMin(Double tempMin){
		this.tempMin = tempMin;
	}

	public Double getTempMin(){
		return tempMin;
	}

	public void setGrndLevel(Double grndLevel){
		this.grndLevel = grndLevel;
	}

	public Double getGrndLevel(){
		return grndLevel;
	}

	public void setTempKf(Double tempKf){
		this.tempKf = tempKf;
	}

	public Double getTempKf(){
		return tempKf;
	}

	public void setHumidity(Integer humidity){
		this.humidity = humidity;
	}

	public Integer getHumidity(){
		return humidity;
	}

	public void setPressure(Double pressure){
		this.pressure = pressure;
	}

	public Double getPressure(){
		return pressure;
	}

	public void setSeaLevel(Double seaLevel){
		this.seaLevel = seaLevel;
	}

	public Double getSeaLevel(){
		return seaLevel;
	}

	public void setTempMax(Double tempMax){
		this.tempMax = tempMax;
	}

	public Double getTempMax(){
		return tempMax;
	}
}