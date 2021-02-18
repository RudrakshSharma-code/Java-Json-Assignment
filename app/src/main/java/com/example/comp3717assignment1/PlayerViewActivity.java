package com.example.comp3717assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

public class PlayerViewActivity extends AppCompatActivity {

    private ListView list;
    public static int choiceIndex;
    private ArrayList<Player> playerList;

    private String TAG = PlayerViewActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_view);
        new GetContacts().execute();

        playerList = new ArrayList<Player>();
        list = findViewById(R.id.PlayerList);
        new GetContacts().execute();

        list.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intent = new Intent(this, FinalScreenActivity.class);
            intent.putExtra("choice", i);

            startActivity(intent);
        });

        int teamIndex = (Integer) getIntent().getExtras().get("choice");
        choiceIndex = teamIndex;
        Log.e(TAG, "Inherited choice: " + choiceIndex);
    }

    public static String retrieveUrl(int index) {
        String retrieveUrl;
        index = index + 1;
        retrieveUrl = ("https://statsapi.web.nhl.com/api/v1/teams/" + index + "/roster");
        return retrieveUrl;
    }

    private static String PLAYER_URL;

    private class GetContacts extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            String jsonStr = null;

            PLAYER_URL = retrieveUrl(choiceIndex);
            jsonStr = sh.makeServiceCall(PLAYER_URL);

            if (jsonStr != null) {
                PLAYER_URL = retrieveUrl(choiceIndex);
                jsonStr = sh.makeServiceCall(PLAYER_URL);
                Log.e(TAG, "Retrieved roster: " + jsonStr);

                Gson gson = new Gson();
                BasePlayer basePlayer = gson.fromJson(jsonStr, BasePlayer.class);

                playerList = basePlayer.getPlayers();

                //step should return full name
                Log.e(TAG, "Player name: " + playerList.get(0).getFullName());
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
            PlayerAdapter adapter = new PlayerAdapter(PlayerViewActivity.this, playerList);
            // Attach the adapter to a ListView
            list.setAdapter(adapter);
        }
    }

}