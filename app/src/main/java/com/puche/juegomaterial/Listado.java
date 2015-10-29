package com.puche.juegomaterial;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;




public class Listado extends AppCompatActivity implements View.OnClickListener{

    LinearLayout listado;
    LinearLayout linear;
    Cursor c;
    TextView texto;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.fab1);
        floatingActionButton.setOnClickListener(this);
        texto = (TextView) findViewById(R.id.texto);
        final Funciones fun = new Funciones();
        listado = (LinearLayout)findViewById(R.id.linear);
        listado.removeAllViews();
        Intent intent =getIntent();
        Bundle extras = intent.getExtras();

        if(extras!=null){

            String dato = extras.getString("USER");
            texto.setText(dato);

        }

        c = fun.Mostrar(context);

        if(c.moveToFirst()){
            do{
                LinearLayout linear = new LinearLayout(this);
                linear.setOrientation(LinearLayout.HORIZONTAL);

                TextView Descripcion = new TextView(this);
                Descripcion.setTextSize(18);
                Descripcion.setWidth(500);

                final String id = new String(c.getString(0));
                final String nombre = new String(c.getString(1));
                final String puntaje = new String(c.getString(2));

                Descripcion.append("ID: " + id + "\n");
                Descripcion.append("Nombre: " + nombre + "\n");
                Descripcion.append("Puntaje: " + puntaje + "\n" + "\n");

                linear.addView(Descripcion);
                listado.addView(linear);

            }while (c.moveToNext());
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_listado, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.fab1:

                Intent intent = new Intent(Listado.this, SecondActivity.class);
                String Usuario = texto.getText().toString();
                intent.putExtra("USER",Usuario);
                startActivity(intent);
                break;
        }


    }
}
