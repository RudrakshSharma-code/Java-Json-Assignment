package com.example.Maeschalck_Sharma.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.Maeschalck_Sharma.Objects.Details;
import com.example.Maeschalck_Sharma.R;

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
        TextView pos = convertView.findViewById(R.id.position);
        TextView currentTeam = convertView.findViewById(R.id.currentTeam);


        // Populate the data into the template view using the data object
        nameDetail.setText(String.format("%s", details.getFullName()));
        currentTeam.setText(String.format("%s", details.getCurrentTeam().getName()));
        age.setText(String.format("%s", details.getCurrentAge()));
        country.setText(String.format("%s", details.getBirthCountry()));
        pos.setText(String.format("%s", details.getPrimaryPosition().getName()));

        return convertView;
    }
}
