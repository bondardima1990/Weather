package com.dima.weather.services.rest.dto;

import com.google.gson.annotations.SerializedName;

public class SysForecast {

	@SerializedName("pod")
	private String pod;

	public void setPod(String pod){
		this.pod = pod;
	}

	public String getPod(){
		return pod;
	}
}