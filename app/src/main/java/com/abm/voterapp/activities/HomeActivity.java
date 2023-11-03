package com.abm.voterapp.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.abm.voterapp.databinding.ActivityHomeBinding;
import com.abm.voterapp.fragments.HomeFragment;
import com.abm.voterapp.fragments.UsersFragment;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.model.KeyPath;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity  {
    ActivityHomeBinding binding;
    Activity activity;
   // private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        activity = this;


        setupNavBar();
        changeFragment(0);
        binding.rlHome.performClick();


    }

    private void setupNavBar() {
        binding.homeAnim.setMinAndMaxProgress(0.0f, 0.6f);
        binding.cartAnim.setMinAndMaxProgress(0.0f, 0.6f);
//        binding.catAnim.setMinAndMaxProgress(0.0f, 0.6f);
        binding.exploreAnim.setMinAndMaxProgress(0.0f, 0.5f);

        binding.homeAnim.addValueCallback(
                new KeyPath("**"),
                LottieProperty.COLOR_FILTER,
                frameInfo -> new PorterDuffColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP)
        );

        binding.catAnim.addValueCallback(
                new KeyPath("**"),
                LottieProperty.COLOR_FILTER,
                frameInfo -> new PorterDuffColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP)
        );

        binding.exploreAnim.addValueCallback(
                new KeyPath("**"),
                LottieProperty.COLOR_FILTER,
                frameInfo -> new PorterDuffColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP)
        );

        binding.cartAnim.addValueCallback(
                new KeyPath("**"),
                LottieProperty.COLOR_FILTER,
                frameInfo -> new PorterDuffColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP)
        );

        binding.profileAnim.addValueCallback(
                new KeyPath("**"),
                LottieProperty.COLOR_FILTER,
                frameInfo -> new PorterDuffColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP)
        );

        binding.rlHome.setOnClickListener(view -> {
            binding.homeAnim.playAnimation();
            changeFragment(0);
        });
        binding.rlCategory.setOnClickListener(view -> {
            binding.catAnim.playAnimation();
            changeFragment(1);
        });
        binding.rlExplore.setOnClickListener(view -> {
            binding.exploreAnim.playAnimation();
            changeFragment(2);
        });
        binding.rlCart.setOnClickListener(view -> {
            binding.cartAnim.playAnimation();
            changeFragment(3);
        });
        binding.rlProfile.setOnClickListener(view -> {
            binding.profileAnim.playAnimation();
            changeFragment(4);
        });


//        binding.searchLocation.setOnClickListener(view -> {
//            changeFragment(2);
//            binding.exploreAnim.playAnimation();
//        });

       // binding.favIcon.setOnClickListener(view -> startActivity(new Intent(activity, MyFavoriteListActivity.class)));

    }

    private void changeFragment(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                //binding.cardSerch.setVisibility(View.VISIBLE);
               // binding.header.setVisibility(View.VISIBLE);
                break;
//            case 3:
//                if (session.sharedPreferences.contains("user_id")) {
//                    fragment = new CartFragment();
//                    binding.cardSerch.setVisibility(View.GONE);
//                    binding.header.setVisibility(View.GONE);
//                } else loginRedirect();
//                break;
            case 2:
                fragment = new UsersFragment();
//                binding.cardSerch.setVisibility(View.GONE);
//                binding.header.setVisibility(View.GONE);
                break;
//            case 1:
//                fragment = new CategoryFragment();
//                binding.cardSerch.setVisibility(View.GONE);
//                binding.header.setVisibility(View.GONE);
//                break;
//            case 4:
//                if (session.sharedPreferences.contains("user_id")) {
//                    fragment = new ProfileFragment();
//                    binding.cardSerch.setVisibility(View.GONE);
//                    binding.header.setVisibility(View.GONE);
//                } else {
//                    loginRedirect();
//                }
//                //showPaymentConfirmDialog("100");
//                break;

            default:
                new HomeFragment();
        }
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction().replace(binding.container.getId(), fragment);
            ft.commit();
        }
    }

}