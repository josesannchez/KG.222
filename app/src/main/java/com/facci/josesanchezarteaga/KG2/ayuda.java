package com.facci.josesanchezarteaga.KG2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ayuda extends AppCompatActivity {
Button CONSEJO;
    Button Contacto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);
        CONSEJO= (Button) findViewById(R.id.button6CONSEJO);
        CONSEJO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // se genera la navegabilidad entre la actividad principal y la actividad de login
                Intent intent = new Intent(ayuda.this, Consejo.class);
                startActivity(intent);
            } });
        Contacto= (Button) findViewById(R.id.button7Contacto);
        Contacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // se genera la navegabilidad entre la actividad principal y la actividad de login
                Intent intent = new Intent(ayuda.this,Contacto.class);
                startActivity(intent);
            } });
    }
}
