package com.example.androidapp.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.androidapp.Controller.MainController;
import com.example.androidapp.Injection;
import com.example.androidapp.Model.Menus;
import com.example.androidapp.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private MainController controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new MainController(this, Injection.getRestApi());
        controller.onCreate();
    }

    public void showList(List<Menus> menusList) {
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new MyAdapter(menusList, this);
        recyclerView.setAdapter(mAdapter);
    }
}
