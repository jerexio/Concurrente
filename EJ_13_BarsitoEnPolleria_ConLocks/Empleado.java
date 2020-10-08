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
public class Empleado implements Runnable {
    
    private Confiteria confiteria;
    
    public Empleado(Confiteria confiteria){
        this.confiteria = confiteria;
    }
    
    public void run(){
        
        if(confiteria.puedoIngresar()){
            confiteria.ordenar(Thread.currentThread().getName());
            confiteria.recibirComida(Thread.currentThread().getName());
            //Comer
        }
    }
}
