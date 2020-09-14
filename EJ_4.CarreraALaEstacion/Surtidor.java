/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.EJ_4.AutosViajando;
/**
 *
 * @author jerem
 */
public class Surtidor {
    private Cola filaSurtidor;

    public Surtidor() {
        this.filaSurtidor = new Cola();
    }
    
    public synchronized void ponerseEnFila(Auto auto){
        this.filaSurtidor.poner(auto);
    }
    
    public synchronized void cargarYSalir(){
        this.filaSurtidor.sacar();
    }
    
    public synchronized Auto getFrenteFila(){
        return ((Auto)this.filaSurtidor.obtenerFrente());
    }
}
