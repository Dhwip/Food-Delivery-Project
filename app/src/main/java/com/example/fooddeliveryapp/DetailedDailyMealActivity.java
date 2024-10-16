package com.example.fooddeliveryapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

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

    @SuppressLint({"NotifyDataSetChanged", "MissingInflatedId"})
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
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.breakfast01,"Breakfast","description","4.5","140","10am to 11pm"));
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.breakfast2,"Breakfast","description","4.5","190","10am to 11pm"));
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.breakfast3,"Breakfast","description","4.5","100","10am to 11pm"));
            dailyAdapter.notifyDataSetChanged();
        }
        if(type!=null && type.equalsIgnoreCase("lunch")){
            imageView.setImageResource(R.drawable.lunch);
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.lunch1,"lunch","description","4.5","200","10am to 11pm"));
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.lunch2,"lunch","description","4.5","240","10am to 11pm"));
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.lunch3,"lunch","description","4.5","270","10am to 11pm"));
            dailyAdapter.notifyDataSetChanged();
        }
        if(type!=null && type.equalsIgnoreCase("dinner")){
            imageView.setImageResource(R.drawable.dinner);
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.dinner1,"dinner","description","4.5","195","10am to 11pm"));
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.dinner2,"dinner","description","4.5","220","10am to 11pm"));
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.dinner3,"dinner","description","4.5","180","10am to 11pm"));
            dailyAdapter.notifyDataSetChanged();
        }
        if(type!=null && type.equalsIgnoreCase("coffee")){
            imageView.setImageResource(R.drawable.coffee4);
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.coffee1,"Cappuccino","description","4.5","120","10am to 11pm"));
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.coffee2,"Coffee","description","4.5","80","10am to 11pm"));
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.coffee3,"Coffee Mocha","description","4.5","100","10am to 11pm"));
            dailyAdapter.notifyDataSetChanged();
        }
        if(type!=null && type.equalsIgnoreCase("sweet")){
            imageView.setImageResource(R.drawable.sweet5);
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.sweet1,"Pastry","description","4.5","80","10am to 11pm"));
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.sweet8,"Pancake","description","4.5","90","10am to 11pm"));
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.sweet4,"Cream Roll","description","4.5","70","10am to 11pm"));
            dailyAdapter.notifyDataSetChanged();
        }

    }
}