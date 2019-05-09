package com.dima.weather.screens.weather;

import com.dima.weather.data.repositories.WeatherRepository;
import com.dima.weather.data.repositories.WeatherRepositoryImpl;
import com.dima.weather.utils.WeatherIcon;

import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class CurrentWeatherPresenter implements CurrentWeatherContract.Presenter {

    private CurrentWeatherContract.View view;
    private WeatherRepository repository;
    private CompositeDisposable subscriptions;

    @Override
    public void start(CurrentWeatherContract.View view) {
        this.view = view;
        subscriptions = new CompositeDisposable();
        repository = new WeatherRepositoryImpl();

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
                            view.showLoading(false);
                        }));

    }

    private void createWeather(String query) {
        if (!query.isEmpty()) {

            view.showLoading(true);
            view.showResult(false);

            subscriptions.add(repository.search(query)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            weather -> {
                                if (weather != null){

                                    view.setupIcon(WeatherIcon.setWeatherIcon(weather.getId(), weather.getSunrise(), weather.getSunset()));
                                    view.setupDescription(weather.getDescription());
                                    view.setupTemperature(weather.getTemperature());
                                    view.setupCity(weather.getCity());
                                    view.setupWindSpeed(weather.getWindSpeed());
                                    view.setupPressure(weather.getPressure());
                                    view.setupHumidity(weather.getHumidity());
                                    view.setupSunrise(weather.getSunrise());
                                    view.setupSunset(weather.getSunset());
                                    view.setupLastUpdate(weather.getDt());

                                    view.showLoading(false);
                                    view.showResult(true);

                                }
                            },
                            e -> {
                                view.showLoading(false);
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
