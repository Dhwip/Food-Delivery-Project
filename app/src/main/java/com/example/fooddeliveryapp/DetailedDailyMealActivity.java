package com.example.fooddeliveryapp;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DetailedDailyMealActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<DetailedDailyModel> detailedDailyModels;
    DetailedDailyAdapter dailyAdapter;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_daily_meal);

        String type = getIntent().getStringExtra("type");

        recyclerView = findViewById(R.id.detailed_rec);
        imageView = findViewById(R.id.detailed_img);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        detailedDailyModels = new ArrayList<>();
        dailyAdapter = new DetailedDailyAdapter(detailedDailyModels);
        recyclerView.setAdapter(dailyAdapter);

        if(type!=null && type.equalsIgnoreCase("breakfast")){
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.fries,"Breakfast","description","4.5","80","10am to 11pm"));
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.ice_cream,"Breakfast","description","4.5","80","10am to 11pm"));
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.burger,"Breakfast","description","4.5","80","10am to 11pm"));
            dailyAdapter.notifyDataSetChanged();
        }
        if(type!=null && type.equalsIgnoreCase("sweet")){
            imageView.setImageResource(R.drawable.ice_cream);
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.fries,"Breakfast","description","4.5","80","10am to 11pm"));
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.ice_cream,"Breakfast","description","4.5","80","10am to 11pm"));
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.burger,"Breakfast","description","4.5","80","10am to 11pm"));
            dailyAdapter.notifyDataSetChanged();
        }

    }
}