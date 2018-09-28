package com.tinnovat.app.binmenqash.authentication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.tinnovat.app.binmenqash.BaseFragment;
import com.tinnovat.app.binmenqash.R;
import com.tinnovat.app.binmenqash.home.HomeActivity;
import com.tinnovat.app.binmenqash.productList.ProductListActivity;

/**
 * Created by Rahul
 */

public class LoginFragment extends BaseFragment {

    private OnFragmentInteractionListener mListener;

    private boolean language;
//    private AppPreferanceStore appPreferanceStore;

   private EditText userName ;
   private EditText password;

    public static Fragment getInstance() {
        return new LoginFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        initialiseViews(view);
        // super.onCreateView(inflater,container,savedInstanceState);
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

       Button signIn = rootView.findViewById(R.id.signIn);
       TextView signUp = rootView.findViewById(R.id.sign_up);
       signIn.setOnClickListener(this);
        signUp.setOnClickListener(this);




    }

    @Override
    public void initialiseEventListners() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.signIn:
                doSignIn();
                break;

                case R.id.sign_up:
                    doSignUp();
                break;

        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private void doSignIn(){
        Intent i = new Intent(getActivity(), HomeActivity.class);
        startActivity(i);
    }

    private void doSignUp(){
        /*Intent i = new Intent(getActivity(), HomeActivity.class);
        startActivity(i);*/
        if (mListener != null) {
            mListener.onSignUpActionListener();
        }
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

    public interface OnFragmentInteractionListener {
        // void setTitle(String title);


        void onSignUpActionListener();
    }
}
