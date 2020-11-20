/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6.EJ_7_Pasteleria;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 *
 * @author jerem
 */
public class Caja {
    
    private int pesoMax;
    private int pesoActual;
    private Lock mutexCaja = new ReentrantLock();

    public Caja(int pesoMax, int pesoActual) {
        this.pesoMax = pesoMax;
        this.pesoActual = pesoActual;
    }
    
    public boolean ponerPastel(int pesoTorta){
        mutexCaja.lock();
        
        System.out.println("Intento poner pastel");
        boolean sePudo = false;
        try{
            
            if(pesoActual + pesoTorta <= pesoMax){
                System.out.println("Si pude");
                pesoActual += pesoTorta;
                sePudo = true;
            }
            
            return sePudo;
        }
        finally{
            mutexCaja.unlock();
        }
    }
    
    public void retirarCaja(){
        mutexCaja.lock();
        System.out.println("Sello caja");
    }
}
