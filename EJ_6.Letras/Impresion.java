/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.EJ_6.Letras;

/**
 *
 * @author jerem
 */
public class Impresion extends Thread {

    private Letra letra;

    public Impresion(Letra letra) {
        this.letra = letra;
    }

    public void run() {
        //El run solo llama a esto
        this.letra.imprimir();
    }
}
