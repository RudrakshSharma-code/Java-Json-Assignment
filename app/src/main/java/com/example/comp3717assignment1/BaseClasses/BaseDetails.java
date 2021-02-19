package com.example.comp3717assignment1.BaseClasses;

import com.example.comp3717assignment1.Objects.Details;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BaseDetails {
    @SerializedName("people")
    @Expose
    private ArrayList<Details> details = new ArrayList<>();

    public ArrayList<Details> getDetails() {
        return details;
    }

    public void setDetails(ArrayList<Details> details) {
        this.details = details;
    }
}
