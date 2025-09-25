package com.example.propinas;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView total;
    EditText cuenta;
    EditText personas;
    Button calcular;
    Button borrar;

    RadioButton cinco;
    RadioButton diez;
    RadioButton quince;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        personas = findViewById(R.id.personas);
        cuenta = findViewById(R.id.cuenta);
        cinco = findViewById(R.id.cinco);
        diez = findViewById(R.id.diez);
        quince = findViewById(R.id.quince);
        calcular= findViewById(R.id.calcula);
        borrar = findViewById(R.id.borra);
        total = findViewById(R.id.total);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String personasTxt= personas.getText().toString();
                int per = Integer.parseInt(personasTxt);

                String cuentaTxt= cuenta.getText().toString();
                int cun = Integer.parseInt(cuentaTxt);

                double porcentaje = 0.0;

                if(cinco.isChecked()){
                    porcentaje = 0.05;
                }else if (diez.isChecked()){
                    porcentaje = 0.10;
                }else if (quince.isChecked()){
                    porcentaje = 0.15;
                }

                double totalPropina = cun + (cun * porcentaje);
                double pagoPorPersona = totalPropina / per;

                total.setText(String.format("%.2f",pagoPorPersona));
            }
        });

        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total.setText(" ");
                personas.setText(" ");
                cuenta.setText(" ");
            }
        });


    }
}


