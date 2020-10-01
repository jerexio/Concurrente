/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.EJ_8.Relevos;

/**
 *
 * @author jerem
 */
public class Atleta implements Runnable {
    
    /*
     * Dos posibilidades de implementacion:
     * - Simular corredores que toman y entregan el testigo
     * - Asignar posciones y simular las posiciones de salida
     */
    
    private Pista carrera;

    public Atleta(Pista carrera) {
        this.carrera = carrera;
    }
    
    public void run(){
        carrera.correr();
    }
}
