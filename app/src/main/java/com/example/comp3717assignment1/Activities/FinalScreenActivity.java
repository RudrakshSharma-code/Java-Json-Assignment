package com.example.comp3717assignment1.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.comp3717assignment1.Adapters.DetailsAdapter;
import com.example.comp3717assignment1.BaseClasses.BaseDetails;
import com.example.comp3717assignment1.Objects.Details;
import com.example.comp3717assignment1.HttpHandler;
import com.example.comp3717assignment1.R;
import com.google.gson.Gson;

import java.util.ArrayList;

public class FinalScreenActivity extends AppCompatActivity {

    private static int choiceIndex;
    private String TAG = FinalScreenActivity.class.getSimpleName();
    private ArrayList<Details> detailsList;
    private ListView lastLV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_screen);
        new GetContacts().execute();

        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#FF000000"));

        actionBar.setBackgroundDrawable(colorDrawable);

        detailsList = new ArrayList<Details>();
        lastLV = findViewById(R.id.DetailsList);
        Log.e(TAG, "TEAM CHOICE: " + lastLV);
        new GetContacts().execute();

        int playerIndex = (Integer) getIntent().getExtras().get("choice");
        Log.e(TAG, "TEAM CHOICE: " + playerIndex);
        choiceIndex = playerIndex;
    }

    private static String FINAL_URL;

    private class GetContacts extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            String jsonStr = null;
            FINAL_URL = ("https://statsapi.web.nhl.com/api/v1/people/" + choiceIndex);
            jsonStr = sh.makeServiceCall(FINAL_URL);

            if (jsonStr != null) {
                FINAL_URL = ("https://statsapi.web.nhl.com/api/v1/people/" + choiceIndex);
                jsonStr = sh.makeServiceCall(FINAL_URL);

                Gson gson = new Gson();
                BaseDetails baseDetails = gson.fromJson(jsonStr, BaseDetails.class);

                detailsList = baseDetails.getDetails();

                //step should return first players full name
                Log.e(TAG, "Player name: " + detailsList.get(0).getFullName());
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
            DetailsAdapter details = new DetailsAdapter(FinalScreenActivity.this, detailsList);
            // Attach the adapter to a ListView
            lastLV.setAdapter(details);
        }
    }
}