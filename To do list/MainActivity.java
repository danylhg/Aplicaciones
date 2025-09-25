package com.example.listatareas;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listaTareas;
    private EditText inputTarea;
    private Button btnAgregar;
    private ArrayAdapter<String> adaptador;
    private ArrayList<String> tareas = new ArrayList<>();

    private static final String PREFS = "todo_prefs";
    private static final String KEY_TAREAS = "tareas_json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaTareas = findViewById(R.id.listaTareas);
        inputTarea  = findViewById(R.id.inputTarea);
        btnAgregar  = findViewById(R.id.btnAgregar);

        cargarTareas();

        adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_checked, tareas);
        listaTareas.setAdapter(adaptador);
        listaTareas.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        // Agregar
        btnAgregar.setOnClickListener(v -> {
            String tarea = inputTarea.getText().toString().trim();
            if (!tarea.isEmpty()) {
                tareas.add(tarea);
                adaptador.notifyDataSetChanged();
                inputTarea.setText("");
                guardarTareas();
            }
        });

        // Marcar/Desmarcar
        listaTareas.setOnItemClickListener((parent, view, position, id) -> {
            CheckedTextView check = (CheckedTextView) view;
            check.setChecked(!check.isChecked());
        });

        // Eliminar con long press
        listaTareas.setOnItemLongClickListener((parent, view, position, id) -> {
            String item = tareas.get(position);
            new AlertDialog.Builder(this)
                    .setTitle("Eliminar")
                    .setMessage("¿Borrar \"" + item + "\"?")
                    .setPositiveButton("Sí", (DialogInterface dialog, int which) -> {
                        tareas.remove(position);
                        adaptador.notifyDataSetChanged();
                        guardarTareas();
                    })
                    .setNegativeButton("Cancelar", null)
                    .show();
            return true;
        });
    }

    // ---- Persistencia sencilla ----
    private void guardarTareas() {
        JSONArray arr = new JSONArray(tareas);
        SharedPreferences sp = getSharedPreferences(PREFS, MODE_PRIVATE);
        sp.edit().putString(KEY_TAREAS, arr.toString()).apply();
    }

    private void cargarTareas() {
        SharedPreferences sp = getSharedPreferences(PREFS, MODE_PRIVATE);
        String json = sp.getString(KEY_TAREAS, "[]");
        try {
            JSONArray arr = new JSONArray(json);
            tareas.clear();
            for (int i = 0; i < arr.length(); i++) {
                tareas.add(arr.getString(i));
            }
        } catch (Exception ignored) {}
    }
}
