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
    private SelectorTurno turno;

    public Impresion(Letra letra, SelectorTurno turno) {
        this.letra = letra;
        this.turno = turno;
    }

    public void run() {
        
        while(this.turno.esMiTurno(this.letra.getTurno())){}
        
        synchronized (turno) {
            int cant = (int) letra.getLetra();

            for (int i = 64; i < cant; i++) {
                System.out.print(letra.getLetra());
            }
            
            this.turno.actualizar();
        }
    }
}
