package com.example.comp3717assignment1.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.comp3717assignment1.Adapters.TeamsAdapter;
import com.example.comp3717assignment1.BaseClasses.BaseTeam;
import com.example.comp3717assignment1.HttpHandler;
import com.example.comp3717assignment1.R;
import com.example.comp3717assignment1.Objects.Team;
import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();
    private ListView lv;

    //URL for teams
    private static String TEAMS_URL = "https://statsapi.web.nhl.com/api/v1/teams/";
    private ArrayList<Team> teamList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new GetContacts().execute();

        teamList = new ArrayList<Team>();
        lv = findViewById(R.id.TeamList);
        //Log.e(TAG, "TEAM CHOICE: " + lv);
        new GetContacts().execute();

        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#FF000000"));

        actionBar.setBackgroundDrawable(colorDrawable);

        lv.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intent = new Intent(this, PlayerViewActivity.class);
            intent.putExtra("choice", i);
            Log.e(TAG, "TEAM CHOICE: " + i);
            startActivity(intent);
        });
    }

    private class GetContacts extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            String jsonStr = null;

            jsonStr = sh.makeServiceCall(TEAMS_URL);

            if (jsonStr != null) {
                Gson gson = new Gson();
                BaseTeam baseTeam = gson.fromJson(jsonStr, BaseTeam.class);
                teamList = baseTeam.getTeams();
                // Test if able to retrieve team name and link from teamList.
                Log.e(TAG, "TEAM NAME: " + teamList.get(0).getName() + " TEAM LINK: " + teamList.get(0).getLink());
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(() -> Toast.makeText(getApplicationContext(),
                        "Couldn't get json from server. Check LogCat for possible errors!",
                        Toast.LENGTH_LONG)
                        .show());
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            TeamsAdapter adapter = new TeamsAdapter(MainActivity.this, teamList);

            // Attach the adapter to a ListViews
            lv.setAdapter(adapter);
        }
    }

}