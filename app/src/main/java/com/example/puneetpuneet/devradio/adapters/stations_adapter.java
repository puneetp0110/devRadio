package com.example.puneetpuneet.devradio.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.puneetpuneet.devradio.R;
import com.example.puneetpuneet.devradio.activities.MainActivity;
import com.example.puneetpuneet.devradio.holders.station_view_holder;
import com.example.puneetpuneet.devradio.model.Station;
import java.util.ArrayList;

public class stations_adapter extends RecyclerView.Adapter<station_view_holder> {
    private ArrayList<Station> stations;

    public stations_adapter(ArrayList<Station> stations) {
        this.stations = stations;
    }

    @Override
    public void onBindViewHolder(@NonNull station_view_holder holder, final int position) {
        final Station station = stations.get(position);
        holder.updateUI(station);

        holder.itemView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                // Load the details
                MainActivity.getMainActivity().loadDetailsScreen(station);
            }
        });
    }

    @NonNull
    @Override
    public station_view_holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View stationCard = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_station, viewGroup, false);

        return new station_view_holder(stationCard);
    }

    @Override
    public int getItemCount() {
        return stations.size();
    }
}
