/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.EJ_4.AutosViajando;

/**
 *
 * @author jerem
 */
public class Vehiculo {
    private String patente; //Tipo: 3 Letras y 3 Numeros (AAA000)
    private String modelo;
    private String marca;
    private int KmToService;

    public Vehiculo(String patente, String modelo, String marca, int KmToService) {
        this.patente = patente;
        this.modelo = modelo;
        this.marca = marca;
        this.KmToService = KmToService;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getKmToService() {
        return KmToService;
    }

    public void setKmToService(int KmToService) {
        this.KmToService = KmToService;
    }
}