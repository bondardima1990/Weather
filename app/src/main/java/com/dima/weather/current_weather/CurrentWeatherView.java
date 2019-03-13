package com.dima.weather.current_weather;

import android.graphics.Typeface;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.dima.weather.R;
import com.dima.weather.utils.TimeFormatter;
import com.jakewharton.rxbinding2.widget.RxTextView;

import io.reactivex.Observable;

public class CurrentWeatherView implements CurrentWeatherContract.View {

    private View root;

    private EditText searchField;
    private TextView sky;
    private TextView status;
    private TextView temperature;
    private TextView city;
    private TextView windSpeed;
    private TextView pressure;
    private TextView humidity;
    private TextView sunrise;
    private TextView sunset;
    private TextView lastUpdate;

    private View progress;

    public CurrentWeatherView(View root) {
        this.root = root;
        initView();
    }

    private void initView() {
        searchField = root.findViewById(R.id.search);
        sky = root.findViewById(R.id.sky);
        sky.setTypeface(Typeface.createFromAsset(root.getContext().getAssets(), "fonts/weather.ttf"));
        status = root.findViewById(R.id.weather_status);
        temperature = root.findViewById(R.id.temperature);
        city = root.findViewById(R.id.city);
        windSpeed = root.findViewById(R.id.wind_speed);
        pressure = root.findViewById(R.id.pressure);
        humidity = root.findViewById(R.id.humidity);
        sunrise = root.findViewById(R.id.sunrise);
        sunset = root.findViewById(R.id.sunset);
        lastUpdate = root.findViewById(R.id.last_update);
        progress = root.findViewById(R.id.progress);
    }


    @Override
    public Observable<CharSequence> searchChanged() {
        return RxTextView.textChanges(searchField);
    }

    @Override
    public void setupSky(int sky) {
        this.sky.setText(sky);
    }

    @Override
    public void setupWeatherStatus(String status) {
        this.status.setText(status.substring(0,1).toUpperCase() + status.substring(1));
    }

    @Override
    public void setupTemperature(double temperature) {
        this.temperature.setText(String.format("%.1f", temperature) + " °C");
    }

    @Override
    public void setupCity(String city) {
        this.city.setText(city);
    }

    @Override
    public void setupWindSpeed(double speed) {
        this.windSpeed.setText(root.getResources().getString(R.string.wind_speed, String.valueOf(speed)));
    }

    @Override
    public void setupPressure(double pressure) {
        this.pressure.setText(root.getResources().getString(R.string.pressure, String.valueOf(pressure)));
    }

    @Override
    public void setupHumidity(double humidity) {
        this.humidity.setText(root.getResources().getString(R.string.humidity, String.valueOf(humidity)));
    }

    @Override
    public void setupSunrise(String sunrise) {
        this.sunrise.setText(root.getResources().getString(R.string.sunrise, TimeFormatter.timeFormatter(Long.valueOf(sunrise))));
    }

    @Override
    public void setupSunset(String sunset) {
        this.sunset.setText(root.getResources().getString(R.string.sunset, TimeFormatter.timeFormatter(Long.valueOf(sunset))));
    }

    @Override
    public void setupLastUpdate(String lastUpdate) {
        this.lastUpdate.setText(root.getResources().getString(R.string.last_update, TimeFormatter.timeFormatter(Long.valueOf(lastUpdate))));
    }

    @Override
    public void showLoading(boolean show) {
        progress.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showResult(boolean show) {
        if (show) {
            sky.setVisibility(View.VISIBLE);
            status.setVisibility(View.VISIBLE);
            temperature.setVisibility(View.VISIBLE);
            city.setVisibility(View.VISIBLE);
            windSpeed.setVisibility(View.VISIBLE);
            pressure.setVisibility(View.VISIBLE);
            humidity.setVisibility(View.VISIBLE);
            sunrise.setVisibility(View.VISIBLE);
            sunset.setVisibility(View.VISIBLE);
            lastUpdate.setVisibility(View.VISIBLE);
        } else {
            sky.setVisibility(View.GONE);
            status.setVisibility(View.GONE);
            temperature.setVisibility(View.GONE);
            city.setVisibility(View.GONE);
            windSpeed.setVisibility(View.GONE);
            pressure.setVisibility(View.GONE);
            humidity.setVisibility(View.GONE);
            sunrise.setVisibility(View.GONE);
            sunset.setVisibility(View.GONE);
            lastUpdate.setVisibility(View.GONE);
        }
    }
}