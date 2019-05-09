package com.dima.weather.services.rest;

import com.dima.weather.services.rest.dto.Response;
import com.dima.weather.services.rest.dto.ResponseForecast;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestApi {

    @GET("/data/2.5/weather?=")
    Observable<Response> getCurrentWeather(@Query("q") String city,
                                           @Query("units") String units,
                                           @Query("lang") String lang,
                                           @Query("appid") String appid);

    @GET("/data/2.5/forecast?=")
    Observable<ResponseForecast> getForecastWeather(@Query("q") String city,
                                                    @Query("units") String units,
                                                    @Query("lang") String lang,
                                                    @Query("appid") String appid);
}
