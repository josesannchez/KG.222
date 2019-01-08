package com.facci.josesanchezarteaga.KG2.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.facci.josesanchezarteaga.KG2.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class Usuario extends AppCompatActivity {
     TextView tvNombre,tvApellido, tvRut, tvPassword, tvSecreta; //AQUI CREO LAS VARIABLES QUE DESEO MOSTRAR
    private ListView lista;  //HAGO UN PRIVATE DE LISTVIEW LLAMADA LISTA QUE ESTA NOS MOSTRARÁ LOS DATOS
    private AsyncHttpClient cliente;  //AQUI CREO UN ASYNCHTTPCLIENTE LLAMADA CLIENTE
    private Button btn; //ACÁ CREO UN BOTON PRIVADO LLAMADO BTN

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);



        tvNombre = findViewById(R.id.TextV_nombre);
        lista = findViewById(R.id.lista);
  //AQUI DEFINO LAS VARIABLES Y LE DOY VALOR DEL ACTIVITY
        cliente = new AsyncHttpClient(); //AQUI CREO EL METODO Y LE ASIGNO A CLIENTE




        Intent intent = getIntent();  //AQUI DEFINO EL INTENT
        String name=intent.getStringExtra("name"); //AQUI HAGO LA VARIABLE NAME CON EL INTENT Y TOMA EL VLOR NAME DEL PHP

        obtenerinfo(); //ACÁ HABRO EL METODO PRIVADO OBTENER INFORMACION



         tvNombre.setText(name);  //AQUI MANDO A LA VARIABLE NOMBRE CON EL VALOR DE NAME





    }



    private void obtenerinfo(){   //AQUI CREO UN METODO PRIVADO

        String url="http://192.168.0.106/phpAndroid/obtenerdatos.php";  //ASIGNO LA DIRECCIÓN DEL ARCHIVO PHP OBTENERDATOS
        cliente.post(url, new AsyncHttpResponseHandler() {  //ASIGNO CON LA VARIABLE CLIENTE LA DIRECCION Y UN NEW ASYNCHTTPRESPONSEHANDLER
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if(statusCode ==200){   //ACÁ DIGO QUE SI ESTÁ CORRECTO, TOME EL STATUSCODE, EL HEADER
                    listarinformacion(new String (responseBody)); //AQUI DIGO QUE LISTE LA INFORMACION DEPENDIENDO DEL RESPONSEBODY

                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

    }

    private void listarinformacion(String respuesta){ //AQUI HAGO UN METODO PRIVADO LISTARINFORMACION CON UNA VARIABLE STRING LLAMADA RESPUESTA

        ArrayList<Info> info = new ArrayList<Info>();  //AQUI HAGO UN ARRAYLIST LLAMADO INFO

        try {  //HAGO UN TRY CATCH CON UN JSONARRAY LLAMADO jsonArreglo con LA VARIABLE RESPUESTA
            JSONArray jsonArreglo = new JSONArray(respuesta);
            for (int i=0; i<jsonArreglo.length(); i++){  //HAGO UN FOR PARA QUE TOME EL LARGO

                Info p = new Info();  // Y AQUI CREO UN METODO LLAMADO P
                p.setDia(jsonArreglo.getJSONObject(i).getString("dia"));  //AQUI MANDO A LA VARIABLE DIA CON UN JSONARREGLO Y JSONOBJECT QUE TOMA LOS DATOS DEL PHP LLAMADO DIA
                p.setmes(jsonArreglo.getJSONObject(i).getString("mes"));
                p.setMensaje(jsonArreglo.getJSONObject(i).getString("mensaje"));
                info.add(p); //AQUI AÑADO AL ARRAY INFO

                ArrayAdapter<Info> a = new ArrayAdapter(this,android.R.layout.simple_list_item_1,info);
                lista.setAdapter(a);
                //AQUI HAGO UN ARRAYADAPTER QUE MANDE LOS DATOS A LA LISTA

            }
        }catch (Exception e1){

            e1.printStackTrace();
        }

    }


}
