/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.EJ_9.ViajeEnTaxi;

/**
 *
 * @author jerem
 */
public class Pasajero extends Thread {
    
    private Taxi taxi;
    private String nombre;
    
    public Pasajero(Taxi taxi, String nombre){
        this.taxi = taxi;
        this.nombre = nombre;
    }
    
    public void run(){
        taxi.subir(nombre);
        taxi.pagar(nombre);
        taxi.bajar();
    }
}
