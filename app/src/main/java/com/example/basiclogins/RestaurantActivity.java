package com.example.basiclogins;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class RestaurantActivity extends AppCompatActivity {

    private EditText restaurantName;
    private EditText restaurantwebsite;
    private EditText restaurantAddress;
    private EditText restaurantCuisine;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
    }

    private void prefillFields() {
        //check if there's a Restaurant in the Intent
        //if s, fi;; all the fields with the restaurant
        Intent restaurantIntent = getIntent();
            Restaurant restaurant = restaurantIntent.getParcelableExtra(RestaurantListActivity.EXTRA_RESTAURANT);
        if(restaurant != null) {
            editTextName.setText(restaurant.getName());
            editTextWebsite.setText(restaurant.getWebsiteLink());
            editTextAddress.setText(restaurant.getAddress());
            editTextCuisine.setText(restaurant.getCuisine());
            ratingBarRating.setRating((float) restaurant.getRating());
            spinnerPrice.setSelection(restaurant.getPrice() - 1); //offset for 0 indexing

        }
    }
}
