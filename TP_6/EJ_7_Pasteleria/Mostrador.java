/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6.EJ_7_Pasteleria;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 *
 * @author jerem
 */
public class Mostrador {
    
    private Cola mostrador = new Cola();
    private int limite = 10;
    private int cantActual = 0;
    private Lock mutex = new ReentrantLock();
    private Condition espera = mutex.newCondition();
    
    public void ponerPastel(int torta) throws InterruptedException{
        mutex.lock();
        try{
            if(limite == cantActual)
                espera.await();
            
            if(cantActual == 0)
                espera.signalAll();
            
            mostrador.poner(torta);
            cantActual++;
        }
        finally{
            mutex.unlock();
        }
    }
    
    public int tomarPastel() throws InterruptedException{
        mutex.lock();
        try{
            System.out.println("Toma Torta Que esta ganando la carrera imaginaria en el mostrador");
            if(cantActual == 0)
                espera.await();
                
            int torta = (int) mostrador.obtenerFrente();
            mostrador.sacar();
            
            if(limite == cantActual)
                espera.signalAll();
                
            cantActual--;
            return torta;
        }
        finally{
            mutex.unlock();
        }
    }
}
