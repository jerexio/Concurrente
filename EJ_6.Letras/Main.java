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
public class Main {

    public static void main(String[] args) {
        
        Impresion[] imp = new Impresion[3];
        Printear print = new Printear();
        
        for (int i = 0; i <= 2; ++i) {
            imp[i] = new Impresion(new Letra((char) (i + 65), i+7, print));
        }

        imp[0].start();
        imp[1].start();
        imp[2].start();
    }
}