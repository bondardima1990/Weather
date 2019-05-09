package com.dima.weather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.dima.weather.screens.weather.CurrentWeatherContract;
import com.dima.weather.screens.weather.CurrentWeatherPresenter;
import com.dima.weather.screens.weather.CurrentWeatherView;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    private CurrentWeatherContract.View view;
    private CurrentWeatherContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_search:
                Toast.makeText(getApplicationContext(), "Search", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_refresh:
                Toast.makeText(getApplicationContext(), "Refresh", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_settings:
                Intent settings = new Intent(this, SettingsActivity.class);
                startActivity(settings);
                break;
            case R.id.action_about:
                Intent about = new Intent(this, AboutActivity.class);
                startActivity(about);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
