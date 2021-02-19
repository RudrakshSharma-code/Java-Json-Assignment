package com.example.comp3717assignment1.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Details {

    @SerializedName("fullName")
    @Expose
    private String fullName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @SerializedName("birthCountry")
    @Expose
    private String birthCountry;

    public String getBirthCountry() {
        return birthCountry;
    }

    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }

//    @SerializedName("currentTeam")
//    @Expose
//    private CurrentTeam currentTeam;

    @SerializedName("currentAge")
    @Expose
    private Integer currentAge;

    public Integer getCurrentAge() {
        return currentAge;
    }

    public void setCurrentAge(Integer currentAge) {
        this.currentAge = currentAge;
    }
}
