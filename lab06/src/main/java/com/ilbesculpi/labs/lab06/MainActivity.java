package com.ilbesculpi.labs.lab06;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Toast;

import com.ilbesculpi.labs.lab06.adapters.FoodListAdapter;
import com.ilbesculpi.labs.lab06.http.HttpConnect;
import com.ilbesculpi.labs.lab06.models.Food;
import com.ilbesculpi.labs.lab06.models.FoodType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    AbsListView listView;
    FoodListAdapter adapter;
    SwipeRefreshLayout refreshControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set content
        setContentView(R.layout.activity_main);

        // configure app bar
        configureAppBar();

        // set view references
        final List<Food> foods = new ArrayList<>();
        listView = (AbsListView) findViewById(R.id.listView);
        configureListView(foods);
        refreshControl = (SwipeRefreshLayout) findViewById(R.id.refresh);
        configureRefreshControl();

        // fetch server data
        fetchServerData();
    }

    private void configureAppBar() {
        getSupportActionBar()
                .setTitle(R.string.home_title);
    }

    private void configureListView(List<Food> foods) {
        adapter = new FoodListAdapter(this, 0, foods);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Food food = adapter.getItem(i);
                Toast.makeText(MainActivity.this, "Item clicked: " + food.toString(), Toast.LENGTH_SHORT)
                        .show();
                // start detail activity with food item
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("food", food);
                startActivity(intent);
            }
        });
    }

    private void configureRefreshControl() {
        refreshControl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Log.d("Lab06", "refresh()");
                fetchNewItems();
            }
        });
    }

    private void fetchServerData() {
        new FetchFoodTask()
                .execute("http://androidlabs.miro.beecloud.me/api/food.json");
    }

    private void fetchNewItems() {
        new FetchFoodTask()
                .execute("http://androidlabs.miro.beecloud.me/api/food_new.json");
    }

    private class FetchFoodTask extends AsyncTask<String, Void, JSONObject> {

        @Override
        protected JSONObject doInBackground(String... urls) {
            Log.d("Lab06", "fetch url " + urls[0]);
            return HttpConnect.getJSON(urls[0]);
        }

        @Override
        protected void onPostExecute(JSONObject result) {

            if( result != null ) {

                try {
                    JSONArray list = result.getJSONArray("list");
                    for( int i = 0; i < list.length(); i++ ) {
                        JSONObject item = list.getJSONObject(i);
                        Food food = new Food();
                        food.setId(item.getInt("id"));
                        food.setName(item.getString("name"));
                        food.setPicture(item.getString("picture_url"));
                        food.setPrice( (float) item.getDouble("price") );
                        food.setFeatured( item.getBoolean("featured") );
                        FoodType type = new FoodType();
                        type.setName( item.getJSONObject("type").getString("name") );
                        type.setColor( item.getJSONObject("type").getString("color") );
                        food.setType(type);
                        // append to the adapter list
                        adapter.add(food);
                    }
                    // refresh adapter
                    adapter.notifyDataSetChanged();;
                    Log.d("Lab06", "download complete: " + list.length() + " items received.");
                }
                catch(JSONException e) {
                    // do nothing?
                    Toast.makeText(getBaseContext(), "An error occurred fetching the list.", Toast.LENGTH_LONG)
                            .show();
                }

            }

            // refresh control...
            refreshControl.setRefreshing(false);
        }

    }

}
