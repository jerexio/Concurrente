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
public class HornoB extends Horno {
    
    private static int peso = 20;
    
    public HornoB(Mostrador most) {
        super(most);
    }
    
    void ponerPastel() throws InterruptedException {
        most.ponerPastel(peso);
    }
}
