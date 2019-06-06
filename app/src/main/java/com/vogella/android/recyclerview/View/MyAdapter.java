package com.vogella.android.recyclerview.View;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.androidapp.R;
import com.vogella.android.recyclerview.Model.Menus;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Menus> values;
    private MainActivity mainActivity;
    private int pos;

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtHeader;
        public TextView txtFooter;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
        }
    }

    /*public void add(int position, Menus item) {
        values.add(position, item);
        notifyItemInserted(position);
    }*/

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    public MyAdapter(List<Menus> values) {
        this.values = values;
    }
    private static String SelectedMenus = "selected_menus";
    public void infoDisplay(int pos){
        Log.d("position", String.valueOf(pos));
        Intent info = new Intent(mainActivity, SecondActivity.class);
        final Menus selectedMenus = values.get(pos);
        ArrayList<String> Menus= new ArrayList<>() ;
        Menus.add(selectedMenus.getName());
        Menus.add(selectedMenus.getSponsor());
        Menus.add(selectedMenus.getVenue());
        Menus.add(selectedMenus.getEvent());
        Menus.add(selectedMenus.getPlace());
        Menus.add(selectedMenus.getOccasion());
        info.putStringArrayListExtra(SelectedMenus,Menus);
        mainActivity.startActivity(info);
    }

    public MyAdapter(List<Menus> values, MainActivity mainActivity) {
        this.values = values;
        this.mainActivity = mainActivity;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int pos) {
        this.pos = pos;
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Menus selectedMenus = values.get(pos);
        holder.txtHeader.setText(selectedMenus.getName());

        holder.txtFooter.setText("URL : " + selectedMenus.getId());
        Log.d("URL", String.valueOf(pos));

        holder.layout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                infoDisplay(pos);
            }
        });
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

}
