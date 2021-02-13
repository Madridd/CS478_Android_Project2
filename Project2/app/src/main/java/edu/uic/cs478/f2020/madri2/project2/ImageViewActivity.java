package edu.uic.cs478.f2020.madri2.project2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;

public class ImageViewActivity extends Activity {
    private int position;
    //private String web;
    private ArrayList<String> websites = new ArrayList<String>(
            Arrays.asList("https://www.ford.com/suvs/bronco-sport/2021/?gnav=header-all-vehicles",
                    "https://www.ford.com/suvs-crossovers/ecosport/?gnav=header-all-vehicles",
                    "https://www.ford.com/suvs/bronco/2021/?gnav=header-all-vehicles",
                    "https://www.ford.com/suvs-crossovers/edge/?gnav=header-all-vehicles",
                    "https://www.ford.com/suvs-crossovers/escape/?gnav=header-all-vehicles",
                    "https://www.ford.com/suvs/explorer/?gnav=header-all-vehicles"));



    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // Get the Intent used to start this Activity
        Intent intent = getIntent();

        // Make a new ImageView
        // Example of programmatic layout definition
        final ImageView imageView = new ImageView(getApplicationContext());

        position = getIntent().getIntExtra("website",0);

        // Get the ID of the image to display and set it as the image for this ImageView
        imageView.setImageResource(intent.getIntExtra(MainActivity.EXTRA_RES_ID, 0));

        setContentView(imageView);




        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Uri uri = Uri.parse("https://www.ford.com/?gnav=header-all-vehicles");
                Uri uri = Uri.parse(websites.get(position));
                //Uri uri = Uri.parse(web);


                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }

}


//imageView.setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View view) {
//
//        Uri uri = Uri.parse(websites.get(2));
//
//        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//        startActivity(intent);
//        }
//        });