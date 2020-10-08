/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.EJ_13_BarsitoEnPolleria;


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
        while(true){
            confiteria.tomarOrden();
            prepararBebida();
            confiteria.recibirComidaMozo();
            confiteria.entregarComida();
            confiteria.inventarBebidas();
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
}
