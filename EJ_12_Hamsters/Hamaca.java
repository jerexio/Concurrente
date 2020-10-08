/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.EJ_12_Hamsters;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author jerem
 */
public class Hamaca {

    Lock lockHamaca = new ReentrantLock();

    public Hamaca() {
    }

    public void dormir(String nombre) {
        
        lockHamaca.lock();
        try {
            System.out.println(nombre + " Duerme en la hamaca");
            
            try {
                Thread.sleep(7000);
            } catch (InterruptedException ignore) {
                System.err.println("Parece ser que el hamster se desperto antes");
            }

            System.out.println(nombre + " Que buena siesta");
            
        } finally {
            lockHamaca.unlock();
        }
    }
}
