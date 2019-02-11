package com.example.basiclogins;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;

public class RestaurantActivity extends AppCompatActivity {

    private EditText restaurantName;
    private EditText restaurantWebsite;
    private EditText restaurantAddress;
    private EditText restaurantCuisine;
    private RatingBar restaurantRating;
    private Spinner restaurantSpinnerPrice;
    private Button save;
    private Button cancel;

    public static final String EXTRA_RESTAURANT = "the restaurant";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        wireWidgets();

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void wireWidgets() {
        restaurantName = findViewById(R.id.edittext_activityrestaurant_name);
        restaurantWebsite = findViewById(R.id.edittext_activityrestaurant_website);
        restaurantAddress = findViewById(R.id.edittext_activityrestaurant_address);
        restaurantCuisine = findViewById(R.id.edittext_activityrestaurant_cuisine);
        restaurantRating = findViewById(R.id.ratingbar_activityrestaurant_rating);
        restaurantSpinnerPrice = findViewById(R.id.spinner_activityrestaurant_spinny);
        save = findViewById(R.id.button_activityrestaurant_save);
        cancel = findViewById(R.id.button_activityrestaurant_cancel);
    }

    private void prefillFields() {
        //check if there's a Restaurant in the Intent
        //if s, fi;; all the fields with the restaurant
        Intent restaurantIntent = getIntent();
            Restaurant restaurant = restaurantIntent.getParcelableExtra(RestaurantListActivity.EXTRA_RESTAURANT);
        if(restaurant != null) {
            restaurantName.setText(restaurant.getName());
            restaurantWebsite.setText(restaurant.getWebsiteLink());
            restaurantAddress.setText(restaurant.getAddress());
            restaurantCuisine.setText(restaurant.getCuisine());
            restaurantRating.setRating((float) restaurant.getRating());
            restaurantSpinnerPrice.setSelection(restaurant.getPrice() - 1); //offset for 0 indexing
        }
    }
}
