package com.tinnovat.app.binmenqash.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import com.tinnovat.app.binmenqash.BaseActivity;
import com.tinnovat.app.binmenqash.R;


public class SplashScreenActivity extends BaseActivity {

    private static final int SPLASH_TIME_OUT = 3000;
   // private AppPreferanceStore appPreferanceStore;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        //appPreferanceStore = new AppPreferanceStore(this);
    }

    @Override
    public void initialiseViews() {
       /* FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener( this,  new OnSuccessListener<InstanceIdResult>() {
            @Override
            public void onSuccess(InstanceIdResult instanceIdResult) {
                String newToken = instanceIdResult.getToken();
                appPreferanceStore.setDeviceToken(newToken);
                Log.e("newToken",newToken);

            }
        });*/

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /*Intent i = getIntent();
                if (i.getBooleanExtra("fromNotification",false)){

                    if (appPreferanceStore.getToken() == null){
                        Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }else {
                        Intent intent = new Intent(SplashScreenActivity.this, NotificationActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }else {
                    if (appPreferanceStore.getToken() == null){
                        Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }else {
                        Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                        intent.putExtra("status",false);
                        startActivity(intent);
                        finish();
                    }
                }*/
                showMessage("doneeee");

                Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();


                /*if (appPreferanceStore.getToken() == null){
                    Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    if(getIntent().hasExtra("key1")){
                        Intent intent = new Intent(SplashScreenActivity.this, NotificationActivity.class);
                        startActivity(intent);
                        finish();
                    }else {
                        Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                        intent.putExtra("status",false);
                        startActivity(intent);
                        finish();
                    }
                }*/


            }
        }, SPLASH_TIME_OUT);
    }

    @Override
    public void initialiseEventListners() {

    }

    @Override
    public void onClick(View v) {
    }
}