package com.masanz.logic;

public class Persona {

    private String nombre;
    private String apellidos;
    private String siglas;
    private int puntos;
    private Posicion posicion;

    public Persona(String nombre, String apellidos, String siglas, int puntos, int fila, int columna) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.siglas = siglas;
        this.puntos = puntos;
        posicion = new Posicion(fila, columna);
    }

    public boolean actualizar(String nombre, String apellidos, String siglas, int puntos, int fila, int columna) {
        setNombre(nombre);
        setApellidos(apellidos);
        setSiglas(siglas);
        setPuntos(puntos);
        setPosicion(new Posicion(fila, columna));
        return true;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return apellidos + ", " + nombre +
                " (" + siglas + "," + getPosicion().getFila() + "," + getPosicion().getColumna() + "): " +
                puntos;
    }

    public String getApellidosNombre() {
        return apellidos + ", " + nombre;
    }

    public boolean equals(Persona p) {
        if (p==null) return false;
        return apellidos.equals(p.apellidos) && nombre.equals(p.nombre);
    }
}
