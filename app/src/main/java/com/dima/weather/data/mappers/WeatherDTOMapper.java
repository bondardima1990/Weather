package com.dima.weather.data.mappers;

import com.dima.weather.data.models.Weather;
import com.dima.weather.services.rest.dto.Response;

public class WeatherDTOMapper implements Mapper<Response, Weather> {

    @Override
    public Weather from(Response data) {
        return new Weather(
                data.getWeather().get(0).getId(),
                data.getWeather().get(0).getDescription(),
                data.getMain().getTemp(),
                data.getName(),
                data.getWind().getSpeed(),
                data.getMain().getPressure(),
                data.getMain().getHumidity(),
                data.getSys().getSunrise(),
                data.getSys().getSunset(),
                data.getDt()
        );
    }

    @Override
    public Response to(Response model) {
        return null;
    }
}
