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
public class Persona extends Thread{
    
    private Pared pared;
    private String nombre;
    
    public Persona(Pared pared, String nom){
        this.pared = pared;
        this.nombre = nom;
    }
    
    public void run(){
        try {
            
            pared.construirPared(nombre);
            
            
            //pared.construirPared(nombre);
        } catch (InterruptedException ex) {
        }
    }
}
