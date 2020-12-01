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
    private ZombieVisual visual;
    
    public Zombie(Pared pared, String nom, int golpes,
                  JLabel visual, int ANCHO, int ALTO){
        this.pared = pared;
        this.nombre = nom;
        this.golpes = golpes;
        this.visual = new ZombieVisual(visual, ANCHO, ALTO);
    }
    
    public void run(){
        try {
            
            visual.encontrarHumano();
            while(pared.estaViva()){
                pared.atacarPared();
                visual.ataque();
                Thread.sleep(100);
            }
            visual.perseguirHumano();
            
        } catch (InterruptedException ex) {
        }
    }
}
