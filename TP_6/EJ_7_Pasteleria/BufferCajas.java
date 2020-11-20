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
public class BufferCajas {
    
    private boolean fullBox = false; //Seguro de vida, que pasa si la caja esta llena pero el brazo no entro a esperar
    private boolean otraCaja = true; //Pudo entrar la otra caja?
    private Caja caja = new Caja(100, 0);
    private Lock mutexCaja = new ReentrantLock();
    private Condition cajaLlena = mutexCaja.newCondition();
    private Condition esperarCaja = mutexCaja.newCondition();
    
    public void ponerPastel(int torta) throws InterruptedException {
        mutexCaja.lock();
        try{
            
            System.out.println("Pues voy a dejar mi torta, ");
            if(!caja.ponerPastel(torta)){
                System.out.println("No hay lugar");
                if(otraCaja){
                    System.out.println("A esperar al siguiente");
                    otraCaja = false;
                    esperarCaja.await();
                    caja.ponerPastel(torta);
                    otraCaja = true;
                }
                else{
                    System.out.println("Soy el siguiente y no habia lugar");
                    fullBox = true;
                    cajaLlena.signal();
                    esperarCaja.await();
                    caja.ponerPastel(torta);
                    fullBox = false;
                }
            }
        }
        finally{
            mutexCaja.unlock();
        }
    }
    
    public Caja retirarCaja() throws InterruptedException {
        mutexCaja.lock();
        try{
            if(!fullBox)
                cajaLlena.await();
            
            Caja ret = caja;
            
            caja = new Caja(100, 0);
            
            esperarCaja.signalAll();
            return ret;
        }
        finally{
            mutexCaja.unlock();
        }
    }
}
