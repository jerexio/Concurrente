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
public class Main {

    public static void main(String[] args) {
        
        Impresion[] imp = new Impresion[3];
        SelectorTurno turno = new SelectorTurno();
        
        for (int i = 0; i <= 2; ++i) {
            imp[i] = new Impresion(new Letra((char) (i + 65), i+1), turno);
        }

        imp[0].start();
        imp[1].start();
        imp[2].start();
    }
}