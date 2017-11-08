package com.example.jhorje.menus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Variables
    Toolbar toolbar;
    LinearLayout ly

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Establece que elemento es el Toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ly = (LinearLayout)

        //Registramos menu contextual
        registerForContextMenu();
    }

    //Establece el menu de opciones
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater mMenuInflater = getMenuInflater();
        mMenuInflater.inflate(R.menu.menu_opciones, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Que boton del menu de opciones ha pulsado??
    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){
            case R.id.accionAjustes:
                Toast.makeText(MainActivity.this, "Has pinchado en ajustes", Toast.LENGTH_SHORT).show();
                break;
            case R.id.accionInfo:
                Toast.makeText(MainActivity.this, "Has pinchado en la información", Toast.LENGTH_LONG).show();
                break;
        }
        
        return super.onOptionsItemSelected(item);
    }
}
