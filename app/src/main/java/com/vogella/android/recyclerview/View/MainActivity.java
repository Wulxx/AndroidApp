package com.vogella.android.recyclerview.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.androidapp.R;
import com.vogella.android.recyclerview.Controller.MainController;
import com.vogella.android.recyclerview.Injection;
import com.vogella.android.recyclerview.Model.Menus;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private MainController control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        control = new MainController(this, Injection.getRestApi());
        control.onCreate();
    }

    public void showList(List<Menus> MenusList) {
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new MyAdapter(MenusList, this);
        recyclerView.setAdapter(mAdapter);
    }
}

