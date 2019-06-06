package com.example.androidapp.Model;
import com.google.gson.annotations.SerializedName;

public class Menus {
    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("sponsor")
    private String sponsor;

    @SerializedName("venue")
    private String venue;

    @SerializedName("event")
    private String event;

    @SerializedName("place")
    private String place;

    @SerializedName("occasion")
    private String occasion;


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSponsor(){return sponsor;}

    public String getVenue() {
        return venue;
    }

    public String getEvent() {
        return event;
    }

    public String getPlace() {
        return place;
    }

    public String getOccasion() {
        return occasion;
    }
}
