package com.facci.josesanchezarteaga.KG2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;


public class MANTENIMIENTO extends AppCompatActivity {
Button modelo;
    ListView lista2;
    String[][] datos2 = {
            {"Cambio de Aceite", "", "88822", "", " Se realiza si el cleinte lo desea"},
            {"Chasis", "", "82225", "", "reparamos el chasi a nivel de los profesionales"},
            {"Direccionales", "", "849998", "", " necesario para evitar posible fallos en su conduncion "},
            {"Llantas", "", "949494", "", "Paa por dos pilotos cuyas mentes están unid     ."},
            {"Suspension", "", "55844", "", "Se realizara unicamente si el cliente lo desea"},
            {"Motor", "", "4844148", "", "el cobro dependera de que tan mal es te el motor"}
    };
    int[] datosImg2 = {R.drawable.cambioaceite, R.drawable.chasis, R.drawable.dreccionales, R.drawable.llantas, R.drawable.sunpension, R.drawable.motor};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mantenimiento);
        modelo= (Button) findViewById(R.id.buttonMate);
        modelo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // se genera la navegabilidad entre la actividad principal y la actividad de login
                Intent intent = new Intent(MANTENIMIENTO.this, Principal.class);
                startActivity(intent);
            } });
            lista2 = (ListView) findViewById(R.id.lvLista2);

            lista2.setAdapter(new Adaptador(this, datos2, datosImg2));

            lista2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent visorDetalles = new Intent(view.getContext(), DetalleAutos.class);
                    visorDetalles.putExtra("TIT", datos2[position][0]);
                    visorDetalles.putExtra("DET", datos2[position][4]);
                    startActivity(visorDetalles);
                }
            });

        }
    }

