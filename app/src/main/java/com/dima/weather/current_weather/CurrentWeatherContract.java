package com.dima.weather.current_weather;

import io.reactivex.Observable;

public interface CurrentWeatherContract {

    interface View{
        Observable<CharSequence> searchChanged();

        void setupSky(int sky);
        void setupWeatherStatus(String status);
        void setupTemperature(double temperature);
        void setupCity(String city);
        void setupWindSpeed(double speed);
        void setupPressure(double pressure);
        void setupHumidity(double humidity);
        void setupSunrise(String sunrise);
        void setupSunset(String sunset);
        void setupLastUpdate(String lastUpdate);

        void showLoading(boolean show);
        void showResult(boolean show);
    }

    interface Presenter{
        void start(View view);
        void stop();
    }
}
