package com.example.comp3717assignment1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TeamsAdapter extends ArrayAdapter<Team> {
    Context _context;

    public TeamsAdapter(Context context, ArrayList<Team> teams) {
        super(context, 0, teams);
        _context = context;
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent) {
        final Activity activity = (Activity) _context;
        Team team = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_row_layout, parent, false);
        }
        TextView teamName = convertView.findViewById(R.id.teamName);
        TextView link = convertView.findViewById(R.id.link);
        TextView ids = convertView.findViewById(R.id.ids);

        // Populate the data into the template view using the data object
        teamName.setText(String.format(" %s", team.getName()));
        link.setText(team.getLink());

        return convertView;
    }
}
