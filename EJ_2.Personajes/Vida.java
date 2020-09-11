/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.EJ_2.Personajes;

/**
 *
 * @author jerem
 */
public class Vida {
    private int cant = 10;

    public Vida() {
    }

    public int obtenerVida(){
        return this.cant;
    }
    
    public void actualizarVida(int vidaActual){
        this.cant = vidaActual;
    }

    public synchronized void modificarVida(int modif){
        this.cant = this.cant + modif;
    }
}