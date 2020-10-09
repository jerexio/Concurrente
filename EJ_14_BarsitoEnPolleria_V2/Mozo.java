/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.EJ_14_BarsitoEnPolleria_V2;

import TP4.EJ_13_BarsitoEnPolleria.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author jerem
 */
public class Mozo implements Runnable {
    
    private Confiteria[] confiteria;
    
    public Mozo(Confiteria[] confiteria){
        this.confiteria = confiteria;
    }
    
    public void run(){
        
        int mesa = (int)(Math.random() * 2),
            mesasControladas = 0;
        
        while(true){
            
            if(!confiteria[mesa].hayCliente()){
                confiteria[mesa].tomarOrden();
                prepararBebida();
                confiteria[mesa].entregarBebida();
                mesasControladas = 0;
            }
            else{
                mesasControladas++;
            }
            
            mesa = actualizar(mesa);
            
            if(mesasControladas == 2){
                confiteria[mesa].inventarBebidas();
                mesasControladas = 0;
            }
        }
    }
    
    private void prepararBebida(){
        try{
            System.out.println("Sonidos de bartender");
            Thread.sleep(3000);
        }
        catch(InterruptedException e){
            System.err.println("Parece que esta rota la maquina de bebidas");
        }
    }
    
    private int actualizar(int num){
        
        if(num == 1)
            num = 0;
        else
            num = 1;
        
        return num;
    }
}
