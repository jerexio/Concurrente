/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.EJ_13_BarsitoEnPolleria_ConLocks;

import TP4.EJ_13_BarsitoEnPolleria_ConLocks.OrdenCocina;
import TP4.EJ_13_BarsitoEnPolleria_ConLocks.Silla;
import TP4.EJ_13_BarsitoEnPolleria_ConLocks.Orden;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 *
 * @author jerem
 */
public class Confiteria {
    
    /**
     * Soy una confiteria, aca se organiza como van a ser las comunicaciones
     * entre los hilos Empleados, Mozo y cocinero
     * 
     * Nota: Estoy probando como seria si por cada actividad hay un Lock distinto
     *       se ve medio loco pero creo que se podria usar para comprender la
     *       forma logica de las interacciones
     *       Recorda que debe ser sin bloqueos, la interaccion de entrada debe
     *       ser un intentar entrar.
     */
    
    private Silla silla;
    private Orden orden;
    private OrdenCocina ordenCocina;
    private ReentrantLock lockBar = new ReentrantLock();
            
    public Confiteria(){
        silla = new Silla();
        orden = new Orden();
        ordenCocina = new OrdenCocina();
    }
    
    
    public boolean puedoIngresar(){
        return (silla.intentarOcupar());
    }
    
    public void ordenar(String nombre){
        try{
            System.out.println(nombre + ": \"Me gustaria probar la especialidad de la casa\"");
            orden.setOrden("Comida comible");
        }
        finally{
            lockMozo.unlock();
            
            lockEmpleado.lock();
        }
    }
    
    public void recibirComida(String nombre){
        lockEmpleado.lock();
        try{
            System.out.println(nombre +": \"Gracias por la comida\"");
        }
        finally{
            lockMozo.unlock();
        }
    }
    
    public void salir(String nombre){
        System.out.println(nombre+ " termino de comer y se esta yendo");
        silla.levantarse();
    }
    
    
    
    public void tomarOrden(){
        if(orden.hayOrden()){
            String ordenActual = orden.tomarOrden();
            System.out.println("Mozo: \"Orden recibida\"");
            
            ordenCocina.ponerOrden(ordenActual);
        }
    }
    
    public void recibirComidaMozo(){
        while(!ordenCocina.hayOrdenCocinada()){
            
        }
        System.out.println("Mozo: \"Esto se ve muy bueno\"");
    }
    
    public void entregarComida(){
        System.out.println("Mozo: \"Su comida y bebida señor\"");
        lockEmpleado.unlock();
    }
    
    public void inventarBebidas(){
        while(!orden.hayOrden()){
            try {
                Thread.sleep(1500);
                System.out.println("Mozo: \"Mmm...Si mezclo mirra, ruibarbo, manzanilla, cardamomo, orégano y azafrán\"");
                System.out.println("Mozo: \"Pues te voy a llamar fernet\"");
            }
            catch(InterruptedException e){
            }
        }
    }
    
    
    
    public void recibirOrden(){
        System.out.println("Cocinero: \"Okey, ya lo cocino\"");
        ordenCocina.cocinarOrden();
    }
    
    public void terminarComida(){
        System.out.println("Cocinar: \"Ya termine de cocinar\"");
        ordenCocina.ponerOrden("Comida");
    }
    
    public void inventarComidas(){
        while(!ordenCocina.hayOrdenPorCocinar()){
            try{
                Thread.sleep(1500);
                System.out.println("Cocinero: \"Ya he inventado algo nuevo\"");
            }
            catch(InterruptedException e){
            }
        }
    }
}
