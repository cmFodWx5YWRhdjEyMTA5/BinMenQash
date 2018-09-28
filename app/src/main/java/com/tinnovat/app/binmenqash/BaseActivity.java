package com.tinnovat.app.binmenqash;


import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.tinnovat.app.binmenqash.authentication.LoginActivity;

import java.net.InetAddress;
import java.util.Locale;
import java.util.Objects;

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

   // private AppPreferanceStore appPreferenceStore;
    private Dialog progressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getActionBar() != null)
            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        /*appPreferenceStore = new AppPreferanceStore(getApplicationContext());
        appPreferenceStore.changeLocaleLanguage(appPreferenceStore.getLanguage());*/

        initialiseViews();
        initialiseEventListners();

       /* appPreferenceStore = new AppPreferanceStore(this);
        appPreferenceStore.changeLocaleLanguage(appPreferenceStore.getLanguage());
        progressDialog = new Dialog(Objects.requireNonNull(this));
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

    public abstract void initialiseViews();

    public abstract void initialiseEventListners();




    public void showMessage( String message) {
      /*  Snackbar mySnackbar = Snackbar.make(view,
                message, Snackbar.LENGTH_SHORT);
        mySnackbar.show();*/
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void showMessageSnakBar(View view, String message) {
        Snackbar mySnackbar = Snackbar.make(view,
                message, Snackbar.LENGTH_SHORT);
        mySnackbar.show();
//        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        /*if (id == R.id.home) {
            fetchHome();
        } else if (id == R.id.events) {
            fetchEvents();

        } else if (id == R.id.services) {
            fetchServices();
        } else if (id == R.id.guest_registration) {
            fetchGuestRegistration();

        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


   /* public void fetchHome() {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }


    public void fetchEvents() {
        Intent i = new Intent(getApplicationContext(), EventNewsActivity.class);
        startActivity(i);
    }*/




    public boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }

    public void showErrorDilog(final boolean needToFinish){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage(getResources().getString(R.string.no_internet));
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        if (needToFinish){
                            finish();
                        }
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }
}
