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
public class AutoSur extends Auto implements Runnable {
    
    private AutoSurVisual autoV;
    
    public AutoSur(int posIni, int limite, JLabel label, Puente puente, Turno turno){
        super(puente, turno);
        autoV = new AutoSurVisual(posIni, limite, label);
    }
    
    @Override
    public void cruzar() throws InterruptedException {
        autoV.llegar();
        
        puente.entrarCocheDelSur();
        int nro = turno.tomarTurno();
        turno.esperarTurno(nro);
        
        autoV.manejarPrimera();
        turno.下一班();
        autoV.manejarSegunda();
        puente.salirCocheDelSur();
    }
}
