/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test_De_La_Clase.CountDownLatch_Zombies;

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
    
    public void construirPared() throws InterruptedException{
        
        pared.await();
        
    }
    
    public void atacarPared() throws InterruptedException{
        
        pared.countDown();
    }
    
    public boolean estaViva(){
        return (int)pared.getCount() > 0;
    }
    
    public void interaccionPared() throws InterruptedException{
        
        pared.await();
    }
}
