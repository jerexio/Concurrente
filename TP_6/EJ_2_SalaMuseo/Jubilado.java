/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6.EJ_2_SalaMuseo;

import javax.swing.JOptionPane;

/**
 *
 * @author jerem
 */
public class Jubilado extends Thread {

    private GestorSala gestor;

    public Jubilado(GestorSala gestor) {
        this.gestor = gestor;
    }

    public void run() {
        while (!false) {
            try {
                gestor.entrarSalaJubilado();
                Thread.sleep(1000);
                gestor.salirSala();
            } catch (InterruptedException e) {
                JOptionPane.showMessageDialog(null, "Error en run del Jubilado, contactar con programador",
                        "Error", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

}
