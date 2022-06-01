package com.example.fragmentactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {
    TextView name1, price, totalprice, details,count;
    Button add,min, AddToCart;
    String name, price_st, totprice, details1, img;
    ImageView details_image;
    int sum=1;
    private int Item_Id =-1;
    //firbase
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseUser currentUser;
    FirebaseAuth mAuth;
    Bundle extras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        //
        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();

  ////
        add = findViewById(R.id.Item_details_add_btn);
        min = findViewById(R.id.Item_details_Min_btn);
        name1 = findViewById(R.id.name);
        price = findViewById(R.id.price);
        totalprice = findViewById(R.id.price2);
        details = findViewById(R.id.textView7);
        count = findViewById(R.id.textView8);
        details_image = findViewById(R.id.details_image);
        AddToCart = findViewById(R.id.add_cart);

        AddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddToCart.setEnabled(true);
                AddToCart();

            }
        });

        //-----------------------------------------------------------------------------
        name = name1.getText().toString();
        price_st = price.getText().toString();
        totprice = totalprice.getText().toString();
        details1 = details.getText().toString();

          Intent intent = getIntent();
        Item_Id = intent.getIntExtra(FlowersAdapter.Item_KEY, Item_Id);

         extras = getIntent().getExtras();
        if (extras !=null);
        name = extras.getString("name");
        price_st = extras.getString("price");
        details1 = extras.getString("details");
        img = extras.getString("image");

        name1.setText(name);
        price.setText(price_st);

        Glide.with(this).load(img).into(details_image);

          details.setText(details1);
//--------------------------------------------------------------------------------

        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                sum++;
                count.setText(sum + "");
                totalprice.setText(totalprice()+ "");
            }
        });

        min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sum--;
                count.setText(sum + "");
                totalprice.setText(totalprice()+ "");


            }
        });

    }
    public int totalprice(){
        int Price = Integer.parseInt((price.getText().toString()));
        int Count = Integer.parseInt((count.getText().toString()));
        int Total = Count*Price;
        return (Total);
    }


    private void AddToCart(){

        CollectionReference questionRef = db.collection("categories");
        questionRef.whereEqualTo("id", currentUser.getUid()).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
               // Cart cart = new Cart();
                cartModels = new ArrayList<>();

                if (!queryDocumentSnapshots.isEmpty()) {
                    for (DocumentSnapshot snapshot : queryDocumentSnapshots) {
                        cart = snapshot.toObject(Cart.class);


                    }
                    cartModels = cart.getCartModels();
                    addCart();

                }else {
                    CartModel cartModel = new CartModel(name1.getText().toString() ,extras.getString(img), totalprice.getText().toString());

                    Cart cart = new Cart(currentUser.getUid() , cartModels);
                    db.collection("categories").document(currentUser.getUid()).set(cart);
                    Toast.makeText(getApplicationContext(),"succesful" , Toast.LENGTH_LONG).show();



                }

            }
        });






    }
    ArrayList<CartModel> cartModels;
    Cart cart ;
    private void addCart(){
        cartModels = cart.getCartModels();
        cartModels.add(new CartModel(name1.getText().toString(), extras.getString(img),  totalprice.getText().toString()));
        Cart cart = new Cart(currentUser.getUid(),cartModels);
        db.collection("categories").document(cart.getId()).set(cart);
        Toast.makeText(getApplicationContext(),"done" , Toast.LENGTH_LONG).show();
    }



}