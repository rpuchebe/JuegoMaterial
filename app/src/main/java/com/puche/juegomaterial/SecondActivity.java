package com.puche.juegomaterial;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    TextView texto;
    private Button btn;
    private Button btn2;
    private Button btn3;
    private ImageButton btn4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        texto = (TextView) findViewById(R.id.texto);
        btn = (Button)findViewById(R.id.princi);
        btn2= (Button)findViewById(R.id.inter);
        btn3= (Button)findViewById(R.id.avanza);
        btn4= (ImageButton)findViewById(R.id.logout);

        btn.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(this);


        Intent intent =getIntent();
        Bundle extras = intent.getExtras();

        if(extras!=null){

            String dato = extras.getString("USER");
            texto.setText(dato);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
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

        switch (view.getId()){

            case R.id.princi:

                Intent intent = new Intent(SecondActivity.this,Principiante.class);
                String Usuario = texto.getText().toString();
                intent.putExtra("USER",Usuario);
                startActivity(intent);
                break;
            case R.id.inter:

                intent = new Intent(SecondActivity.this,Intermedio.class);
                Usuario = texto.getText().toString();
                intent.putExtra("USER",Usuario);
                startActivity(intent);
                break;
            case R.id.avanza:

                intent = new Intent(SecondActivity.this,Avanzado.class);
                Usuario = texto.getText().toString();
                intent.putExtra("USER",Usuario);
                startActivity(intent);
                break;

            case R.id.fab:

                intent = new Intent(SecondActivity.this,Listado.class);
                Usuario = texto.getText().toString();
                intent.putExtra("USER",Usuario);
                startActivity(intent);
                break;
            case R.id.logout:

                intent = new Intent(SecondActivity.this,MainActivity.class);
                startActivity(intent);
                break;
        }

    }
}
