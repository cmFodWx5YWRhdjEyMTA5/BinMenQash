package com.tinnovat.app.binmenqash.authentication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.tinnovat.app.binmenqash.BaseFragment;
import com.tinnovat.app.binmenqash.R;
import com.tinnovat.app.binmenqash.home.HomeActivity;

/**
 * Created by Rahul
 */

public class SignupFragment extends BaseFragment {



    private boolean language;
//    private AppPreferanceStore appPreferanceStore;

   private EditText userName ;
   private EditText password;

    public static Fragment getInstance() {
        return new SignupFragment();
    }

    public static Fragment newInstance() {
        SignupFragment fragment = new SignupFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup, container, false);
        initialiseViews(view);
        // super.onCreateView(inflater,container,savedInstanceState);
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
            if (((AppCompatActivity) getActivity()).getSupportActionBar() != null)
                ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(getText(R.string.sign_up));
        }
        toolbar.setNavigationOnClickListener(this);
        return view;
    }

    @Override
    public void initialiseViews(View rootView) {

//        appPreferanceStore = new AppPreferanceStore(getContext());


        //todo tooltip
       /* new SimpleTooltip.Builder(getActivity())
                .anchorView(facebook)
                .text("facebook")
                .gravity(Gravity.TOP)
                .animated(true)
                .transparentOverlay(false)
                .build()
                .show();*/




    }



    @Override
    public void initialiseEventListners() {

    }

    @Override
    public void onClick(View v) {
        if (getActivity() != null)
            getActivity().onBackPressed();
    }

    private void doSignIn(){
        Intent i = new Intent(getActivity(), HomeActivity.class);
        startActivity(i);
    }

    private void doSignUp(){
        /*Intent i = new Intent(getActivity(), HomeActivity.class);
        startActivity(i);*/


    }


    private void showDilog(String message){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
        builder1.setMessage(message);
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }


}
