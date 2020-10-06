/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test_De_La_Clase.Barbero;

/**
 *
 * @author jerem
 */
public class Barbero extends Thread {
    
    /**
     * Soy un barbero, tecnicamente afeito barbas, pero solo por hoy corto el pelo.
     */
    
    private Barberia barberia;
    
    public Barbero(Barberia barberia){
        this.barberia = barberia;
    }
    
    public void run(){
        
        /**
         * La barberia en un horario se cierra, en ese horario dejan de entrar clientes
         * por eso el barbero cierra cuando ya no quedan clientes
         */
        boolean estaAbierto = true;
        
        while(estaAbierto){
            
            barberia.atender();
            trabajar();
            barberia.cobrar();
            barberia.descansar();
            
            estaAbierto = barberia.quedanClientes();
        }
        
        barberia.cerrarBarberia();
    }
    
    private void trabajar(){
        System.out.println("Se escuchan sonidos de una barberia");
        
        try{
            int random = (int) (Math.random() * 10) + 1;
            
            Thread.sleep(1000 * random);
        }
        catch(InterruptedException ignore){
            System.err.println("Al parecer al barbero se le escapo la maquina, y te dejo calvo. Tu pelo volvera a crecer");
        }
    }
}
