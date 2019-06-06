package com.example.androidapp.Model;

import java.util.List;

public class RestMenusResponse {
    private int count;
    private int earliest_menu;
    private int latest_menu;
    private int to_transcribe;
    private int under_review;
    private int complete;

    private List<Menus> results;

    public int getCount() {return count;}
    public int getEarliest_menu() {return earliest_menu;}
    public int getLatest_menu() {return latest_menu;}
    public int getTo_transcribe() {return to_transcribe;}
    public int getUnder_review() {return under_review;}
    public int getComplete() {return complete;}
    public List<Menus> getResults() {
        return results;
    }
}
