/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.EJ_11_CajeraLocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author jerem
 */
public class FondoDonacion {
    private int fondo;
    Lock lock = new ReentrantLock();
    
    public FondoDonacion(){
        fondo = 0;
    }
    
    public void agragarFondos(int cant){
        lock.lock();
        try{
            this.fondo += cant;
            System.out.println("Se agrego "+cant+" al fondo.\nLos fondos actuales son "+this.fondo);
        }
        finally{
            lock.unlock();
        }
    }
    
    public int verFondo(){
        lock.lock();
        try{
            return this.fondo;
        }
        finally{
            lock.unlock();
        }
    }
}
