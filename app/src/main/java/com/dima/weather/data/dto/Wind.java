package com.dima.weather.data.dto;

import com.google.gson.annotations.SerializedName;

public class Wind{

	@SerializedName("deg")
	private Double deg;

	@SerializedName("speed")
	private Double speed;

	public Double getDeg() {
		return deg;
	}

	public void setDeg(Double deg) {
		this.deg = deg;
	}

	public Double getSpeed() {
		return speed;
	}

	public void setSpeed(Double speed) {
		this.speed = speed;
	}
}