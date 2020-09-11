/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.EJ_3.Letras;

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
                
        synchronized (letra) {
            int cant = (int) letra.getLetra();

            for (int i = 64; i < cant; i++) {
                System.out.print(letra.getLetra());
            }
        }
    }
}