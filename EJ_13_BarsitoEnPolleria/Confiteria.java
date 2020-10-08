/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.EJ_13_BarsitoEnPolleria;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author jerem
 */
public class Confiteria {
    
    /**
     * Soy una confiteria, aca se organiza como van a ser las comunicaciones
     * entre los hilos Empleados, Mozo y cocinero.
     */
    
    private Semaphore semEmpleado = new Semaphore(0, true);
    private Semaphore semMozo = new Semaphore(0, true);
    private Semaphore semCocinero = new Semaphore(0, true);
    private Semaphore semBar = new Semaphore(1, true);
    
    
    /**
     * Cosas que hace el Empleado.
     */
    public boolean puedoIngresar(){
        return (semBar.tryAcquire());
    }
    
    public void ordenar(String nombre){
        try{
            System.out.println(nombre + ": \"Me gustaria probar la especialidad de la casa\"");
            semMozo.release();
            semEmpleado.acquire();
        }
        catch(InterruptedException e){
        }
    }
    
    public void recibirComida(String nombre){
        System.out.println(nombre +": \"Gracias por la comida\"");
        semMozo.release();
    }
    
    public void salir(String nombre){
        System.out.println(nombre+ " termino de comer y se esta yendo");
        semBar.release();
    }
    
    
    /**
     * Cosas que hace el Mozo.
     */
    public void tomarOrden(){
        try{
            semMozo.acquire();
            System.out.println("Mozo: \"Aguarde un momento\"");
            System.out.println("Mozo: \"Cocinero hay una orden nueva\"");
            semCocinero.release();
        }
        catch(InterruptedException e){
        }
    }
    
    public void recibirComidaMozo(){
        try {
            semMozo.release();
            semCocinero.acquire();
            System.out.println("Mozo: \"Esto se ve muy bueno\"");
            semCocinero.release();
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Confiteria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void entregarComida(){
        System.out.println("Mozo: \"Su comida y bebida señor\"");
        semEmpleado.release();
        
    }
    
    public void inventarBebidas(){
        try {
            
            semMozo.acquire();
            System.out.println("Mozo: \"Mmm...Si mezclo mirra, ruibarbo, manzanilla, cardamomo, orégano y azafrán\"");
            System.out.println("Mozo: \"Pues te voy a llamar fernet\"");
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Confiteria.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    
    /**
     * Cosas que hace cocinero.
     */
    public void recibirOrden(){
        try{
            semCocinero.acquire();
            System.out.println("Cocinero: \"Okey, ya lo cocino\"");
        }
        catch(InterruptedException e){
        }
    }
    
    public void terminarComida(){
        try {
            
            semMozo.acquire();
            System.out.println("Cocinar: \"Ya termine de cocinar\"");
            semCocinero.release();
        
        } catch (InterruptedException ex) {
            Logger.getLogger(Confiteria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void inventarComidas(){
        try{
            semCocinero.acquire();
            System.out.println("Cocinero: \"A inventar Pollos\"");
        }
        catch(InterruptedException e){
        }
    }
}
