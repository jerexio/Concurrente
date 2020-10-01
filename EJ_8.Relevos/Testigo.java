/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.EJ_8.Relevos;

import java.util.concurrent.Semaphore;
/**
 *
 * @author jerem
 */
public class Testigo {
    
    private Semaphore semTestigo = new Semaphore(1, true);

    public void tomarTestigo(){
        try{
            semTestigo.acquire();
        }
        catch(InterruptedException ignore){
            System.out.println("Se cayo el testigo");
        }
    }
    
    public void entregarTestigo(){
        semTestigo.release();
    }
}
