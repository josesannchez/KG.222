package com.facci.josesanchezarteaga.KG2.Login;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL="http://192.168.0.106/c/Register.php";
    //AQUI CREO UN METODO PRIVADO STRING DE TIPO REGISTER_REQUEST_URL, EL CUAL TENDRÁ COMO DIRECCIÓN LA DEL ARCHIVO PHP REGISTER
    private Map<String,String> params;  //AQUI HAGO LOS PARAMETROS MAP PRIVADOS
    public RegisterRequest(String name, String apellido, String cedula, String password, String secreta, Response.Listener<String> listener){
        //AQUI HAGO LAS VARIABLES QUE DESEO OBTENER DEL PHP
        super(Method.POST, REGISTER_REQUEST_URL,listener, null);
        params=new HashMap<>();
        params.put("nombre",name);   //TOMO NOMBRE
        params.put("apellido",apellido);  //APELLIDO
        params.put("cedula", cedula);   //RUT
        params.put("password",password);  //CONTRAÑA
        params.put("secreta",secreta);  //RESPUESTA SECRETA



    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
