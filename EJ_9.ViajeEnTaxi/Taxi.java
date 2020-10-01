/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.EJ_9.ViajeEnTaxi;

import java.util.concurrent.Semaphore;
/**
 *
 * @author jerem
 */
public class Taxi {
    
    private Semaphore semTaxista = new Semaphore(0, true);
    private Semaphore semPasajero = new Semaphore(0, true);
    private Semaphore semTaxi = new Semaphore(1, true);
    
    
    public void subir(String nombre){
        try{
            semTaxi.acquire();      //El pasajero se sube al taxi
            
            System.out.println(nombre + " se subio al taxi"
                    + " e indica a donde quiere ir");
            
            semTaxista.release();   //Despertar Taxista
            semPasajero.acquire();  //Todavia no llegamos a destino || Bloquea al pasajero
        
        }
        catch(InterruptedException e){
            System.err.println("El pasajero tiene 3.000 de ping y se desconecto de la simulacion");
        }
    }
    
    public void arrancar(){
        try{
            semTaxista.acquire();   //Conducir
        }
        catch(InterruptedException e){
            System.err.println("Un arbol se atraveso en el camino");
        }
    }
    
    public void llegar(){
        semPasajero.release();  //Llegamos || Libera al pasajero
        System.out.println("Llegamos a destino");
    }
    
    public void bajar(){
        semTaxi.release();      //Baja del taxi
        try{
            semPasajero.acquire();
        }
        catch(InterruptedException e){
            System.err.println("El pasajero se agarro la mano con la puerta");
        }
    }
    
    public void pagar(String nombre){
        System.out.println(nombre+": \"Aqui esta su pago\"");
        semTaxista.release();   //Ya termino de conducir y me pagaron
    }
    
    public void dormir(){
        try{
            semTaxista.acquire();   //Vuelve a dormir
            System.out.println("Taxista: \"Buenop, a dormir hasta que llegue un cliente\"");
            System.out.println("Taxista: \"ZZZ\"");
        }
        catch(InterruptedException e){
        }
    }
}
