/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6.EJ_7_Pasteleria;

/**
 *
 * @author jerem
 */
public class Brazo extends Thread {

    private BufferCajas bCajas;
    private Caja[] cajasCamion = new Caja[100];
    private int posActual = 0;

    public Brazo(BufferCajas bCajas) {
        this.bCajas = bCajas;
    }

    public void run() {
        while (true) {
            try {
                cajasCamion[posActual] = bCajas.retirarCaja();
                posActual++;
                if(posActual == 100){
                    cajasCamion = new Caja[100];
                    posActual = 0;
                }
                Thread.sleep((int) Math.random()*2000);
            } catch (InterruptedException e) {

            }
        }
    }
}
