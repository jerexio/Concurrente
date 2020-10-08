/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.EJ_13_BarsitoEnPolleria_ConLocks;

import TP4.EJ_13_BarsitoEnPolleria_ConLocks.Confiteria;

/**
 *
 * @author jerem
 */
public class Mozo implements Runnable {
    
    private Confiteria confiteria;
    
    public Mozo(Confiteria confiteria){
        this.confiteria = confiteria;
    }
    
    public void run(){
        confiteria.inventarBebidas();
        confiteria.tomarOrden();
        confiteria.recibirComidaMozo();
        confiteria.entregarComida();
    }
}
