package com.example.firebaseauth;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    TextInputEditText email, password;
    MaterialButton b_login;
    ProgressBar progressBar;
    TextView registernow;
    FirebaseAuth mAuth;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent i=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
            finish();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        //FirebaseApp.initializeApp(this);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        b_login=findViewById(R.id.btn_login);
        progressBar=findViewById(R.id.progress_bar);
        registernow=findViewById(R.id.register_now);
        mAuth=FirebaseAuth.getInstance();

        registernow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Register.class);
                startActivity(i);
                finish();
            }
        });

        b_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                String txt_email, txt_password;
                txt_email=email.getText().toString();
                txt_password=String.valueOf(password.getText());

                if(TextUtils.isEmpty(txt_email)){
                    Toast.makeText(Login.this,"Registre su email",Toast.LENGTH_SHORT ).show();
                    return;
                }
                if(TextUtils.isEmpty(txt_password)){
                    Toast.makeText(Login.this,"Registre su clave de acceso",Toast.LENGTH_SHORT ).show();
                    return;
                }

                mAuth.signInWithEmailAndPassword(txt_email, txt_password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    Toast.makeText(Login.this, "Login Succesful.",
                                            Toast.LENGTH_SHORT).show();
                                    Intent i=new Intent(getApplicationContext(),MainActivity.class);
                                    startActivity(i);
                                    finish();
                                } else {
                                    Toast.makeText(Login.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

    }
}