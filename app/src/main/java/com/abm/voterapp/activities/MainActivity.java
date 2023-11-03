package com.abm.voterapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.abm.voterapp.R;
import com.abm.voterapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        activity = this;


        binding.linearType1.setOnClickListener(v -> change1(1));
        binding.type1Tv.setOnClickListener(v -> change1(1));


        binding.linearType2.setOnClickListener(v -> change1(2));
        binding.type2Tv.setOnClickListener(v -> change1(2));


        binding.linearType3.setOnClickListener(v -> change1(3));
        binding.type3Tv.setOnClickListener(v -> change1(3));


        binding.linearType4.setOnClickListener(v -> change1(4));
        binding.type4Tv.setOnClickListener(v -> change1(4));


        binding.nextBtn.setOnClickListener(v -> {
            startActivity(new Intent(activity, LoginActivity.class));
            finish();
        });

    }

    private void change1(int c) {

        binding.nextBtn.setVisibility(View.VISIBLE);

        switch (c) {
            case 1:
                binding.linearType1.setBackgroundResource(R.drawable.login_type_bg);
                binding.linearType2.setBackgroundResource(R.drawable.edit_background);
                binding.linearType3.setBackgroundResource(R.drawable.edit_background);
                binding.linearType4.setBackgroundResource(R.drawable.edit_background);
                binding.type1Tv.setTextColor(getColor(R.color.white));
                binding.type2Tv.setTextColor(getColor(R.color.gray));
                binding.type3Tv.setTextColor(getColor(R.color.gray));
                binding.type4Tv.setTextColor(getColor(R.color.gray));
                break;


            case 2:
                binding.linearType1.setBackgroundResource(R.drawable.edit_background);
                binding.linearType2.setBackgroundResource(R.drawable.login_type_bg);
                binding.linearType3.setBackgroundResource(R.drawable.edit_background);
                binding.linearType4.setBackgroundResource(R.drawable.edit_background);
                binding.type2Tv.setTextColor(getColor(R.color.white));
                binding.type1Tv.setTextColor(getColor(R.color.gray));
                binding.type3Tv.setTextColor(getColor(R.color.gray));
                binding.type4Tv.setTextColor(getColor(R.color.gray));
                break;


            case 3:
                binding.linearType3.setBackgroundResource(R.drawable.login_type_bg);
                binding.linearType2.setBackgroundResource(R.drawable.edit_background);
                binding.linearType1.setBackgroundResource(R.drawable.edit_background);
                binding.linearType4.setBackgroundResource(R.drawable.edit_background);
                binding.type3Tv.setTextColor(getColor(R.color.white));
                binding.type2Tv.setTextColor(getColor(R.color.gray));
                binding.type1Tv.setTextColor(getColor(R.color.gray));
                binding.type4Tv.setTextColor(getColor(R.color.gray));
                break;

            case 4:
                binding.linearType4.setBackgroundResource(R.drawable.login_type_bg);
                binding.linearType2.setBackgroundResource(R.drawable.edit_background);
                binding.linearType3.setBackgroundResource(R.drawable.edit_background);
                binding.linearType1.setBackgroundResource(R.drawable.edit_background);
                binding.type4Tv.setTextColor(getColor(R.color.white));
                binding.type2Tv.setTextColor(getColor(R.color.gray));
                binding.type3Tv.setTextColor(getColor(R.color.gray));
                binding.type1Tv.setTextColor(getColor(R.color.gray));
                break;


        }


    }

}