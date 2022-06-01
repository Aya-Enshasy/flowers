package com.example.fragmentactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               switch (item.getItemId()){
                   case R.id.house:
                       openFragment(HomeFragment.newInstance("",""));

                       break;
                   case R.id.cart:
                       openFragment(CartFragment.newInstance("",""));
                       break;
                   case R.id.user:
                       openFragment(AccountFragment.newInstance("",""));
                       break;

               }

                return true;
            }
        });
        openFragment(HomeFragment.newInstance("",""));


//
//        RecyclerView recyclerview = findViewById(R.id.recycleview_flowers);
//        ArrayList<String> products = new ArrayList<>();
//        products.add( "1");
//        products.add( "2");
//        products.add( "3");
//        products.add( "4");
//        products.add( "5");
//        products.add( "6");
//        products.add( "7");
//        products.add( "8");
//        products.add( "9");
//        products.add( "11");
//        products.add( "12");
//        products.add( "13");
//
//
//
//        RecyclerView.LayoutManager layoutManager =
//                new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
//        recyclerview.setLayoutManager(layoutManager);
//        ImageAdapter imageAdapter = new ImageAdapter(this,p);
//        recyclerview.setAdapter(imageAdapter);
    }












    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        //transaction.addToBackStack(null);
        transaction.commit();
    }
}