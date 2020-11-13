/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6.EJ_2_SalaMuseo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author jerem
 */
public class GestorSala {

    private int lugares;
    private int maximo = 50;
    private Lock lockLugar = new ReentrantLock();
    private int tUmbral = 30;

    public synchronized void entrarSala() throws InterruptedException {

        while (lugares > maximo) {
            this.wait();
        }

        lockLugar.lock();
        try {
            lugares++;
        } finally {
            lockLugar.unlock();
        }

    }
// se invoca cuando una persona quiere entrar en la sala.

    private Object jubilado = new Object();

    public void entrarSalaJubilado() throws InterruptedException {

        synchronized (jubilado) {
            while (lugares > maximo) {
                jubilado.wait();
            }

            lockLugar.lock();
            try {
                lugares++;
            } finally {
                lockLugar.unlock();
            }
        }
    }
// se invoca cuando una persona jubilada quiere entrar en la sala.

    public void salirSala() {

        lockLugar.lock();
        try {
            lugares--;
        } finally {
            lockLugar.unlock();
        }
        jubilado.notify();
        this.notify();
    }
// se invoca cuando una persona, jubilada o no, quiere salir de la sala.

    public void notificarTemperatura(int temperatura) {

        if (temperatura >= tUmbral) {
            maximo = 35;
        } else {
            maximo = 50;
        }
    }
// lo invoca la hebra que mide la temperatura de la sala para indicar el último valor medido.
}
