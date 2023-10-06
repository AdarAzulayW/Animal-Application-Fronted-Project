package com.example.ourfinalapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ourfinalapp.Model.Animal;
import com.example.ourfinalapp.R;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.MyViewHolder> {

    Animal [] dataset;
    public AnimalAdapter(Animal [] dataset) {
        this.dataset = dataset;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listItem = inflater.inflate(R.layout.item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(listItem);
        return viewHolder;
    }

    //
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Animal myListData = this.dataset[position];
        holder.textname.setText(this.dataset[position].getName());
        holder.discovertext.setText(this.dataset[position].getDescription());
        holder.image.setImageResource(this.dataset[position].getImage());

    }

    @Override
    public int getItemCount() {
        return dataset.length;
    }

    //to take out the items from the recycle view -- inner class
    public static class MyViewHolder extends RecyclerView.ViewHolder {


        TextView textname;
        TextView discovertext;
        ImageView image;



        // the param in the items
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textname = itemView.findViewById(R.id.animal_name);
            discovertext = itemView.findViewById(R.id.discovertext);
            image = itemView.findViewById(R.id.imageView);
        }

    }






}
