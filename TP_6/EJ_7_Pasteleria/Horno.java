/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6.EJ_7_Pasteleria;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jerem
 */
public abstract class Horno extends Thread {
    
    protected Mostrador most;

    public Horno(Mostrador most) {
        this.most = most;
    }
    
    public void run(){
        try {
            while(true){
                ponerPastel();
                Thread.sleep((int) Math.random()*4000);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Horno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    abstract void ponerPastel() throws InterruptedException;
}
