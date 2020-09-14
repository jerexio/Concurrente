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
public class Auto extends Vehiculo implements Runnable {

    private Surtidor surtCercano;

    public Auto(Surtidor surtCercano, String patente, String modelo, String marca, int KmToService) {
        super(patente, modelo, marca, KmToService);
        this.surtCercano = surtCercano;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName()
                + " Recorre XX Km, llega a reserva y se dirige a una estacion de servicio.");
        this.surtCercano.ponerseEnFila(this);
        
        while (this.surtCercano.getFrenteFila().equals(this)) {}

        synchronized (surtCercano) {
            System.out.println(this.surtCercano.getFrenteFila().getPatente()
                    + " Esta cargando actualmente.");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ignore) {
                System.err.println("Parece que exploto la estacion de servicio");
            }
            finally{
                System.out.println("Se finalizo de cargar");
                this.surtCercano.cargarYSalir();
            }

        }
    }
    
    public synchronized boolean equals(Object o){
        Auto auto2 = (Auto) o;
        
        return (this.getPatente().equals(auto2.getPatente()));
    }
}