package com.example.comp3717assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();
    private ListView lv;

    //URL for teams
    private static String TEAMS_URL = "https://statsapi.web.nhl.com/api/v1/teams";
    private ArrayList<Team> teamList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new GetContacts().execute();
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
            Log.e(TAG, "Response from URL: " + jsonStr);

            if (jsonStr != null) {
                Log.d(TAG, "Json: " + jsonStr);
                // this step is needed to wrap the JSON array inside
                jsonStr = "{\"Teams\":" + jsonStr + "}";
                //Gson gson = new Gson();
                //BaseToon baseToon = gson.fromJson(jsonStr, BaseToon.class);
                //toonList = baseToon.getToons();
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });
            }

            return null;
        }
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            //ToonsAdapter adapter = new ToonsAdapter(MainActivity.this, toonList);

            // Attach the adapter to a ListView
            //lv.setAdapter(adapter);
        }
    }

}