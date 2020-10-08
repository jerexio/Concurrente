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
public class Rueda {

    Lock lockRueda = new ReentrantLock();

    public Rueda() {
    }

    public synchronized void correrEnLaRueda(String nombre) {

        lockRueda.lock();

        try {
            System.out.println(nombre + " Correra en la rueda");
            
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ignore) {
                System.err.println("APA!, parece que hay que conseguir otro hamster");
            }

            System.out.println(nombre + " Uuff, toy cansado");
            
        } finally {
            lockRueda.unlock();
        }
    }
}
