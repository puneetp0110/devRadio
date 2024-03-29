package com.example.puneetpuneet.devradio.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.puneetpuneet.devradio.R;
import com.example.puneetpuneet.devradio.model.Station;

public class station_view_holder extends RecyclerView.ViewHolder {

    private ImageView mainImage;
    private TextView titleTextView;
    public station_view_holder(View itemView) {
        super(itemView);

        this.mainImage =(ImageView)itemView.findViewById(R.id.main_image);
        this.titleTextView =(TextView)itemView.findViewById(R.id.main_text);

    }
    public void updateUI(Station station){
        String uri = station.getImgUri();
        int resource = mainImage.getResources().getIdentifier(uri,null, mainImage.getContext().getPackageName());
        mainImage.setImageResource(resource);

        titleTextView.setText(station.getImgUri());
    }
}
