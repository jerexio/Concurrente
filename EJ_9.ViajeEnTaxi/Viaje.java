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
public class Viaje {
    
    public static void main(String[] args){
        
        Taxi taxi = new Taxi();
        Taxista taxista = new Taxista(taxi);
        Pasajero pasajero = new Pasajero(taxi, "Don Juan"),
                 pasajero2 = new Pasajero(taxi, "Don Falconi");
        
        pasajero.start();
        pasajero2.start();
        taxista.start();
    }
}
