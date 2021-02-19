package com.example.Maeschalck_Sharma.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.Maeschalck_Sharma.R;
import com.example.Maeschalck_Sharma.Objects.Team;

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
        TextView abbreviation = convertView.findViewById(R.id.abbreviation);
        TextView url = convertView.findViewById(R.id.url);

        // Populate the data into the template view using the data object
        teamName.setText(String.format(" %s", team.getName()));
        abbreviation.setText(String.format(" %s", team.getAbbreviation()));
        url.setText(String.format(" %s", team.getOfficialSiteUrl()));

        return convertView;
    }
}
