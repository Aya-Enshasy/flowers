package com.example.fragmentactivity;

import android.annotation.SuppressLint;
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

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyHolder> {
    Context context;
    ArrayList<CartModel> cartModels ;

    public ArrayList<CartModel> getCartModels() {
        return cartModels;
    }

    public void setCartModels(ArrayList<CartModel> cartModels) {
        this.cartModels = cartModels;
        notifyDataSetChanged();
    }

        public CartAdapter(Context context    ) {
        this.context = context;

    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item,parent,false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, @SuppressLint("RecyclerView") int position) {
        Glide.with(context).load(cartModels.get(position).getImage()).placeholder(R.drawable.ic_launcher_foreground).into(holder.im);
        holder.name.setText(cartModels.get(position).getName());
        holder.price.setText(cartModels.get(position).getPrice());

            }




    @Override
    public int getItemCount() {
        return cartModels != null ? cartModels.size() : 0;
    }

    class MyHolder extends RecyclerView.ViewHolder{

        ImageView im;
        TextView price, name;


        public MyHolder(@NonNull View itemView) {
            super(itemView);
            im = itemView.findViewById(R.id.image_purchase);
            price = itemView.findViewById(R.id.name_product);
            name = itemView.findViewById(R.id.price_total_product);

        }

    }





}
