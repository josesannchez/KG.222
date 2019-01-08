package com.facci.josesanchezarteaga.KG2.Login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facci.josesanchezarteaga.KG2.R;


public class validacion extends AppCompatActivity {
    EditText EditTextrut;
    EditText EditTextpasword;
    EditText EditTextnombre;
    EditText EditTextapellido;
    EditText EditTextsecreta;

    @Override

    protected void onCreate(Bundle savedInstateState) {
        super.onCreate(savedInstateState);
        setContentView(R.layout.activity_login);
        setContentView(R.layout.activity_registro);
        EditTextrut = (EditText) findViewById(R.id.EditT_cedula);
        EditTextpasword= (EditText) findViewById(R.id.EditT_password);
        EditTextnombre=(EditText) findViewById(R.id.EditT_nombre);
        EditTextapellido=(EditText) findViewById(R.id.EditT_apellido);
        EditTextsecreta= (EditText) findViewById(R.id.EditT_secreta);

        Button Btn_registrase=(Button) findViewById(R.id.Btn_registrar);
        Btn_registrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validacion();
            }
        });
        Button Btn_inicio = (Button) findViewById(R.id.Btn_iniciar);
        Btn_inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validacion();
            }
        });

    }
    public void validacion(){
        EditTextrut.setError(null);
        EditTextpasword.setError(null);
        EditTextnombre.setError(null);
        EditTextapellido.setError(null);
        EditTextsecreta.setError(null);

        String cedula=EditTextrut.getText().toString();
        String pasword=EditTextpasword.getText().toString();
        String nombre=EditTextnombre.getText().toString();
        String apellido=EditTextapellido.getText().toString();
        String secreta= EditTextsecreta.getText().toString();

        if(TextUtils.isEmpty(cedula)){
            EditTextrut.setError(getString(R.string.erro_campo_obligario));
            EditTextrut.requestFocus();
            return;
        }

        if(TextUtils.isEmpty(pasword)){
            EditTextpasword.setError(getString(R.string.erro_campo_obligario));
            EditTextpasword.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(nombre)){
            EditTextnombre.setError(getString(R.string.erro_campo_obligario));
            EditTextnombre.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(apellido)){
            EditTextapellido.setError(getString(R.string.erro_campo_obligario));
            EditTextapellido.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(secreta)){
            EditTextsecreta.setError(getString(R.string.erro_campo_obligario));
            EditTextsecreta.requestFocus();
            return;
        }

        Toast.makeText(getApplicationContext(),"Se ha  Registrado correctamente",Toast.LENGTH_SHORT).show();


        if(TextUtils.isEmpty(cedula)){
            EditTextrut.setError(getString(R.string.cantidad_caracteres_8));
            EditTextrut.requestFocus();
            return;
        }

    }
}
