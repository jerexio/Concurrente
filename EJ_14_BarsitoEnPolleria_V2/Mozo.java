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
public class Mozo implements Runnable {
    
    private Confiteria[] confiteria;
    
    public Mozo(Confiteria[] confiteria){
        this.confiteria = confiteria;
    }
    
    public void run(){
        int mesa = (int) (Math.random() * 2);
        
        while(true){
            
            if(confiteria[mesa].tomarOrdenbebida()){
                prepararBebida();
                confiteria[mesa].entregarBebida();
            }
            
            if(confiteria[mesa].tomarOrdenComida()){
                confiteria[mesa].recibirComidaMozo();
                confiteria[mesa].entregarComida();
            }
            
            //confiteria[mesa].inventarBebidas();
            mesa = actualizarMesa(mesa);
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
    
    private int actualizarMesa(int num){
        if(num == 1)
            num = 0;
        else
            num = 1;
        
        return num;
    }
}
