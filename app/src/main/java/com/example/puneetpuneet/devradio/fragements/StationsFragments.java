package com.example.puneetpuneet.devradio.fragements;


import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.puneetpuneet.devradio.R;
import com.example.puneetpuneet.devradio.adapters.stations_adapter;
import com.example.puneetpuneet.devradio.services.DataService;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StationsFragments#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StationsFragments extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "stationType";

    // TODO: Rename and change types of parameters
    private int stationType;
    public static final int STATION_TYPE_FEATURED = 0;
    public static final int STATION_TYPE_RECENT = 1 ;
    public static final int STATION_TYPE_PARTY = 2 ;

    public StationsFragments() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param stationType Radio Stations Type
     * @return A new instance of fragment StationsFragments.
     */
    // TODO: Rename and change types and number of parameters
    public static StationsFragments newInstance(int stationType) {
        StationsFragments fragment = new StationsFragments();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, stationType);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            stationType = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_stations_fragments, container, false);
        RecyclerView recyclerView = (RecyclerView)v.findViewById(R.id.recycler_stations);

        recyclerView.setHasFixedSize(true);

        stations_adapter adapter;

        if(stationType == STATION_TYPE_FEATURED){
            adapter= new stations_adapter(DataService.getInstance().getFeaturedStation());
        }else if(stationType == STATION_TYPE_PARTY){
            adapter= new stations_adapter(DataService.getInstance().getFeaturedStation());
        }else{
            adapter = new stations_adapter(DataService.getInstance().getFeaturedStation());
        }
        recyclerView.addItemDecoration(new HorizontalSpaceItemDecorator(30));
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);

        // Inflate the layout for this fragment
        return v;
    }

}

class HorizontalSpaceItemDecorator extends RecyclerView.ItemDecoration{

    private final int spacer;

    public HorizontalSpaceItemDecorator(int spacer) {
        this.spacer = spacer;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.right = spacer;
    }
}
