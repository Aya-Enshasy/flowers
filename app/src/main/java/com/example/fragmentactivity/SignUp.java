package com.example.fragmentactivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity {

    private FirebaseAuth mAuth;
    EditText user_name,input_pass,phone,input_email,address;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        //user_name = findViewById(R.id.username_new_user);
        input_pass= findViewById(R.id.password2);
        //phone = findViewById(R.id.phone);
        input_email = findViewById(R.id.email_new_user);
        //address = findViewById(R.id.address);
        register = findViewById(R.id.ok_register);




//        EditText emails = findViewById(R.id.email);
//        EditText pas = findViewById(R.id.password);
//        Button register = findViewById(R.id.login);
//        TextView signup = findViewById(R.id.new_account);

//        String email = emails.getText().toString();
//        String password = pas.getText().toString();
        mAuth = FirebaseAuth.getInstance();
        register.setEnabled(true);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = input_email.getText().toString();
                String password = input_pass.getText().toString();

                if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password) )
                    register(email, password);
            }
        });


    }

    private void register (String email,String password){
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser firebaseUser = mAuth.getCurrentUser();
                    Toast.makeText(getApplicationContext(), "Welcome" + firebaseUser.getEmail(), Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Error" + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    Log.e("errror",task.getException().toString());

                } }}); }


}




