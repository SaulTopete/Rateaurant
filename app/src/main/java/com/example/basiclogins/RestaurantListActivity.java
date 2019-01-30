package com.example.basiclogins;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import java.lang.reflect.Array;
import java.util.List;

public class RestaurantListActivity extends AppCompatActivity {

    private ListView listViewRestaurant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);

        wireWidgets();
        populateListView();
    }

    private void populateListView() {
        Backendless.Data.of(Restaurant.class).find(new AsyncCallback<List<Restaurant>>() {
            @Override
            public void handleResponse(List<Restaurant> restaurantList) {
                //all Restaurant instances have been found
                RestaurantAdapter adapter = new RestaurantAdapter(
                        RestaurantListActivity.this,
                        R.layout.item_restaurantlist,
                        restaurantList);
                listViewRestaurant.setAdapter(adapter);
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                //an error has occurred, error code can be retrieved with fault.g...
                Toast.makeText(RestaurantListActivity.this, fault.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void wireWidgets() {
        listViewRestaurant = findViewById(R.id.listview_restaurantlist);
    }
}
