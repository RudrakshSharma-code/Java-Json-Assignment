package com.example.comp3717assignment1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BasePlayer {
    @SerializedName("roster")
    @Expose
    private ArrayList<Player> roster = new ArrayList<>();

    public ArrayList<Player> getPlayers() {
        return roster;
    }

    public void setPlayer(ArrayList<Player> players) {
        this.roster = players;
    }
}
