/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.EJ_14_BarsitoEnPolleria_V2;

/**
 *
 * @author jerem
 */
public class Cocinero implements Runnable {
    
    private Confiteria confiteria;
    
    public Cocinero(Confiteria confiteria){
        this.confiteria = confiteria;
    }
    
    public void run(){
        
        while(true){
            confiteria.recibirOrden();
            confiteria.terminarComida();
            confiteria.inventarComidas();
        }
    }
    
    private void cocinar(){
        try{
            System.out.println("Sonidos de parrilla");
            Thread.sleep(2500);
        }
        catch(InterruptedException e){
            System.err.println("Al parecer se incedio la cocina");
        }
    }
}
