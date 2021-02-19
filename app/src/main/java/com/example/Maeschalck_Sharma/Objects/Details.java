package com.example.Maeschalck_Sharma.Objects;

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

    @SerializedName("currentTeam")
    @Expose
    private CurrentTeam currentTeam;
    public CurrentTeam getCurrentTeam() {
        return currentTeam;
    }
    public void setCurrentTeam(CurrentTeam currentTeam) {
        this.currentTeam = currentTeam;
    }

    @SerializedName("primaryPosition")
    @Expose
    private PrimaryPosition primaryPosition;
    public PrimaryPosition getPrimaryPosition() {
        return primaryPosition;
    }
    public void setPrimaryPosition(PrimaryPosition primaryPosition) {
        this.primaryPosition = primaryPosition;
    }

}
