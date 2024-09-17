package com.example.fooddeliveryapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddeliveryapp.HomeHorAdapter;
import com.example.fooddeliveryapp.HomeHorModel;
import com.example.fooddeliveryapp.HomeVerAdapter;
import com.example.fooddeliveryapp.HomeVerModel;
import com.example.fooddeliveryapp.R;
import com.example.fooddeliveryapp.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    RecyclerView homeHorizontalRec,homeVerticalRec;
    List<HomeHorModel> homeHorModelList;
    HomeHorAdapter homeHorAdapter;

    List<HomeVerModel> homeVerModelList;
    HomeVerAdapter homeVerAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        homeHorizontalRec = root.findViewById(R.id.home_hor_rec);
        homeVerticalRec = root.findViewById(R.id.home_ver_rec);
        homeHorModelList = new ArrayList<>();
        homeHorModelList.add(new HomeHorModel(R.drawable.pizza,"Pizza"));
        homeHorModelList.add(new HomeHorModel(R.drawable.burger,"Burger"));
        homeHorModelList.add(new HomeHorModel(R.drawable.fries,"Fries"));
        homeHorModelList.add(new HomeHorModel(R.drawable.ice_cream,"Ice Cream"));
        homeHorModelList.add(new HomeHorModel(R.drawable.sandwich,"Sandwich"));

        homeHorAdapter = new HomeHorAdapter(getActivity(),homeHorModelList);
        homeHorizontalRec.setAdapter(homeHorAdapter);
        homeHorizontalRec.setHasFixedSize(true);
        homeHorizontalRec.setNestedScrollingEnabled(false);
        homeHorizontalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));

        homeVerModelList = new ArrayList<>();
        homeVerModelList.add(new HomeVerModel(R.drawable.pizza1,"Pizza","11:00-21:00","4.1","Min - 99Rs"));
        homeVerModelList.add(new HomeVerModel(R.drawable.pizza1,"Pizza","11:00-21:00","4.1","Min - 99Rs"));
        homeVerModelList.add(new HomeVerModel(R.drawable.pizza1,"Pizza","11:00-21:00","4.1","Min - 99Rs"));

        homeVerAdapter = new HomeVerAdapter(getActivity(),homeVerModelList);
        homeVerticalRec.setAdapter(homeVerAdapter);
        homeVerticalRec.setHasFixedSize(true);
        homeVerticalRec.setNestedScrollingEnabled(false);
        homeVerticalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}