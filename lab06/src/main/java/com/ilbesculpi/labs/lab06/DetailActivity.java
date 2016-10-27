package com.ilbesculpi.labs.lab06;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ilbesculpi.labs.lab06.models.Food;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    Food food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.food_detail);

        // retrieve food from extra
        food = (Food) getIntent().getSerializableExtra("food");

        // configure app bar
        configureAppBar();

        // display content
        displayContent(food);
    }

    private void configureAppBar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(food.getName());
    }

    private void displayContent(Food food) {
        TextView labelName = (TextView) findViewById(R.id.label_name);
        labelName.setText( food.getName() );
        TextView labelType = (TextView) findViewById(R.id.label_type);
        labelType.setText( food.getType().getName() );
        ImageView image = (ImageView) findViewById(R.id.imageView);
        Picasso.with(this)
                .load(food.getPicture())
                .placeholder(R.drawable.placeholder)
                .into(image);
        //image.setImageResource(R.drawable.pizza);
        View viewType = findViewById(R.id.view_type);
        viewType.setBackgroundColor(Color.parseColor(food.getType().getBackground()));
    }

}
