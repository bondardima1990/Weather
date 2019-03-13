package com.dima.weather.data;

import com.dima.weather.data.dto.Response;
import com.dima.weather.data.rest.RestApi;
import com.dima.weather.data.rest.RestClient;
import com.dima.weather.utils.Constants;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static com.dima.weather.utils.Constants.LANGUAGE;
import static com.dima.weather.utils.Constants.UNITS;

public class WeatherModel {

    private RestApi restApi;

    public WeatherModel() {
        restApi = RestClient.createApi();
    }

    public Observable<Response> resetModel(String city){
        return restApi
                .getCurrentWeather(city, UNITS, LANGUAGE, Constants.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
