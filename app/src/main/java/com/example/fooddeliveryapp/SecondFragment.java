package com.example.fooddeliveryapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class SecondFragment extends Fragment {

    List<FeaturedModel>  featuredModels;
    RecyclerView recyclerView;
    FeaturedAdapter featuredAdapter;

    List<FeaturedVerModel>  featuredVerModelsList;
    RecyclerView recyclerView2;
    FeaturedVerAdapter featuredVerAdapter;

    public SecondFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_first, container, false);

        recyclerView = view.findViewById(R.id.featured_hor_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        featuredModels = new ArrayList<>();

        featuredModels.add(new FeaturedModel(R.drawable.dinner,"Popular 1","Description 1"));
        featuredModels.add(new FeaturedModel(R.drawable.dinner,"Popular 2","Description 2"));
        featuredModels.add(new FeaturedModel(R.drawable.dinner,"Popular 3","Description 3"));

        featuredAdapter = new FeaturedAdapter(featuredModels);
        recyclerView.setAdapter(featuredAdapter);

        recyclerView2 = view.findViewById(R.id.featured_ver_rec);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        featuredVerModelsList = new ArrayList<>();

        featuredVerModelsList.add(new FeaturedVerModel(R.drawable.dinner,"Popular 1","Description 1","4.8","10:00-22:00"));
        featuredVerModelsList.add(new FeaturedVerModel(R.drawable.dinner,"Popular 2","Description 2","4.8","10:00-22:00"));
        featuredVerModelsList.add(new FeaturedVerModel(R.drawable.dinner,"Popular 3","Description 3","4.8","10:00-22:00"));
        featuredVerModelsList.add(new FeaturedVerModel(R.drawable.dinner,"Popular 4","Description 4","4.8","10:00-22:00"));
        featuredVerModelsList.add(new FeaturedVerModel(R.drawable.dinner,"Popular 5","Description 5","4.8","10:00-22:00"));
        featuredVerModelsList.add(new FeaturedVerModel(R.drawable.dinner,"Popular 6","Description 6","4.8","10:00-22:00"));

        featuredVerAdapter = new FeaturedVerAdapter(featuredVerModelsList);
        recyclerView2.setAdapter(featuredVerAdapter);
        return view;
    }
}