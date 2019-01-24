package com.example.puneetpuneet.devradio.activities;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.puneetpuneet.devradio.R;
import com.example.puneetpuneet.devradio.fragements.MainFragment;
import com.example.puneetpuneet.devradio.fragements.detailsFrament;
import com.example.puneetpuneet.devradio.model.Station;

public class MainActivity extends AppCompatActivity{

    public static MainActivity getMainActivity() {
        return mainActivity;
    }

    private static void setMainActivity(MainActivity mainActivity) {
        MainActivity.mainActivity = mainActivity;
    }

    private static MainActivity mainActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainActivity.setMainActivity(this);
        FragmentManager fm = getSupportFragmentManager();
        MainFragment mainFragment = (MainFragment)fm.findFragmentById(R.id.containerMain);

        if (mainFragment==null){
            mainFragment = MainFragment.newInstance("blah", "Kah");
            fm.beginTransaction().add(R.id.containerMain, mainFragment).commit();
        }
    }

    public void loadDetailsScreen(Station selectedStation){
        getSupportFragmentManager().beginTransaction().replace(R.id.containerMain, new detailsFrament()).addToBackStack(null).commit();
    }

}
