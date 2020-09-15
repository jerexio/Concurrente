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
        
        synchronized (surtCercano) {
            
            System.out.println(this.surtCercano.verFrente().getPatente()
                    + " Esta cargando actualmente.");
            
            this.surtCercano.cargarYSalir();
            
            try {
                Thread.sleep(3500);//Simula carga de combustible
                
            } catch (InterruptedException e) {
                System.err.println("Parece que exploto la estacion de servicio");
                
            }
            finally{
                System.out.println("Se finalizo de cargar");
            }

        }
    }
}