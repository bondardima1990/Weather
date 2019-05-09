package com.dima.weather.data.repositories;

import com.dima.weather.data.models.Weather;

import io.reactivex.Observable;

public interface WeatherRepository {
    Observable<Weather> search(String query);
}
