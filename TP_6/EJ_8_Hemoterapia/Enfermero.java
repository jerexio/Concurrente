/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6.EJ_8_Hemoterapia;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jerem
 */
public class Enfermero extends Thread {

    private BufferCamillas bCamas;
    private SalaEspera sala;

    public Enfermero(BufferCamillas bCamas, SalaEspera sala) {
        this.bCamas = bCamas;
        this.sala = sala;
    }

    public void run() {
        try {
            while (true) {
                bCamas.verficarCamaLibre();
                sala.notificarCama();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
