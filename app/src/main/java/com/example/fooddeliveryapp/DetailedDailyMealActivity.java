package com.example.fooddeliveryapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
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
    Button button;

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
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.fries,"Breakfast","description","4.5","80","10am to 11pm"));
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.breakfast1,"Breakfast","description","4.5","80","10am to 11pm"));
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.pizza4,"Breakfast","description","4.5","80","10am to 11pm"));
            dailyAdapter.notifyDataSetChanged();
        }
        if(type!=null && type.equalsIgnoreCase("lunch")){
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.img1,"lunch","description","4.5","80","10am to 11pm"));
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.img2,"lunch","description","4.5","80","10am to 11pm"));
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.sweet6,"lunch","description","4.5","80","10am to 11pm"));
            dailyAdapter.notifyDataSetChanged();
        }
        if(type!=null && type.equalsIgnoreCase("dinner")){
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.burger2,"dinner","description","4.5","80","10am to 11pm"));
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.breakfast1,"dinner","description","4.5","80","10am to 11pm"));
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.sweet7,"dinner","description","4.5","80","10am to 11pm"));
            dailyAdapter.notifyDataSetChanged();
        }
        if(type!=null && type.equalsIgnoreCase("coffee")){
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.coffee1,"coffee","description","4.5","80","10am to 11pm"));
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.coffee2,"coffee","description","4.5","80","10am to 11pm"));
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.coffee3,"coffee","description","4.5","80","10am to 11pm"));
            dailyAdapter.notifyDataSetChanged();
        }
        if(type!=null && type.equalsIgnoreCase("sweet")){
            imageView.setImageResource(R.drawable.ice_cream);
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.sweet1,"sweet","description","4.5","80","10am to 11pm"));
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.sweet2,"sweet","description","4.5","80","10am to 11pm"));
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.sweet3,"sweet","description","4.5","80","10am to 11pm"));
            dailyAdapter.notifyDataSetChanged();
        }
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(DetailedDailyMealActivity.this,MyCartFragment.class);
//                startActivity(intent);
//            }
//        });
    }
}