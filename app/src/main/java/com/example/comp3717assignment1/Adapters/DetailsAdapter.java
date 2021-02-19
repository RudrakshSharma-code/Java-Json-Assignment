package com.example.comp3717assignment1.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.comp3717assignment1.Objects.Details;
import com.example.comp3717assignment1.R;

import java.util.ArrayList;

public class DetailsAdapter extends ArrayAdapter<Details> {
    Context _context;

    public DetailsAdapter(Context context, ArrayList<Details> details) {
        super(context, 0, details);
        _context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Activity activity = (Activity) _context;
        Details details = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.thirdlist_row_layout, parent, false);
        }
        TextView nameDetail = convertView.findViewById(R.id.nameDetail);
        TextView country = convertView.findViewById(R.id.country);
        TextView age = convertView.findViewById(R.id.age);

        // Populate the data into the template view using the data object
        nameDetail.setText(String.format("Name: %s", details.getFullName()));
        country.setText(String.format("Nationality: %s", details.getBirthCountry()));
        age.setText(String.format("Age: %s", details.getCurrentAge()));

        return convertView;
    }
}
