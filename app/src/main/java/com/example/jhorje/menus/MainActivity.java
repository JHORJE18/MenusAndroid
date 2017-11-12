package com.example.jhorje.menus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    //Variables
    Toolbar toolbar;
    LinearLayout ly;
    Boolean modeNight = false;
    TextView txtHola, txtBienvenido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Establece que elemento es el Toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ly = (LinearLayout) findViewById(R.id.baseLY);

        //Asginacion Vista -- Controlador
        txtHola = (TextView) findViewById(R.id.txtHola);
        txtBienvenido = (TextView) findViewById(R.id.txtBienvenido);
        modoNoche();

        //Asignamos popup
        txtHola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PopupMenu popupMenu = new PopupMenu(MainActivity.this, txtHola);
                popupMenu.getMenuInflater().inflate(R.menu.menu_popup, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch(item.getItemId()){
                            case R.id.aumentarTamaño:
                                tamañoTXT(true,txtHola);
                                break;
                            case R.id.reducirTamaño:
                                tamañoTXT(false,txtHola);
                                break;
                        }
                        return false;
                    }
                });

                popupMenu.show();
            }
        });
        txtBienvenido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PopupMenu popupMenu = new PopupMenu(MainActivity.this, txtBienvenido);
                popupMenu.getMenuInflater().inflate(R.menu.menu_popup, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch(item.getItemId()){
                            case R.id.aumentarTamaño:
                                tamañoTXT(true,txtBienvenido);
                                break;
                            case R.id.reducirTamaño:
                                tamañoTXT(false,txtBienvenido);
                                break;
                        }
                        return false;
                    }
                });

                popupMenu.show();
            }
        });

        //Registramos el menu contextual
        registerForContextMenu(ly);
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
                Toast.makeText(MainActivity.this, "APP by Jorge López Gil", Toast.LENGTH_LONG).show();
                break;
        }
        
        return super.onOptionsItemSelected(item);
    }

    //Cargar menu contextual en la pantalla
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu_ajustes, menu);
    }

    //Gestion eventos menu Contextual
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.cambiarColor:
                modoNoche();
                Toast.makeText(getBaseContext(),"Color cambiado!",Toast.LENGTH_LONG);
                break;
            default:
                Toast.makeText(getBaseContext(),"Proximamente...",Toast.LENGTH_LONG);
        }
        return super.onContextItemSelected(item);
    }

    //EXTRA
        //MODO NOCHE
    public void modoNoche(){
        if (modeNight){
            ly.setBackground(getDrawable(R.color.day));
            txtHola.setTextColor(getColor(R.color.negro));
            txtBienvenido.setTextColor(getColor(R.color.negro));
            modeNight = false;
        } else {
            ly.setBackground(getDrawable(R.color.night));
            txtHola.setTextColor(getColor(R.color.blanco));
            txtBienvenido.setTextColor(getColor(R.color.blanco));
            modeNight = true;
        }
    }

        //AUMENTAR & REDUCIR TEXTO
    public void tamañoTXT(boolean aumentar, TextView elemento){
        if (aumentar){
            elemento.setTextSize((elemento.getTextSize() * 2));
            Toast.makeText(MainActivity.this,"Texto " + elemento.getText() + " aumentado",Toast.LENGTH_LONG);
        } else {
            elemento.setTextSize((elemento.getTextSize() / 2));
            Toast.makeText(MainActivity.this,"Texto " + elemento.getText() + " reducido",Toast.LENGTH_LONG);
        }
    }
}
