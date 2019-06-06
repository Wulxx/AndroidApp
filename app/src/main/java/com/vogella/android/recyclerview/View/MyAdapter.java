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
    private int position;

    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
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

    public void add(int position, Menus item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    private static final String SelectedMenus = "selected_menus";

    public void infoDisplay(int position){
        Log.d("position", String.valueOf(position));
        Intent info = new Intent(mainActivity, SecondActivity.class);
        final Menus selectedMenus = values.get(position);
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

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<Menus> values, MainActivity mainActivity) {
        this.values = values;
        this.mainActivity = mainActivity;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;

    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        this.position = position;
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Menus selectedMenus = values.get(position);
        holder.txtHeader.setText(selectedMenus.getName());

        holder.txtFooter.setText("URL : " + selectedMenus.getId());
        Log.d("URL", String.valueOf(position));

        holder.layout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                infoDisplay(position);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    public int getItemCount() {
        return values.size();
    }
}
