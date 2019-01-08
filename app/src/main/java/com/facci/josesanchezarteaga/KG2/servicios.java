package com.facci.josesanchezarteaga.KG2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class servicios extends AppCompatActivity {
Button mantenimiento;
Button ATENCION;
Button RESERVACION;
Button NEXT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios);
        mantenimiento = (Button) findViewById(R.id.buttonMante);
       mantenimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // se genera la navegabilidad entre la actividad principal y la actividad de login
                Intent intent = new Intent(servicios.this, MANTENIMIENTO.class);
                startActivity(intent);
            } });
        ATENCION= (Button) findViewById(R.id.button6atencio);
        ATENCION.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // se genera la navegabilidad entre la actividad principal y la actividad de login
                Intent intent = new Intent(servicios.this, AtencioCliente.class);
                startActivity(intent);
            } });
        RESERVACION= (Button) findViewById(R.id.button5Reservaciones);
        RESERVACION.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // se genera la navegabilidad entre la actividad principal y la actividad de login
                Intent intent = new Intent(servicios.this, RESERVACIONES.class);
                startActivity(intent);
            } });
        NEXT= (Button) findViewById(R.id.button8next2);
        NEXT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // se genera la navegabilidad entre la actividad principal y la actividad de login
                Intent intent = new Intent(servicios.this, ayuda.class);
                startActivity(intent);
            } });
    }
}
