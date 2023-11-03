package com.abm.voterapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.abm.voterapp.R;
import com.abm.voterapp.databinding.ActivityAddCustomerBinding;
import com.github.dhaval2404.imagepicker.ImagePicker;

public class AddCustomerActivity extends AppCompatActivity {

    ActivityAddCustomerBinding binding;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddCustomerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        activity = this;

        binding.selectImageTv.setOnClickListener(v -> ImagePicker.with(activity)
                .crop()//Crop image(Optional), Check Customization for more option
                .cameraOnly()
                .compress(1024)            //Final image size will be less than 1 MB(Optional)
                .maxResultSize(1080, 1080)    //Final image resolution will be less than 1080 x 1080(Optional)
                .start(100));

        binding.selectImage2Tv.setOnClickListener(v -> ImagePicker.with(activity)
                .crop()//Crop image(Optional), Check Customization for more option
                .cameraOnly()
                .compress(1024)            //Final image size will be less than 1 MB(Optional)
                .maxResultSize(1080, 1080)    //Final image resolution will be less than 1080 x 1080(Optional)
                .start(300));


    }


}