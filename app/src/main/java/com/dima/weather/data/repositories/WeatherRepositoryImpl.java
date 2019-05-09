package com.dima.weather.data.repositories;

import com.dima.weather.data.mappers.WeatherDTOMapper;
import com.dima.weather.data.models.Weather;
import com.dima.weather.services.rest.RestApi;
import com.dima.weather.services.rest.RestClient;
import com.dima.weather.utils.Constants;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static com.dima.weather.utils.Constants.LANGUAGE;
import static com.dima.weather.utils.Constants.UNITS;

public class WeatherRepositoryImpl implements WeatherRepository {

    private RestApi restApi;
    private WeatherDTOMapper weatherDTOMapper;

    public WeatherRepositoryImpl() {
        restApi = RestClient.createApi();
        weatherDTOMapper = new WeatherDTOMapper();
    }

    @Override
    public Observable<Weather> search(String query) {
        return restApi.getCurrentWeather(query, UNITS, LANGUAGE, Constants.API_KEY)
                .map(
                        it -> {
                            Weather weather = null;
                            if (it.getWeather() != null) {
                                weather = weatherDTOMapper.from(it);
                            }
                            return weather;
                        }
                )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
