/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.EJ_14_BarsitoEnPolleria_V2;

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
    private Semaphore mutexVerifCliente = new Semaphore(1, true);
    private int numBebida = -1;
    private int numComida = -1;
    
    /**
     * Cosas que hace el Empleado.
     */
    public boolean puedoIngresar(){
        return (semBar.tryAcquire());
    }
    
    public boolean deseaBebida(){
        
        numBebida = (int)(Math.random() * 2 + 1);
        
        boolean desea = (numBebida != (2+1));
        
        if(!desea)
            numBebida = -1;
        
        return desea;
    }
    
    public void ordenarBebida(String nombre){
        
        try {
            
            System.out.println(nombre+ ": \"Me gustaria probar su mejor bebida\"");
            semMozo.release();
            semEmpleado.acquire();
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Confiteria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void recibirBebida(String nombre){
        System.out.println(nombre +": \"Gracias por la bebida\"");
        semMozo.release();
    }
    
    public boolean deseaComida(){
        
        numComida = (int)(Math.random() * 2 + 1);
        
        boolean desea = (numComida != (2+1));
        
        return desea;
    }
    
    public void ordenarComida(String nombre){
        try{
            System.out.println(nombre + ": \"Me gustaria probar la especialidad de la casa\"");
            semCocinero.release();
            semEmpleado.acquire();
        }
        catch(InterruptedException e){
        }
    }
    
    public void recibirComida(String nombre){
        System.out.println(nombre +": \"Gracias por la comida\"");
        semCocinero.release();
    }
    
    public void salir(String nombre){
        System.out.println(nombre+ " termino de comer y se esta yendo");
        semBar.release();
    }
    
    
    /**
     * Cosas que hace el Mozo.
     */
    public boolean hayCliente(){
        try {
            mutexVerifCliente.acquire();
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Confiteria.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Si no hay cliente voy a poder tomar el semaforo
        boolean hayCliente = semBar.tryAcquire();
            
        if(hayCliente){
            semBar.release();
        }
        mutexVerifCliente.release();
            
            
       return hayCliente;
    }
    
    public void tomarOrden(){
        try{
            semMozo.acquire();
            System.out.println("Mozo: \"Aguarde un momento\"");
        }
        catch(InterruptedException e){
        }
    }
    
    public void entregarBebida(){
        System.out.println("Mozo: \"Su bebida esta lista\"");
        semEmpleado.release();
    }
    
    public void inventarBebidas(){
        try {
            
            semMozo.acquire();
            System.out.println("Mozo: \"Mmm...Si mezclo mirra, ruibarbo, manzanilla, cardamomo, orégano y azafrán\"");
            System.out.println("Mozo: \"Pues te voy a llamar fernet\"");
            
            Thread.sleep(2500);
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
        
        System.out.println("Cocinar: \"Ya termine de cocinar\"");
        semEmpleado.release();
    }
    
    public void inventarComidas(){
        try{
            semCocinero.acquire();
            System.out.println("Cocinero: \"A ordenar\"");
            Thread.sleep(2500);
        }
        catch(InterruptedException e){
        }
    }
}
