package com.example.menunavdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback; // Nuevo Import

/**
 * MainActivity: Configura el DrawerLayout y el NavigationView.
 * Implementa NavigationView.OnNavigationItemSelectedListener para manejar los clics del menú.
 */
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Establece el layout de la actividad
        setContentView(R.layout.activity_main);

        // 1. Configurar el Toolbar como la ActionBar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // 2. Obtener referencias
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        // 3. Establecer el Listener para manejar los clics del menú
        navigationView.setNavigationItemSelectedListener(this);

        // 4. Configurar el ActionBarDrawerToggle
        // Este objeto conecta la Toolbar con el DrawerLayout y proporciona el ícono de "hamburguesa"
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.navigation_drawer_open, // String resource para accesibilidad: "Abrir navegación"
                R.string.navigation_drawer_close // String resource para accesibilidad: "Cerrar navegación"
        );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState(); // Sincroniza el estado del icono de hamburguesa con el estado del cajón

        // 5. Configurar el manejo moderno del botón Atrás (Reemplaza el onBackPressed() obsoleto)
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            /**
             * Lógica que se ejecuta cuando se presiona el botón de Atrás.
             * Si el Drawer está abierto, lo cierra y consume el evento.
             */
            @Override
            public void handleOnBackPressed() {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    // Si el Drawer está cerrado, permite que el sistema maneje el botón Atrás
                    // Deshabilita el callback temporalmente para que el super.onBackPressed() funcione
                    this.setEnabled(false);
                    MainActivity.super.onBackPressed();
                }
            }
        });
    }

    /**
     * Este método se llama cuando un elemento del NavigationView es seleccionado.
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Manejar los clics del menú. Aquí es donde cargarías los Fragments.

        int id = item.getItemId();

        // Ejemplo simple de manejo de clics (reemplazar con lógica de Fragments)
        if (id == R.id.nav_home) {
            Toast.makeText(this, "Navegar a Home", Toast.LENGTH_SHORT).show();
            // Lógica para cargar Fragmento Home
        } else if (id == R.id.nav_gallery) {
            Toast.makeText(this, "Navegar a Galería", Toast.LENGTH_SHORT).show();
            // Lógica para cargar Fragmento Galería
        }
        // ... otros elementos de menú

        // Cierra el cajón después de la selección
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    /* * NOTA: El método onBackPressed() obsoleto ha sido eliminado y
     * su lógica se ha movido al OnBackPressedCallback dentro de onCreate().
     */
}
