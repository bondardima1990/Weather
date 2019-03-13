package com.dima.weather.utils;

import com.dima.weather.R;

import java.util.Date;

import timber.log.Timber;

public class WeatherIcon {
    public static int setWeatherIcon(int id, long sunrise, long sunset) {

        Timber.d("id = %s", id);

        int icon = 0;
        if (id == 800) {
            long currentTime = new Date().getTime();
            if (currentTime >= sunrise && currentTime < sunset){
                icon = R.string.weather_sunny;
            } else {
                icon = R.string.weather_clear_night;
            }
        } else {
            switch (id / 100) {
                case 2:
                    icon = R.string.weather_thunder;
                    break;
                case 3:
                    icon = R.string.weather_drizzle;
                    break;
                case 5:
                    icon = R.string.weather_rainy;
                    break;
                case 6:
                    icon = R.string.weather_snowy;
                    break;
                case 7:
                    icon = R.string.weather_foggy;
                    break;
                case 8:
                    icon = R.string.weather_cloudy;
                    break;
            }
        }
        return icon;
    }
}
