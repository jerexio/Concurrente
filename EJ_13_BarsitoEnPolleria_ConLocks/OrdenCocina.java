/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.EJ_13_BarsitoEnPolleria_ConLocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author jerem
 */
public class OrdenCocina {
    
    private String ordenCocina;
    private String ordenCocinada;
    private Lock mutexCocina = new ReentrantLock();
    private Lock mutexMozo = new ReentrantLock();
    
    public String cocinarOrden(){
        mutexCocina.lock();
        mutexMozo.lock();
        try{
            String orden = ordenCocina;
            
            ordenCocina = null;
            return orden;
        }
        finally{
            mutexCocina.unlock();
        }
    }
    
    public void ponerOrden(String orden){
        mutexCocina.lock();
        try{
            this.ordenCocina = orden;
        }
        finally{
            mutexCocina.unlock();
        }
    }
    
    public void entregarOrden(String orden){
        this.ordenCocinada = orden;
        mutexMozo.unlock();
    }
    
    public boolean hayOrdenPorCocinar(){
        return (!ordenCocina.isEmpty());
    }
    public boolean hayOrdenCocinada(){
        
        return (!ordenCocinada.isEmpty());
    }
}
