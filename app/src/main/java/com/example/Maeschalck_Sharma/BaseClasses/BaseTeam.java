package com.example.Maeschalck_Sharma.BaseClasses;

import com.example.Maeschalck_Sharma.Objects.Team;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BaseTeam {
    @SerializedName("teams")
    @Expose
    private ArrayList<Team> teams = new ArrayList<>();

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }
}
