/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6.EJ_7_Pasteleria;

/**
 *
 * @author jerem
 */
public class HornoA extends Horno{
    
    private static int peso = 30;
    
    public HornoA(Mostrador most) {
        super(most);
    }
    
    void ponerPastel() throws InterruptedException{
        most.ponerPastel(peso);
    }
}
