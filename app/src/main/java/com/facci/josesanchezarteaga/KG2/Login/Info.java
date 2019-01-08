package com.facci.josesanchezarteaga.KG2.Login;

public class Info {
    private String dia;  //AQUI DECLARO LAS VARIABLES PRIVADAS DE TIPO STRING
    private String mes;
    private String mensaje;

    public Info() {

    }

    public Info(String dia, String mes , String mensaje) { //AQUI ESTOY CREANDO UN CONSTRUCTOR CON LAS VARIABLES DENTRO
        this.dia = dia;  //SEÑALO QUE LA VARIABLE DIA ES IGUAL A DIA Y ASÍ CON LOS DEMÁS
        this.mes = mes;
        this.mensaje = mensaje;

    }

    public String getdia() {
        return dia;
    }  //AQUI HAGO UN UNA CLASE PUBLICA LLAMADA GETDIA LO QUE HACE ES RETORNAR LA VARIABLE

    public void setDia(String dia) {
        this.dia = dia;
    }
  //AQUI ESTOY MANDADO A LA VARIABLE DÍA LO QUE TOMÉ Y ASÍ CON LAS DEMÁS
    public String getmes() {
        return mes;
    }

    public void setmes(String mes) {
        this.mes = mes;
    }

    public String getMensaje(String mensaje) {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "" +
                "Dia: " + dia + " \nMes: " + mes + "\nMensaje: " +mensaje;  //FINALMENTE IMPRIMO LOS VALORES DE LAS VARIABLES
    }

}
