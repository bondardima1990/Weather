package com.dima.weather.screens.weather;

import io.reactivex.Observable;

public interface CurrentWeatherContract {

    interface View{
        Observable<CharSequence> searchChanged();

        void setupIcon(int icon);
        void setupDescription(String description);
        void setupTemperature(double temperature);
        void setupCity(String city);
        void setupWindSpeed(double speed);
        void setupPressure(double pressure);
        void setupHumidity(double humidity);
        void setupSunrise(int sunrise);
        void setupSunset(int sunset);
        void setupLastUpdate(int lastUpdate);

        void showLoading(boolean show);
        void showResult(boolean show);
    }

    interface Presenter{
        void start(View view);
        void stop();
    }
}
