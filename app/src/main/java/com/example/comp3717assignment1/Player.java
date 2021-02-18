package com.example.comp3717assignment1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Player {

    @SerializedName("fullName")
    @Expose
    private String fullName;
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

//    @SerializedName("jerseyNumber")
//    @Expose
//    private int jerseyNumber;
//    public int getJerseyNumber() { return jerseyNumber; }
//    public void setJerseyNumber(int jerseyNumber) {
//        this.jerseyNumber = jerseyNumber;
//    }

//    @SerializedName("position")
//    @Expose
//    private String position;
//    public String getPosition() {
//        return position;
//    }
//    public void setPosition(String position) {
//        this.position = position;
//    }

    @SerializedName("id")
    @Expose
    private int id;
    public int getId() {
        return id;
    }
    public void setId(int url) {
        this.id = url;
    }
}
