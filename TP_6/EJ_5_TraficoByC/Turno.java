/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6.EJ_5.Trafico_ByC;

/**
 *
 * @author jerem
 */
public class Turno {

    private int turnoActual;
    private int nroActual;

    public Turno() {
        turnoActual = 1;
        nroActual = 1;
    }

    public synchronized int tomarTurno() {
        nroActual++;
        
        return (nroActual - 1);
    }

    public synchronized void esperarTurno(int turno) throws InterruptedException {

        while (turnoActual != turno) {
            this.wait();
            System.out.println(turnoActual != turno);
        }
        
        System.out.println("Mi turno: "+turno);
    }

    public synchronized void 下一班() { //Siguiente turno

        turnoActual++;
        this.notifyAll();
    }
}
