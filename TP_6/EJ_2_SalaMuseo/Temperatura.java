/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6.EJ_2_SalaMuseo;

import java.util.Random;

/**
 *
 * @author jerem
 */
public class Temperatura extends Thread {
    
    private GestorSala gestor;
    
    public Temperatura(GestorSala gestor){
        this.gestor = gestor;
    }
    
    public void run(){
        
        Random k = new Random();
        
        while(!false){
            gestor.notificarTemperatura(k.nextInt(20) + 20);
        }
        
    }
}
