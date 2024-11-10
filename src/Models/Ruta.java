package Models;

import Repository.RutaRepository;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Ruta {

    private String id_ruta;
    private String origen;
    private String destino;
    private Duration tiempo_aproximado;
    private float precio;

    public static RutaRepository rr = new RutaRepository();

    public Ruta(String id_ruta, String origen, String destino, Duration tiempo_aproximado, float precio) {
        this.id_ruta = id_ruta;
        this.origen = origen;
        this.destino = destino;
        this.tiempo_aproximado = tiempo_aproximado;
        this.precio = precio;
    }

    public void aplicar_descuento(float descuento){
        this.precio = this.precio * (1 - descuento);
    }

    public String get_id_ruta() {
        return id_ruta;
    }

    public void set_id_ruta(String id_ruta) {
        this.id_ruta = id_ruta;
    }

    public String get_origen() {
        return origen;
    }

    public void set_origen(String origen) {
        this.origen = origen;
    }

    public String get_destino() {
        return destino;
    }

    public void set_destino(String destino) {
        this.destino = destino;
    }

    public Duration get_tiempo_aproximado() {
        return tiempo_aproximado;
    }

    public void set_tiempo_aproximado(Duration tiempo_aproximado) {
        this.tiempo_aproximado = tiempo_aproximado;
    }

    public float get_precio() {
        return precio;
    }

    public void set_precio(float precio) {
        this.precio = precio;
    }

}
