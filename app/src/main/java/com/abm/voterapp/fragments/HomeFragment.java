package com.abm.voterapp.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.abm.voterapp.R;
import com.abm.voterapp.activities.AddCustomerActivity;
import com.abm.voterapp.databinding.FragmentHomeBinding;
import com.leo.searchablespinner.SearchableSpinner;
import com.leo.searchablespinner.interfaces.OnItemSelectListener;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    Activity activity;
    FragmentHomeBinding binding;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        activity = requireActivity();
        initViews();
        return binding.getRoot();
    }

    private void initViews() {

        binding.stateLinear.setOnClickListener(v -> showSearchableSpinnerLinear1());
        binding.districtLinear.setOnClickListener(v -> showSearchableSpinnerLinear2());
        binding.subdistrictLinear.setOnClickListener(v -> showSearchableSpinnerLinear3());

        binding.addSale.setOnClickListener(v -> startActivity(new Intent(activity, AddCustomerActivity.class)));

    }


    private void showSearchableSpinnerLinear1() {
        final SearchableSpinner searchableSpinner = new SearchableSpinner(activity);
        //Optional Parameters
        searchableSpinner.setWindowTitle("Search State");
        searchableSpinner.setShowKeyboardByDefault(false);

        //Setting up list items for spinner
        ArrayList<String> stateList = new ArrayList<>();
        stateList.add("M.P.");
        stateList.add("U.P.");
        stateList.add("Bihar");


        searchableSpinner.setSpinnerListItems(stateList);

        searchableSpinner.setOnItemSelectListener((k, s) -> binding.linear2.setVisibility(View.VISIBLE));

        searchableSpinner.show();
    }


    private void showSearchableSpinnerLinear2() {
        final SearchableSpinner searchableSpinner = new SearchableSpinner(activity);
        //Optional Parameters
        searchableSpinner.setWindowTitle("Search District");
        searchableSpinner.setShowKeyboardByDefault(false);

        //Setting up list items for spinner
        ArrayList<String> stateList = new ArrayList<>();
        stateList.add("Panna");
        stateList.add("Katni");
        stateList.add("Jabalpur");


        searchableSpinner.setSpinnerListItems(stateList);

        searchableSpinner.setOnItemSelectListener((k, s) -> binding.linear3.setVisibility(View.VISIBLE));

        searchableSpinner.show();
    }


    private void showSearchableSpinnerLinear3() {
        final SearchableSpinner searchableSpinner = new SearchableSpinner(activity);
        //Optional Parameters
        searchableSpinner.setWindowTitle("Search Sub District");
        searchableSpinner.setShowKeyboardByDefault(false);

        //Setting up list items for spinner
        ArrayList<String> stateList = new ArrayList<>();
        stateList.add("Shahnagar");
        stateList.add("Pawai");
        stateList.add("Bori");


        searchableSpinner.setSpinnerListItems(stateList);

        searchableSpinner.setOnItemSelectListener((k, s) -> binding.linear2.setVisibility(View.VISIBLE));

        searchableSpinner.show();
    }
}