package com.ilbesculpi.labs.lab06.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ilbesculpi.labs.lab06.R;
import com.ilbesculpi.labs.lab06.models.Food;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FoodListAdapter extends ArrayAdapter<Food> {

    private List<Food> foods;

    public FoodListAdapter(Context context, int resource, List<Food> objects) {
        super(context, resource, objects);
        foods = objects;
    }

    @Override
    public int getCount() {
        return foods.size();
    }

    @Override
    public Food getItem(int position) {
        return foods.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Food food = getItem(position);

        // inflate view
        if( convertView == null ) {
            int resource = food.isFeatured() ? R.layout.list_item_food_featured : R.layout.list_item_food;
            convertView = getInflater().inflate(resource, null);
        }

        // customize view
        TextView labelName = (TextView) convertView.findViewById(R.id.label_name);
        labelName.setText( food.getName() );
        TextView labelType = (TextView) convertView.findViewById(R.id.label_type);
        labelType.setText( food.getType().getName() );
        TextView labelPrice = (TextView) convertView.findViewById(R.id.label_price);
        labelPrice.setText( food.getPrice() + "Bs" );
        ImageView imageView = (ImageView) convertView.findViewById(R.id.image);

        Picasso.with(getContext())
                .load( food.getPicture() )
                .placeholder( R.drawable.placeholder )
                .into( imageView );

        return convertView;
    }

    @Override
    public int getViewTypeCount() {
        return 2;   // default & featured
    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).isFeatured() ? 1 : 0;
    }

    private LayoutInflater getInflater() {
        return LayoutInflater.from(getContext());
    }

}
