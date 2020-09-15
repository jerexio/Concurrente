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
/*
 * Se implemento con un arreglo para evitar
 * que los conductores se robaran los lugares entre si
*/
    private Auto[] fila;
    private int posInicial;
    private int posFinal;
    
    public Surtidor(int cantPos) {
        this.fila = new Auto[cantPos];
        this.posFinal = 0;
        this.posInicial = 0;
    }
    
    public synchronized void ponerseEnFila(Auto auto){
        System.out.println(Thread.currentThread().getName() +
                " Llega y se detiene en la estacion");
        
        this.fila[posFinal] = auto;
        this.actualizarFinal();
    }
    
    public synchronized void cargarYSalir(){
        this.fila[this.posInicial] = null;
        this.actualizarInicio();
    }
    
    private void actualizarFinal(){
        
        if(this.posFinal + 1 >= 5)
            this.posFinal = 0;
        else
            this.posFinal++;
    }
    
    private void actualizarInicio(){
        
        if(this.posInicial + 1 >= 5)
            this.posInicial = 0;
        else
            this.posInicial++;
    }
    
    public synchronized Auto verFrente(){
        return this.fila[this.posInicial];
    }
}

