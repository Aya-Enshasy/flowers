package com.example.fragmentactivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    DatabaseReference databaseReference;
    ArrayList<Flower> flower;
    ArrayList<Plant> plant;
    TextView flower_all,plant_all ;
    FlowersAdapter adapter;
    PlantImageAdapter adapter1;


    ImageView imageViewA;
    public static final String Item_KEY = "churches_key";
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_home, container, false);
        flower = new ArrayList<>();
        RecyclerView recyclerview = view.findViewById(R.id.recycleview_home);

//        flower_all = view.findViewById(R.id.seeall_flowers);
//        flower_all.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getContext(),SeeAllActivity.class);
//                startActivity(intent);
//            }
//        });

//        flower = new ArrayList<>();
//        flower.add(new Flower("https://images.pexels.com/photos/736230/pexels-photo-736230.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500","text"));
//        flower.add(new Flower("https://images.pexels.com/photos/736230/pexels-photo-736230.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500","text"));
//        flower.add(new Flower("https://images.pexels.com/photos/736230/pexels-photo-736230.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500","text"));
//        flower.add(new Flower("https://images.pexels.com/photos/736230/pexels-photo-736230.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500","text"));
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);
        recyclerview.setLayoutManager(layoutManager);
        databaseReference = FirebaseDatabase.getInstance().getReference("flowers");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()) {
                    if (databaseReference.hashCode()==1){

                    }
                    Flower ff = dataSnapshot.getValue(Flower.class);
                    flower.add(ff);
                }
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(),"nodata", Toast.LENGTH_LONG).show();
                Log.e("error","error");
            }
        });
        adapter = new FlowersAdapter(getActivity(), flower, new TypeProjectInterface() {
            @Override
            public void onItemClick(int Id) {
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                intent.putExtra(Item_KEY, Id);
                startActivity(intent);

            }
        });
        recyclerview.setAdapter(adapter);






        plant = new ArrayList<>();
        RecyclerView recyclerview2 = view.findViewById(R.id.recycleview_plant);



        LinearLayoutManager  layoutManager1 = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        recyclerview2.setLayoutManager(layoutManager1);
        databaseReference = FirebaseDatabase.getInstance().getReference("plant");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()) {
                    if (databaseReference.hashCode()==1){

                    }
                    Plant pp = dataSnapshot.getValue(Plant.class);
                    plant.add(pp);
                }
                adapter1.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(),"nodata", Toast.LENGTH_LONG).show();
                Log.e("error","error");
            }
        });
        adapter1 = new PlantImageAdapter(getActivity(), plant, new TypeProjectInterface() {
            @Override
            public void onItemClick(int Id) {
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                intent.putExtra(Item_KEY, Id);
                startActivity(intent);

            }
        });
        recyclerview2.setAdapter(adapter1);









        //image intent














//        flower = new ArrayList<>();
        //plant = new ArrayList<>();

//        flower.add(new Flower("https://images.pexels.com/photos/736230/pexels-photo-736230.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500","text"));
//        flower.add(new Flower("https://images.pexels.com/photos/736230/pexels-photo-736230.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500","text"));
//        flower.add(new Flower("https://images.pexels.com/photos/736230/pexels-photo-736230.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500","text"));
//        flower.add(new Flower("https://images.pexels.com/photos/736230/pexels-photo-736230.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500","text"));
//


//        plant.add(new Plant("https://images.pexels.com/photos/736230/pexels-photo-736230.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"));
//        plant.add(new Plant("https://images.pexels.com/photos/736230/pexels-photo-736230.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"));
//        plant.add(new Plant("https://images.pexels.com/photos/736230/pexels-photo-736230.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"));
//        plant.add(new Plant("https://images.pexels.com/photos/736230/pexels-photo-736230.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"));
//        plant.add(new Plant("https://images.pexels.com/photos/736230/pexels-photo-736230.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"));


//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);
//        recyclerview.setLayoutManager(layoutManager);
//        ImageAdapter imageAdapter = new ImageAdapter(getActivity(),flower);
//        recyclerview.setAdapter(imageAdapter);


//       LinearLayoutManager  layoutManager1 = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);
//        recyclerview2.setLayoutManager(layoutManager1);
//
//        PlantImageAdapter plantImageAdapter = new PlantImageAdapter(getActivity(),plant);
//        recyclerview2.setAdapter(plantImageAdapter);
        return view ;
    }


}