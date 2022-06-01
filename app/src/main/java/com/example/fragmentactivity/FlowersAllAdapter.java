package com.example.fragmentactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class FlowersAllAdapter extends RecyclerView.Adapter<FlowersAllAdapter.MyHolder> {
    Context context;
    ArrayList<FlowersAll> flowersAll ;

    public FlowersAllAdapter(Context context , ArrayList<FlowersAll> flowersAll ) {
       this.flowersAll = flowersAll;
        this.context = context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.flowers_all_item,parent,false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Glide.with(context).load(flowersAll.get(position).getImage()).placeholder(R.drawable.ic_launcher_foreground).into(holder.im);
        holder.textView.setText(flowersAll.get(position).getName_flowers());





    }

    @Override
    public int getItemCount() {
        return flowersAll.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        ImageView im;
        TextView textView;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            im = itemView.findViewById(R.id.rose);
            textView = itemView.findViewById(R.id.acicularis);
        }

    }





}
