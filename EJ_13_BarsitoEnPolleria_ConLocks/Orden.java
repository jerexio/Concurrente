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
public class Orden {
    
    private String orden;
    private Lock mutexOrden = new ReentrantLock();
    
    public String tomarOrden(){
        
        mutexOrden.lock();
        try {
            
            String unaOrden = this.orden;
            orden = null;
            return unaOrden;
            
        } finally {
            mutexOrden.unlock();
        }
    }
    
    public void setOrden(String orden){
        mutexOrden.lock();
        try {
            this.orden = orden;
        } finally {
            mutexOrden.unlock();
        }
    }
    
    public boolean hayOrden(){
        mutexOrden.lock();
        try{
            return (!orden.isEmpty());
        }
        finally{
            mutexOrden.unlock();
        }
    }
}
