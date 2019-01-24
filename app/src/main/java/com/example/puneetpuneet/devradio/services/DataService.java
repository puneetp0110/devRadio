package com.example.puneetpuneet.devradio.services;

import com.example.puneetpuneet.devradio.model.Station;

import java.util.ArrayList;

public class DataService {
    private static final DataService ourInstance = new DataService();

    public static DataService getInstance() {
        return ourInstance;
    }

    private DataService() {
    }

    public ArrayList<Station> getFeaturedStation(){
        ArrayList<Station> list = new ArrayList<>();

        list.add(new Station("Flight Plan","flightplanmusic"));
        list.add(new Station("Two Wheeling", "bicyclemusic"));
        list.add(new Station("Kids Jam","kidsmusic"));

        return list;
    }
    //Pretend we just downloaded featured stations from internet
    public ArrayList<Station> getRecentStation(){
        ArrayList<Station> list = new ArrayList<>();



        return list;
    }
    public ArrayList<Station> getPartyStation(){
        ArrayList<Station> list = new ArrayList<>();


        return list;
    }
}
