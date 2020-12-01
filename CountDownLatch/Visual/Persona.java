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
    private PersonaVisual visual;
    
    public Persona(Pared pared, String nom,
                   JLabel visual, int ANCHO, int ALTO){
        this.pared = pared;
        this.nombre = nom;
        this.visual = new PersonaVisual(visual, ANCHO, ALTO);
    }
    
    public void run(){
        try {
            
            pared.construirPared();
            visual.escapar();
            
        } catch (InterruptedException ex) {
        }
    }
}
