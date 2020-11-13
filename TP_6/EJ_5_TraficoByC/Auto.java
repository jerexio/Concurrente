/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6.EJ_5.Trafico_ByC;

import javax.swing.JOptionPane;

/**
 *
 * @author jerem
 */
public abstract class Auto {
    
    protected Puente puente;
    
    public Auto(Puente puente){
        this.puente = puente;
    }
    
    public void run(){
        try{
            cruzar();
        }
        catch(InterruptedException e){
            JOptionPane.showMessageDialog(null, "Un auto se metio con el ADMIN y desparecio del camino",
                    "Interrupted Exception", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    abstract void cruzar() throws InterruptedException;
}
