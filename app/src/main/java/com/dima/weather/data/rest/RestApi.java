package com.dima.weather.data.rest;

import com.dima.weather.data.dto.Response;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestApi {

    @GET("/data/2.5/weather?=")
    Observable<Response> getCurrentWeather(@Query("q") String city,
                                           @Query("units") String units,
                                           @Query("lang") String lang,
                                           @Query("appid") String appid);
}
