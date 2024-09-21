package com.example.fooddeliveryapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeHorAdapter extends RecyclerView.Adapter<HomeHorAdapter.ViewHolder> {
    UpdateVerticalRec updateVerticalRec;
    Activity activity;
    ArrayList<HomeHorModel> list;

    int row_index = 0; // Set the default to "Pizza" (position 0)

    public HomeHorAdapter(UpdateVerticalRec updateVerticalRec, Activity activity, ArrayList<HomeHorModel> list) {
        this.updateVerticalRec = updateVerticalRec;
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_horizontal_item, parent, false));
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.imageView.setImageResource(list.get(position).getImg());
        holder.name.setText(list.get(position).getName());

        // Set the default vertical list to "Pizza" items when the app is first opened
        if (position == 0 && row_index == 0) {
            ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
            homeVerModels.add(new HomeVerModel(R.drawable.pizza, "Pizza 1", "10:00-22:00", "4.9", "Min - 89Rs"));
            homeVerModels.add(new HomeVerModel(R.drawable.pizza, "Pizza 2", "10:00-22:00", "4.9", "Min - 89Rs"));
            homeVerModels.add(new HomeVerModel(R.drawable.pizza, "Pizza 3", "10:00-22:00", "4.9", "Min - 89Rs"));
            homeVerModels.add(new HomeVerModel(R.drawable.pizza, "Pizza 4", "10:00-22:00", "4.9", "Min - 89Rs"));
            updateVerticalRec.callBack(position, homeVerModels);
        }

        holder.cardView.setOnClickListener(v -> {
            row_index = position;
            notifyDataSetChanged();

            ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
            switch (position) {
                case 0:
                    homeVerModels.add(new HomeVerModel(R.drawable.pizza, "Pizza 1", "10:00-22:00", "4.9", "Min - 89Rs"));
                    homeVerModels.add(new HomeVerModel(R.drawable.pizza, "Pizza 2", "10:00-22:00", "4.9", "Min - 89Rs"));
                    homeVerModels.add(new HomeVerModel(R.drawable.pizza, "Pizza 3", "10:00-22:00", "4.9", "Min - 89Rs"));
                    homeVerModels.add(new HomeVerModel(R.drawable.pizza, "Pizza 4", "10:00-22:00", "4.9", "Min - 89Rs"));
                    break;
                case 1:
                    homeVerModels.add(new HomeVerModel(R.drawable.burger1, "Burger 1", "10:00-22:00", "4.9", "Min - 89Rs"));
                    homeVerModels.add(new HomeVerModel(R.drawable.burger1, "Burger 2", "10:00-22:00", "4.9", "Min - 89Rs"));
                    homeVerModels.add(new HomeVerModel(R.drawable.burger1, "Burger 3", "10:00-22:00", "4.9", "Min - 89Rs"));
                    homeVerModels.add(new HomeVerModel(R.drawable.burger1, "Burger 4", "10:00-22:00", "4.9", "Min - 89Rs"));
                    break;
                case 2:
                    homeVerModels.add(new HomeVerModel(R.drawable.fries, "Fries 1", "10:00-22:00", "4.9", "Min - 89Rs"));
                    homeVerModels.add(new HomeVerModel(R.drawable.fries, "Fries 2", "10:00-22:00", "4.9", "Min - 89Rs"));
                    homeVerModels.add(new HomeVerModel(R.drawable.fries, "Fries 3", "10:00-22:00", "4.9", "Min - 89Rs"));
                    homeVerModels.add(new HomeVerModel(R.drawable.fries, "Fries 4", "10:00-22:00", "4.9", "Min - 89Rs"));
                    break;
                case 3:
                    homeVerModels.add(new HomeVerModel(R.drawable.icecream1, "Ice Cream 1", "10:00-22:00", "4.9", "Min - 89Rs"));
                    homeVerModels.add(new HomeVerModel(R.drawable.icecream2, "Ice Cream 2", "10:00-22:00", "4.9", "Min - 89Rs"));
                    homeVerModels.add(new HomeVerModel(R.drawable.icecream3, "Ice Cream 3", "10:00-22:00", "4.9", "Min - 89Rs"));
                    homeVerModels.add(new HomeVerModel(R.drawable.icecream1, "Ice Cream 4", "10:00-22:00", "4.9", "Min - 89Rs"));
                    break;
                case 4:
                    homeVerModels.add(new HomeVerModel(R.drawable.sandwich, "Sandwich 1", "10:00-22:00", "4.9", "Min - 89Rs"));
                    homeVerModels.add(new HomeVerModel(R.drawable.sandwich, "Sandwich 2", "10:00-22:00", "4.9", "Min - 89Rs"));
                    homeVerModels.add(new HomeVerModel(R.drawable.sandwich, "Sandwich 3", "10:00-22:00", "4.9", "Min - 89Rs"));
                    homeVerModels.add(new HomeVerModel(R.drawable.sandwich, "Sandwich 4", "10:00-22:00", "4.9", "Min - 89Rs"));
                    break;
            }

            updateVerticalRec.callBack(position, homeVerModels);
        });

        // Change background color for selected item
        if (row_index == position) {
            holder.cardView.setBackgroundResource(R.drawable.change_bg);
        } else {
            holder.cardView.setBackgroundResource(R.drawable.defalut_bg);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.hor_img);
            name = itemView.findViewById(R.id.hor_text);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
