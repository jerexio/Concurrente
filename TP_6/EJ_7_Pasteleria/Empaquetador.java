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
public class Empaquetador extends Thread {
    
    private int pastelActual;
    private BufferCajas bCajas;
    private Mostrador most;

    public Empaquetador(BufferCajas bCajas, Mostrador most) {
        this.bCajas = bCajas;
        this.most = most;
    }
    
    public void run(){
        while(true){
            try {
                pastelActual = most.tomarPastel();
                Thread.sleep((int) Math.random()*2000);
                bCajas.ponerPastel(pastelActual);
                Thread.sleep((int) Math.random()*3000);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Empaquetador.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
}
