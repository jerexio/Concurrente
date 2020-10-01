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
public class Taxista extends Thread {
    
    private Taxi taxi;
    
    public Taxista(Taxi taxi){
        this.taxi = taxi;
    }
    
    public void run(){
        while(true){
            taxi.arrancar();
            conducir();
            taxi.llegar();
            
            taxi.dormir();
        }
    }
    
    private void conducir(){
        try{
            System.out.println("Rum, rum, Taxista empieza a manejar");
            Thread.sleep(((int) (Math.random() * 5) + 1 ) * 1000);
        }
        catch(InterruptedException e){
            System.err.println("Un arbol se atraveso en el camino");
        }
    }
}
s