package com.example.fragmentactivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class FlowersAdapter extends RecyclerView.Adapter<FlowersAdapter.MyHolder> {
    Context context;
    ArrayList<Flower> flowers ;
   TypeProjectInterface typeprojectinterface;
    public static final String Item_KEY = "flower_key";

    public FlowersAdapter(Context context , ArrayList<Flower> flowers , TypeProjectInterface typeprojectinterface  ) {
        this.typeprojectinterface = typeprojectinterface;
       this.flowers = flowers;
        this.context = context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.flowers_item,parent,false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, @SuppressLint("RecyclerView") int position) {
        Glide.with(context).load(flowers.get(position).getImage()).placeholder(R.drawable.ic_launcher_foreground).into(holder.im);
        holder.textView.setText(flowers.get(position).getName());
        holder.price.setText(flowers.get(position).getPrice());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), DetailsActivity.class);
                intent.putExtra("name", flowers.get(position).getName());
                intent.putExtra("price", flowers.get(position).getPrice());
                intent.putExtra("details", flowers.get(position).getDetails());
                intent.putExtra("image", flowers.get(position).getImage());



                v.getContext().startActivity(intent);
            }
        });




    }

    @Override
    public int getItemCount() {
        return flowers.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        Flower product;
        ImageView im;
        TextView textView,price;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            im = itemView.findViewById(R.id.imageViewA);
            textView = itemView.findViewById(R.id.textView);
            price = itemView.findViewById(R.id.price);
        }

    }





}
