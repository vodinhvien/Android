package com.example.locationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {


    public Button btnWebsite;
    public Button btnMap;
    public EditText edtLocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMap = (Button) findViewById(R.id.btnMap);
        btnWebsite = (Button) findViewById(R.id.btnWeb);

        edtLocation = (EditText) findViewById(R.id.eLocation);

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findOnGoogleMap();
            }
        });

        btnWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findOnWebsite();
            }
        });

    }

    public void findOnGoogleMap() {

        String txt = edtLocation.getText().toString();

        Uri uriGoogleMap = Uri.parse("geo:0,0?q=" + txt);
        Intent intentGoogleMap = new Intent(Intent.ACTION_VIEW, uriGoogleMap);
        intentGoogleMap.setPackage("com.google.android.apps.maps");
        startActivity(intentGoogleMap);
    }

    public void findOnWebsite() {
        String txt = edtLocation.getText().toString();


        Intent intentGoogleSearch = new Intent(Intent.ACTION_WEB_SEARCH);
        intentGoogleSearch.putExtra(SearchManager.QUERY, txt);
        startActivity(intentGoogleSearch);

    }
}