package com.dima.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dima.weather.current_weather.CurrentWeatherContract;
import com.dima.weather.current_weather.CurrentWeatherPresenter;
import com.dima.weather.current_weather.CurrentWeatherView;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    private CurrentWeatherContract.View view;
    private CurrentWeatherContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = new CurrentWeatherView(findViewById(R.id.root));
        presenter = new CurrentWeatherPresenter();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.start(view);
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.stop();
    }
}
