package com.tinnovat.app.binmenqash;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

/**
 * Created by Rahul .
 */

public abstract class BaseFragment extends Fragment implements View.OnClickListener {

    //private AppPreferanceStore appPreferenceStore;
    Dialog progressDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*appPreferenceStore = new AppPreferanceStore(getActivity());
        appPreferenceStore.changeLocaleLanguage(appPreferenceStore.getLanguage());
        progressDialog = new Dialog(Objects.requireNonNull(getActivity()));
        progressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        progressDialog.setContentView(R.layout.dialog_progress);
        Objects.requireNonNull(progressDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        progressDialog.setCancelable(false);*/
    }
    public void startLoading(){
        progressDialog.show();
    }

    public void endLoading() {
        if (progressDialog != null) {
            progressDialog.cancel();
            progressDialog.hide();
        }
    }

    public abstract void initialiseViews(View view);

    public abstract void initialiseEventListners();

    /*public void setLanguage(Boolean language){
        appPreferenceStore.setLanguage(language);
    }

    public String getToken(){
        return appPreferenceStore.getToken();
    }

    public boolean getLanguage(){
        return appPreferenceStore.getLanguage();
    }*/

    public void showMessage(String message) {
        if (getActivity() != null)
         Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

   /* public void changeLanguage(Boolean language){
        appPreferenceStore.setLanguage(language);
        String languageToLoad;
        if (getLanguage()) {
            languageToLoad = "en"; // english
        } else {
            languageToLoad = "ar"; // arabic
        }

        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getContext().getResources().updateConfiguration(config,
                getContext().getResources().getDisplayMetrics());

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(this).attach(this).commit();
    }*/
    public boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }

    public void showErrorDilog(final boolean needToFinish){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
        builder1.setMessage(getResources().getString(R.string.no_internet));
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        if (needToFinish){
                            getActivity().onBackPressed();
                        }
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }
}
