/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test_De_La_Clase.CountDownLatch_Zombies;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
/**
 *
 * @author jerem
 */
public class Pared {
    
    private CountDownLatch pared;
    
    public Pared(int zombies){
        pared = new CountDownLatch(zombies);
    }
    
    public void construirPared(String nombre) throws InterruptedException{
        
        if(pared.getCount() > 0)
            pared.await();
        
        System.out.println(nombre+" Correr");
    }
    
    public void atacarPared(String nombre) throws InterruptedException{
        
        System.out.println(nombre+" Tirar pared");
        pared.countDown();
        System.out.println("Pared: "+pared.getCount());
    }
}
