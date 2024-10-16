package com.example.fooddeliveryapp.ui.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddeliveryapp.AddToCartListener;
import com.example.fooddeliveryapp.HomeHorAdapter;
import com.example.fooddeliveryapp.HomeHorModel;
import com.example.fooddeliveryapp.HomeVerAdapter;
import com.example.fooddeliveryapp.HomeVerModel;
import com.example.fooddeliveryapp.R;
import com.example.fooddeliveryapp.UpdateVerticalRec;
import java.util.ArrayList;

public class HomeFragment extends Fragment implements UpdateVerticalRec, AddToCartListener {

    RecyclerView homeHorizontalRec, homeVerticalRec;
    ArrayList<HomeHorModel> homeHorModelList;
    HomeHorAdapter homeHorAdapter;

    ArrayList<HomeVerModel> homeVerModelList;
    HomeVerAdapter homeVerAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        homeHorizontalRec = root.findViewById(R.id.home_hor_rec);
        homeVerticalRec = root.findViewById(R.id.home_ver_rec);
        homeHorModelList = new ArrayList<>();
        homeHorModelList.add(new HomeHorModel(R.drawable.pizza, "Pizza"));
        homeHorModelList.add(new HomeHorModel(R.drawable.burger4, "Burger"));
        homeHorModelList.add(new HomeHorModel(R.drawable.fries_icon, "Fries"));
        homeHorModelList.add(new HomeHorModel(R.drawable.icecream_icon, "Ice Cream"));
        homeHorModelList.add(new HomeHorModel(R.drawable.sandwich_icon, "Sandwich"));

        homeHorAdapter = new HomeHorAdapter(this, getActivity(), homeHorModelList);
        homeHorizontalRec.setAdapter(homeHorAdapter);
        homeHorizontalRec.setHasFixedSize(true);
        homeHorizontalRec.setNestedScrollingEnabled(false);
        homeHorizontalRec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));

        homeVerModelList = new ArrayList<>();
        homeVerAdapter = new HomeVerAdapter(getActivity(), homeVerModelList,this);//some changes to be done
        homeVerticalRec.setAdapter(homeVerAdapter);
        homeVerticalRec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));

        return root;
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void callBack(int position, ArrayList<HomeVerModel> list) {
        homeVerModelList.clear();
        homeVerModelList.addAll(list);
        homeVerAdapter.notifyDataSetChanged();
    }

    @Override
    public void onAddToCart(HomeVerModel item) {
        Toast.makeText(getActivity(), item.getName() + " added to cart", Toast.LENGTH_SHORT).show();
    }
}
