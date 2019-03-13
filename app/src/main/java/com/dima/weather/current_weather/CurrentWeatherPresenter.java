package com.dima.weather.current_weather;

import com.dima.weather.data.WeatherModel;
import com.dima.weather.utils.WeatherIcon;

import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class CurrentWeatherPresenter implements CurrentWeatherContract.Presenter {

    private CurrentWeatherContract.View view;
    private WeatherModel weatherModel;
    private CompositeDisposable subscriptions;

    @Override
    public void start(CurrentWeatherContract.View view) {
        this.view = view;
        subscriptions = new CompositeDisposable();
        weatherModel = new WeatherModel();

        view.showResult(false);

        subscriptions.add(
                view.searchChanged()
                        .debounce(400, TimeUnit.MILLISECONDS)
                        .skip(1)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(charSequence -> {
                            String query = charSequence.toString().trim();
                            createWeather(query);
                        }, e-> {

                        }));

    }

    private void createWeather(String query) {
        if (!query.isEmpty()) {
            view.showLoading(true);
            subscriptions.add(weatherModel.resetModel(query)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(response -> {
                        if (response != null) {
                            view.showLoading(false);
                            view.showResult(true);

                            if (response.getWeather() != null & !response.getWeather().isEmpty()) {
                                view.setupWeatherStatus(response.getWeather().get(0).getDescription());
                                view.setupSky(WeatherIcon.setWeatherIcon(response.getWeather().get(0).getId(), response.getSys().getSunrise(), response.getSys().getSunset()));
                            }

                            if (response.getWind() != null) {
                                view.setupWindSpeed(response.getWind().getSpeed());
                            }

                            if (response.getSys() != null) {
                                view.setupSunrise(response.getSys().getSunrise().toString());
                                view.setupSunset(response.getSys().getSunset().toString());
                                view.setupCity(response.getName() + ", " + response.getSys().getCountry());
                            }

                            if (response.getMain() != null) {
                                view.setupTemperature(response.getMain().getTemp());
                                view.setupPressure(response.getMain().getPressure());
                                view.setupHumidity(response.getMain().getHumidity());
                            }

                            if (response.getDt() != null) {
                                view.setupLastUpdate(response.getDt().toString());
                            }
                        }
                    }, e-> {

                    }));
        } else {
            view.showLoading(false);
        }
    }

    @Override
    public void stop() {
        view = null;
        subscriptions.dispose();
        subscriptions = null;
    }
}
