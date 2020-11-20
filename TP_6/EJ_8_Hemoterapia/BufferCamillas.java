/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6.EJ_8_Hemoterapia;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author jerem
 */
public class BufferCamillas {

    private int camasLibres = 4;

    private Lock mutexCamillas = new ReentrantLock();
    private Condition camaLibre = mutexCamillas.newCondition();
    
    public boolean tomarCamilla() {
        mutexCamillas.lock();

        boolean camilla = false;
        try {
            if (camasLibres > 0) {
                camilla = true;
                
                camasLibres--;
            }
            return camilla;
        } finally {
            mutexCamillas.unlock();
        }
    }
    
    public void salir() throws InterruptedException {
        mutexCamillas.lock();
        try {
            camasLibres++;

            camaLibre.signal();
        } finally {
            mutexCamillas.unlock();
        }
    }
    
    
    
    public void verficarCamaLibre() throws InterruptedException {
        mutexCamillas.lock();
        try {
            
            while(camasLibres == 0){
                camaLibre.await();
            }
            
        } finally {
            mutexCamillas.unlock();
        }
    }
}
