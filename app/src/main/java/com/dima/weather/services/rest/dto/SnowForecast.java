package com.dima.weather.services.rest.dto;

import com.google.gson.annotations.SerializedName;

public class SnowForecast {

    @SerializedName("3h")
    private Double jsonMember3h;

    public void setJsonMember3h(Double jsonMember3h){
        this.jsonMember3h = jsonMember3h;
    }

    public Double getJsonMember3h(){
        return jsonMember3h;
    }
}