package com.example.fragmentcallbackwithanavdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.fragmentcallbackwithanavdrawer.utils.Gol;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    /**
     * 1 Variables globales
     **/
    private Toolbar toolbar; // La toolbar pour afficher le menu hamburger
    private DrawerLayout drawer_layout; // L'obj NavigationDrawer
    private NavigationView navigationView; // Gestion de la NavigationView pour traiter le drawer en s'appuyant sur l'extends

    // Variable emplacement
    private static final String emplacement = MainActivity.class.getSimpleName();

    /**
     * 2 Faire le lien entre les widgets et le design
     **/
    public void initUI() {
        toolbar = findViewById(R.id.toolbar);
        drawer_layout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_navigationView);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gol.addLog(emplacement, "onCreate");

        // Appel de la méthode d'initialisation de l'UI
        initUI();
        // Ajout du support pour la gestion de la Toolbar
        setSupportActionBar(toolbar);

        // Ajout de la gestion des options d'accessibilité
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, // Le context de l'activité
                drawer_layout, // Le layout du MainActivity
                toolbar, // La toolbar
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        // Ajout d'un listener sur le bouton hamburger
        drawer_layout.addDrawerListener(toggle);
        // Synchro entre le bouton hamburger et le menu
        toggle.syncState();

        // Gestion du clic sur un des item du menu
        navigationView.setNavigationItemSelectedListener(this);

        if(savedInstanceState == null){
            addFragment();
            // Force l'affichage du 1er fragment au démarrage
            navigationView.setCheckedItem(R.id.nav_fragment_1);
        }
    }

    // Ajout des Fragments
    private void addFragment() {
        FragmentManager fragmentManager; // La gestion des fragments
        FragmentTransaction fragmentTransaction; // L'aide pour la transition entre les fragments
        fragmentManager = getSupportFragmentManager();
        // Commencer la discussion
        fragmentTransaction = fragmentManager.beginTransaction();
        // Appel du nouveau fragment
        Fragment_01 fragment_01 = new Fragment_01();
        // Ajouter au container de fragment
        fragmentTransaction.add(R.id.fragment_container, fragment_01);
        // Finalisation de la création du fragment
        fragmentTransaction.commit();
    }


//    Gestion du clic dans le menu
    @Override
    public boolean onNavigationItemSelected(@NonNull @org.jetbrains.annotations.NotNull
                                                    MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_fragment_1:
                getSupportFragmentManager().
                        beginTransaction().
                        replace(R.id.fragment_container, new Fragment_01()).
                        commit();
                break;
            case R.id.nav_fragment_2:
                getSupportFragmentManager().
                        beginTransaction().
                        replace(R.id.fragment_container, new Fragment_02()).
                        commit();
                break;
            case R.id.nav_fragment_3:
                getSupportFragmentManager().
                        beginTransaction().
                        replace(R.id.fragment_container, new Fragment_03()).
                        commit();
                break;
            case R.id.nav_fragment_4:
                getSupportFragmentManager().
                        beginTransaction().
                        replace(R.id.fragment_container, new Fragment_04()).
                        commit();
                break;
            case R.id.nav_fragment_5:
                getSupportFragmentManager().
                        beginTransaction().
                        replace(R.id.fragment_container, new Fragment_05()).
                        commit();
                break;
        }

        drawer_layout.closeDrawer(GravityCompat.START);
        return true;
    }

    // Gestion du bouton back
    @Override
    public void onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /** Méthodes du cycles de vies **/
    @Override
    protected void onStart() {
        super.onStart();
        Gol.addLog(emplacement, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Gol.addLog(emplacement, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Gol.addLog(emplacement, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Gol.addLog(emplacement, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Gol.addLog(emplacement, "onDestroy");
    }
}