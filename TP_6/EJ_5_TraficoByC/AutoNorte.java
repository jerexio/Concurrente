/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6.EJ_5.Trafico_ByC;

import javax.swing.JLabel;

/**
 *
 * @author jerem
 */
public class AutoNorte extends Auto implements Runnable {
    
    private AutoNorteVisual autoV;
    
    public AutoNorte(int posIni, int limite, JLabel label, Puente puente) {
        super(puente);
        autoV = new AutoNorteVisual(posIni, limite, label);
    }
    
    @Override
    public void cruzar() throws InterruptedException {
        autoV.llegar();
        puente.entrarCocheDelNorte();
        autoV.manejar();
        puente.salirCocheDelNorte();
    }
}
