package com.tinnovat.app.binmenqash.authentication;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.tinnovat.app.binmenqash.BaseActivity;
import com.tinnovat.app.binmenqash.R;

public class LoginActivity extends BaseActivity implements LoginFragment.OnFragmentInteractionListener{


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public void initialiseViews() {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, LoginFragment.getInstance()).addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void initialiseEventListners() {

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
        }
    }

    private void doSignup(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, SignupFragment.getInstance());
        transaction.addToBackStack(null).commit();
    }

    @Override
    public void onSignUpActionListener() {
        showMessage("664784");
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, SignupFragment.newInstance());
        transaction.addToBackStack(null).commit();
    }
}
