package com.abm.voterapp.activities;

import static java.lang.Thread.sleep;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.abm.voterapp.databinding.ActivitySplashBinding;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.util.List;


public class SplashActivity extends AppCompatActivity {
    ActivitySplashBinding binding;
    Activity activity;
    private static int SPLASH_SCREEN_TIME_OUT = 1900;
    // private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        activity = this;
        // session = new Session(activity);
//        checkApp();


        Dexter.withContext(activity)
                .withPermissions(
                        Manifest.permission.CAMERA
                ).withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {

                        new Thread(() -> {
                            try {
                                sleep(2000);
                                startActivity(new Intent(activity, MainActivity.class));
                                finish();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }).start();

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> list, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();
                    }
                }).check();


    }

 /*   private void checkApp() {

        RetrofitClient.getAppLock(activity).checkApp(BaseUrls.APPID).enqueue(new Callback<AppLockModel>() {
            @Override
            public void onResponse(@NonNull Call<AppLockModel> call, @NonNull Response<AppLockModel> response) {
                if (response.code() == 200)
                    if (response.body() != null)
                        if (response.body().getResult().equalsIgnoreCase("true")) {


                            Dexter.withContext(activity)
                                    .withPermissions(
                                            Manifest.permission.CAMERA
                                    ).withListener(new MultiplePermissionsListener() {
                                        @Override
                                        public void onPermissionsChecked(MultiplePermissionsReport report) {
                                            if (session.sharedPreferences.contains("user_id")) {

                                                if (session.getType().equalsIgnoreCase("user")) {
                                                    Intent i = new Intent(SplashActivity.this, HomeActivity.class);
                                                    startActivity(i);
                                                    finish();
                                                } else {
                                                    Intent i = new Intent(SplashActivity.this, Co_HomeActivity.class);
                                                    startActivity(i);
                                                    finish();
                                                }
                                            } else {
                                                if (session.getIsIntroViewed()) {
                                                    Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                                                    startActivity(i);
                                                    finish();
                                                } else {
                                                    Intent i = new Intent(SplashActivity.this, GetStartedActivityActivity.class);
                                                    startActivity(i);
                                                    finish();
                                                }

                                            }
                                        }

                                        @Override
                                        public void onPermissionRationaleShouldBeShown(List<PermissionRequest> list, PermissionToken permissionToken) {
                                            permissionToken.continuePermissionRequest();
                                            Toast.makeText(activity, "Permissions Required to Scan!", Toast.LENGTH_SHORT).show();
                                        }
                                    }).check();


                        } else {
                            Toast.makeText(activity, "Server Not Respond..!", Toast.LENGTH_SHORT).show();
                        }
            }

            @Override
            public void onFailure(@NonNull Call<AppLockModel> call, @NonNull Throwable t) {
                Toast.makeText(activity, "Server Not Respond..!", Toast.LENGTH_SHORT).show();
            }
        });

    }
   */

}