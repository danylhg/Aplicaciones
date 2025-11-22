package com.example.firebaseauth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    Button logout;
    TextView txt_main;
    FirebaseAuth mAuth;
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //FirebaseApp.initializeApp(this);
        mAuth=FirebaseAuth.getInstance();
        logout=findViewById(R.id.logout);
        txt_main=findViewById(R.id.txt_main);
        user=mAuth.getCurrentUser();
        if(user==null){
            Intent i=new Intent(getApplicationContext(), Login.class);
            startActivity(i);
            finish();
        }
        else{
            txt_main.setText(user.getEmail());
        }

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent i=new Intent(getApplicationContext(), Login.class);
                startActivity(i);
                finish();
            }
        });

    }
}