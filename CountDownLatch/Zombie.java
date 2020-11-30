/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test_De_La_Clase.CountDownLatch_Zombies;

import javax.swing.JLabel;

/**
 *
 * @author jerem
 */
public class Zombie extends Thread{
    
    private Pared pared;
    private String nombre;
    private int golpes;
    
    public Zombie(Pared pared, String nom, int golpes){
        this.pared = pared;
        this.nombre = nom;
        this.golpes = golpes;
    }
    
    public void run(){
        try {
            for(int i = 0; i < golpes; i++){
                pared.atacarPared(nombre);
                Thread.sleep(1000);
            }
            
            System.out.println(nombre+" Atacar");
        } catch (InterruptedException ex) {
        }
    }
}
