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
public class Comida {

    private Lock lockComida = new ReentrantLock();

    public Comida() {
    }

    public void comer(String nombre) {

        lockComida.lock();
        try {
            System.out.println(nombre + " Comera comida");
            
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ignore) {
                System.err.println("El hamster ha sido eliminado por la comida");
            }

            System.out.println(nombre + " Mmm...Que buena comida comible");
            
        } finally {
            lockComida.unlock();
        }
    }
}
