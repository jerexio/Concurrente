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
public class Silla {
    
    private Lock mutexSilla = new ReentrantLock();
    
    public boolean intentarOcupar(){
        return mutexSilla.tryLock();
    }
    
    public void levantarse(){
        mutexSilla.unlock();
    }
}
