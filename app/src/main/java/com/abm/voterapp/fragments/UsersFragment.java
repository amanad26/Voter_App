package com.abm.voterapp.fragments;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abm.voterapp.R;
import com.abm.voterapp.adapters.UsersListAdapter;
import com.abm.voterapp.databinding.FragmentUsersBinding;

public class UsersFragment extends Fragment {

    FragmentUsersBinding binding;
    Activity activity;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentUsersBinding.inflate(getLayoutInflater());
        activity = requireActivity();
        initViews();
        return binding.getRoot();
    }

    private void initViews() {

        binding.recycler.setLayoutManager(new LinearLayoutManager(activity));
        binding.recycler.setAdapter(new UsersListAdapter());

    }
}