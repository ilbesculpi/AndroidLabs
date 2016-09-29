package com.ilbesculpi.labs.lab05.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ilbesculpi.labs.lab05.R;
import com.ilbesculpi.labs.lab05.models.Food;

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
        labelType.setText( food.getType().toString() );
        TextView labelPrice = (TextView) convertView.findViewById(R.id.label_price);
        labelPrice.setText( food.getPrice() + "Bs" );

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
