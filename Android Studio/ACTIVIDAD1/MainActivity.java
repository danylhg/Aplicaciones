package com.example.actividad_1;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TextView pantalla;
        Button login;
        Button cancel;
        EditText usuario;
        EditText password;
        ImageView imagen;

        password = findViewById(R.id.contra);
        usuario = findViewById(R.id.user);
        pantalla = findViewById(R.id.screen);
        login = findViewById(R.id.clicklog);
        cancel = findViewById(R.id.clickcancel);
        imagen = findViewById(R.id.imagen);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto=usuario.getText().toString();
                String texto2=password.getText().toString();

                String userCorrecto = "Paco";
                String passCorrecto = "admin";

                if (texto.equals(userCorrecto) && texto2.equals(passCorrecto)) {
                    pantalla.setText("Acesso correcto :)");
                    pantalla.setTextColor(Color.parseColor("#00FF11"));
                    imagen.setImageResource(R.drawable.ok);
                    imagen.setVisibility(View.VISIBLE);

                } else {
                    pantalla.setText("Acceso no autorizado >:(");
                    pantalla.setTextColor(Color.parseColor("#FF0000"));
                    imagen.setImageResource(R.drawable.error);
                    imagen.setVisibility(View.VISIBLE);

                }

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario.setText(" ");
                password.setText(" ");

            }
        });





    }
}