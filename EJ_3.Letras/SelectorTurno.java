/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.EJ_3.Letras;

/*
 *
 * @author jerem
 */
public class SelectorTurno {
    private int turnoActual;

    public SelectorTurno() {
        this.turnoActual = 1;
    }
    
    public synchronized void reset(){
        if(this.turnoActual > 3)
            this.turnoActual = 1;
    }
    
    public synchronized int getTurnoActual(){
        return this.turnoActual;
    }
    
    public synchronized void actualizar(){
        this.turnoActual = this.turnoActual + 1;
    }
}