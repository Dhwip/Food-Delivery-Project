package com.example.fooddeliveryapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class HomeVerAdapter extends RecyclerView.Adapter<HomeVerAdapter.ViewHolder>  {

    private BottomSheetDialog bottomSheetDialog;
    Context context;
    ArrayList<HomeVerModel> list;
    AddToCartListener addToCartListener;

    FragmentManager fragmentManager;

    public HomeVerAdapter(Context context, ArrayList<HomeVerModel> list, AddToCartListener addToCartListener, FragmentManager fragmentManager) {
        this.context = context;
        this.list = list;
        this.addToCartListener = addToCartListener;
        this.fragmentManager = fragmentManager;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_vertical_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final HomeVerModel currentItem = list.get(position);
        final String mName = list.get(position).getName();
        final String mtiming = list.get(position).getTiming();
        final String mRating = list.get(position).getRating();
        final String mPrice = list.get(position).getPrices();
        final int mImage = list.get(position).getImage();

        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());
        holder.timing.setText(list.get(position).getTiming());
        holder.rating.setText(list.get(position).getRating());
        holder.price.setText(list.get(position).getPrices());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog = new BottomSheetDialog(context,R.style.BottomSheetTheme);
                View sheetView = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_layout,null);
                sheetView.findViewById(R.id.add_to_cart).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        CartModel cartItem = new CartModel(currentItem.getImage(), currentItem.getName(), currentItem.getPrices(), currentItem.getRating());
                        CartManager.getInstance().addItem(cartItem);
                        addToCartListener.onAddToCart(currentItem);
                        Snackbar snackbar = Snackbar.make(holder.itemView, "Added to Cart", Snackbar.LENGTH_LONG);
                        snackbar.setAction("View Cart", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                            }
                        });
                        snackbar.show();
                        bottomSheetDialog.dismiss();
                    }
                });
                ImageView bottomImg = sheetView.findViewById(R.id.bottom_img);
                TextView bottomName = sheetView.findViewById(R.id.bottom_name);
                TextView bottomRating = sheetView.findViewById(R.id.bottom_rating);
                TextView bottomTime = sheetView.findViewById(R.id.bottom_timing);
                TextView bottomPrice = sheetView.findViewById(R.id.bottom_price);

                bottomName.setText(mName);
                bottomRating.setText(mRating);
                bottomTime.setText(mtiming);
                bottomImg.setImageResource(mImage);
                bottomPrice.setText(mPrice);

                bottomSheetDialog.setContentView(sheetView);
                bottomSheetDialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name,timing,rating,price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ver_img);
            name = itemView.findViewById(R.id.name);
            timing = itemView.findViewById(R.id.timing);
            rating = itemView.findViewById(R.id.rating);
            price = itemView.findViewById(R.id.price);
        }
    }
}
