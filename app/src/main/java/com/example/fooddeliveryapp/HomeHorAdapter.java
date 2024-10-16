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

    int row_index = 0;

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

        if (position == 0 && row_index == 0) {
            ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
            homeVerModels.add(new HomeVerModel(R.drawable.pizza1, "Pizza 1", "10:00-22:00", "89Rs", "4.9"));
            homeVerModels.add(new HomeVerModel(R.drawable.pizza2, "Pizza 2", "10:00-22:00", "89Rs", "4.9"));
            homeVerModels.add(new HomeVerModel(R.drawable.pizza3, "Pizza 3", "10:00-22:00", "89Rs", "4.9"));
            homeVerModels.add(new HomeVerModel(R.drawable.pizza4, "Pizza 4", "10:00-22:00", "89Rs", "4.9"));
            updateVerticalRec.callBack(position, homeVerModels);
        }

        holder.cardView.setOnClickListener(v -> {
            row_index = position;
            notifyDataSetChanged();

            ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
            switch (position) {
                case 0:
                    homeVerModels.add(new HomeVerModel(R.drawable.pizza1, "Pizza 1", "10:00-22:00", "189Rs", "4.9"));
                    homeVerModels.add(new HomeVerModel(R.drawable.pizza2, "Pizza 2", "10:00-22:00", "229Rs", "4.9"));
                    homeVerModels.add(new HomeVerModel(R.drawable.pizza3, "Pizza 3", "10:00-22:00", "169Rs", "4.9"));
                    homeVerModels.add(new HomeVerModel(R.drawable.pizza4, "Pizza 4", "10:00-22:00", "99Rs", "4.9"));
                    break;
                case 1:
                    homeVerModels.add(new HomeVerModel(R.drawable.burger1, "Burger 1", "10:00-22:00", "129Rs", "4.9"));
                    homeVerModels.add(new HomeVerModel(R.drawable.burger2, "Burger 2", "10:00-22:00", "149Rs", "4.9"));
                    homeVerModels.add(new HomeVerModel(R.drawable.burger3, "Burger 3", "10:00-22:00", "89Rs", "4.9"));
                    homeVerModels.add(new HomeVerModel(R.drawable.burger4, "Burger 4", "10:00-22:00", "59Rs", "4.9"));
                    break;
                case 2:
                    homeVerModels.add(new HomeVerModel(R.drawable.fries1, "Fries 1", "10:00-22:00", "99Rs", "4.9"));
                    homeVerModels.add(new HomeVerModel(R.drawable.fries2, "Fries 2", "10:00-22:00", "79Rs", "4.9"));
                    homeVerModels.add(new HomeVerModel(R.drawable.fries3, "Fries 3", "10:00-22:00", "69Rs", "4.9"));
                    homeVerModels.add(new HomeVerModel(R.drawable.fries4, "Fries 4", "10:00-22:00", "59Rs", "4.9"));
                    break;
                case 3:
                    homeVerModels.add(new HomeVerModel(R.drawable.icecream1, "Ice Cream 1", "10:00-22:00", "129Rs", "4.9"));
                    homeVerModels.add(new HomeVerModel(R.drawable.icecream2, "Ice Cream 2", "10:00-22:00", "99Rs", "4.9"));
                    homeVerModels.add(new HomeVerModel(R.drawable.icecream3, "Ice Cream 3", "10:00-22:00", "89Rs", "4.9"));
                    homeVerModels.add(new HomeVerModel(R.drawable.icecream1, "Ice Cream 4", "10:00-22:00", "79Rs", "4.9"));
                    break;
                case 4:
                    homeVerModels.add(new HomeVerModel(R.drawable.sandwich1, "Sandwich 1", "10:00-22:00", "199Rs", "4.9"));
                    homeVerModels.add(new HomeVerModel(R.drawable.sandwich2, "Sandwich 2", "10:00-22:00", "169Rs", "4.9"));
                    homeVerModels.add(new HomeVerModel(R.drawable.sandwich3, "Sandwich 3", "10:00-22:00", "149Rs", "4.9"));
                    homeVerModels.add(new HomeVerModel(R.drawable.sandwich4, "Sandwich 4", "10:00-22:00", "99Rs", "4.9"));
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
