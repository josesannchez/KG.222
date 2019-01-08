package com.facci.josesanchezarteaga.KG2.Login;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.facci.josesanchezarteaga.KG2.R;

import org.json.JSONException;
import org.json.JSONObject;

public class Registro extends AppCompatActivity implements View.OnClickListener {
    EditText etnombre, etapellido, etrut, etpassword, etsecreta; //CREACION DE VARIABLES

    Button btn_registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        etnombre= findViewById(R.id.EditT_nombre);  //AQUI ESTOY DEFINIENDO LOS VALORES DE LAS VARIABLES DEL ACTIVITY REGISTRO
        etapellido= findViewById(R.id.EditT_apellido);
        etrut= findViewById(R.id.EditT_cedula);
        etpassword= findViewById(R.id.EditT_password);
        etsecreta= findViewById(R.id.EditT_secreta);


   btn_registrar = findViewById(R.id.Btn_registrar);     //AQUI HAGO CLICK EN EL BOTON Y HACE LO SIGUIENTE
   btn_registrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        final String name=etnombre.getText().toString();  //AL HACER CLIC TOMA LOS VALORES FINALES Y LOS PASA A STRING
        final String apellido=etapellido.getText().toString();
        final String cedula=etrut.getText().toString();
        final String password=etpassword.getText().toString();
        final String secreta=etsecreta.getText().toString();




        Response.Listener<String> respoLister = new Response.Listener<String>() {  //LLAMA AL ESCUCHADOR
            @Override
            public void onResponse(String response) {


                    if (etnombre.getText().toString().isEmpty()){  //SE APLICA UNA CONDICIÓN SI LOS CAMPOS ESTÁN VACÍOS

                        Toast.makeText(Registro.this, "Debe ingresar nombre", Toast.LENGTH_SHORT).show();
                      //SE MANDA MENSAJE

                    }else if (etapellido.getText().toString().isEmpty()) {

                        Toast.makeText(Registro.this, "Debe ingresar apellido", Toast.LENGTH_SHORT).show();

                    }else if (etrut.getText().toString().isEmpty()) {

                        Toast.makeText(Registro.this, "Debe ingresar rut", Toast.LENGTH_SHORT).show();

                    }else if (etpassword.getText().toString().isEmpty()) {

                        Toast.makeText(Registro.this, "Debe ingresar contraseña", Toast.LENGTH_SHORT).show();

                    }else if (etsecreta.getText().toString().isEmpty()) {

                        Toast.makeText(Registro.this, "Debe ingresar nombre primera mascota", Toast.LENGTH_SHORT).show();

                    }


                try {
                    JSONObject jsonReponse = new JSONObject(response);
                    boolean success= jsonReponse.getBoolean("success");
                   //YA SI NO HAY NINGUN PROBLEMA HACE LO SIGUIENTE....
                    if(success){
                        //AQUÍ DIGO SI SE REGISTRÓ CORRECTAMENTE MANDO UN MENSAJE
                        Toast.makeText(Registro.this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(Registro.this,Login.class);
                        Registro.this.startActivity(intent);

                    }else{
                        //DE CASO CONTRARIO DIGO QUE EL ALUMNO YA ESTÁ REGISTRADO

                        AlertDialog.Builder builder = new AlertDialog.Builder(Registro.this);
                        builder.setMessage("Usuario ya está registrado ").setNegativeButton("Volver",null).create().show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        };

        RegisterRequest registerRequest= new RegisterRequest(name, apellido,cedula,password,secreta,respoLister);
        RequestQueue queue = Volley.newRequestQueue(Registro.this);
        queue.add(registerRequest);  //AQUI TOMO LAS VARIABLES Y LAS EJECUTO
    }
}
