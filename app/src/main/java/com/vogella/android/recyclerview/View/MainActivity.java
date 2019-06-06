package com.vogella.android.recyclerview.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.vogella.android.recyclerview.Injection;
import com.example.androidapp.R;
import com.vogella.android.recyclerview.Controller.MainController;
import com.vogella.android.recyclerview.Model.Menus;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private MainController controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new MainController(this, Injection.getRestApi());
        controller.onCreate();
    }

    public void showList(List<Menus> MenusList) {
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        myAdapter = new MyAdapter(MenusList, this);
        recyclerView.setAdapter(myAdapter);
    }
}
