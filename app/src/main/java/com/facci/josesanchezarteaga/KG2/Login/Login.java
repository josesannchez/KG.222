package com.facci.josesanchezarteaga.KG2.Login;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.facci.josesanchezarteaga.KG2.MainActivity;
import com.facci.josesanchezarteaga.KG2.R;

import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity {

    EditText et_rut, et_password;    //CREACIÓN DE VARIABLES
    TextView tv_registrar;
    private Button btn_log;






    @Override
    protected void onCreate(Bundle savedInstanceState) {   //AQUI CREO UN PROTECT VOID ONCREATE QUE HACE GUARDAR Y ENVIAR LOS DATOS DEL ACTIVITY
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tv_registrar = (TextView) findViewById(R.id.tv_registrar);   //AQUI DIGO QUE LAS VARIABLES SEAN IGUAL AL TEXTO QUE ESTOY TOMANDO EN EL ACTIVIVY
        et_rut = (EditText) findViewById(R.id.TextV_rut);
        et_password = (EditText) findViewById(R.id.TextV_password);
        btn_log = (Button) findViewById(R.id.Btn_iniciar);


        tv_registrar.setOnClickListener(new View.OnClickListener() {//AQUI DIGO QUE AL HACER CLIC EN EL TEXT ABRA EL LA CLASE REGISTRO
            @Override
            public void onClick(View v) {
                Intent intentReg = new Intent(Login.this, Registro.class);
                Login.this.startActivity(intentReg);
            }
        });   //


        btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {      //AQUI DIGO QUE EN EL BOTON LOGIN HAGA LO SIGUIENTE....

                if (et_rut.getText().toString().isEmpty()){  //AQUI DIGO SI EL CAMPO RUT ESTÁ VACÍO

                    Toast.makeText(Login.this, "Debe ingresar rut", Toast.LENGTH_SHORT).show(); //MANDE UN MENSAJE QUE DEBE INGRESAR RUT

                }else if (et_password.getText().toString().isEmpty()) {
                    //AQUI DIGO SI EL CAMPO PASSWORD ESTÁ VACÍO, TAMBIÉN MANDE UN MENSAJE DE QUE ESTÁ VACÍO

                    Toast.makeText(Login.this, "Debe ingresar contraseña", Toast.LENGTH_SHORT).show();

                }
                    final String rut = et_rut.getText().toString(); //YA SI SE CUMPLEN LOS CAMPOS, DIGO QUE TOME LO QUE SE ESTÁ INSERTANDO
                    final String password = et_password.getText().toString();
                    Response.Listener<String> responseListener = new Response.Listener<String>() { //LLAMO AL ESCUCHADOR
                        @Override
                        public void onResponse(String response) {

                            try {
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");
                                if (success) {
                                    //Y HAGO AQUÍ UN TRY CATCH Y LLAMO AL JSONOBJECT y digo si está bien

                                    String name = jsonResponse.getString("name");
                                    //TOMA EL DATO NOMBRE DEL PHP NOMBRE



                                    Intent intent = new Intent(Login.this, MainActivity.class);
                                    intent.putExtra("name", name);
                                    //Y AQUI HAGO UN INTENT Y DIGO QUE HABRA LA CLASE USUARIO Y TOME EL NOMBRE

                                    Login.this.startActivity(intent);

                                } else {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                                    builder.setMessage("Rut y/o Contraseña Incorrecto")
                                            .setNegativeButton("Volver", null)
                                            .create().show();
                                    //DE CASO CONTRARIO, SI LA CLAVE ES ERRORNEA MANDE UN MENSAJE DE ALERTA QUE ESTÁ EQUIVOCADA

                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                        }

                    };
                    LoginRequest loginRequest = new LoginRequest(rut, password,responseListener);
                    RequestQueue queue = Volley.newRequestQueue(Login.this);
                    queue.add(loginRequest);  }   //AQUI DIGO QUE TOME LOS DATOS RUT Y CONTRASEÑA, CON EL ESCUCHADOR Y LO EJECUTE





        }


        );

    }

}