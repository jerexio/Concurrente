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
public class Personaje implements Runnable {

    private int cantHabilidad;
    private final Vida vida;

    public Personaje(int cantHabilidad, Vida vida) {
        this.cantHabilidad = cantHabilidad;
        this.vida = vida;
    }

    public int getModificador() {
        return cantHabilidad;
    }

    public void setModificador(int cantHabilidad) {
        this.cantHabilidad = cantHabilidad;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " Hace " + this.cantHabilidad + " Puntos.");
        synchronized (vida) {
            this.vida.actualizarVida(this.vida.obtenerVida() - this.cantHabilidad);

            System.out.println("Esta es tu vida restante: " + this.vida.obtenerVida());
            //vida.modificarVida(cantHabilidad);
        }
    }
}