package com.example.Maeschalck_Sharma.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.Maeschalck_Sharma.Objects.Player;
import com.example.Maeschalck_Sharma.R;

import java.util.ArrayList;

public class PlayerAdapter extends ArrayAdapter<Player> {
    Context _context;

    public PlayerAdapter(Context context, ArrayList<Player> players) {
        super(context, 0, players);
        _context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Activity activity = (Activity) _context;
        Player player = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.secondlist_row_layout, parent, false);
        }
        TextView playerName = convertView.findViewById(R.id.playerName);
//        TextView jerseyNo = convertView.findViewById(R.id.jerseyNo);
//        TextView pos = convertView.findViewById(R.id.pos);

        // Populate the data into the template view using the data object
        playerName.setText(String.format("%s", player.getPerson().getFullName()));
//        jerseyNo.setText(player.getJersey());
//        pos.setText(player.getPosition());

        return convertView;
    }
}