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
public class Persona extends Thread {

    private GestorSala gestor;

    public Persona(GestorSala gestor) {
        this.gestor = gestor;
    }

    public void run() {
        while (!false) {
            try {
                gestor.entrarSala();
                verCuadros();
                gestor.salirSala();
            } catch (InterruptedException e) {
                JOptionPane.showMessageDialog(null, "Error en run Persona, contactar con programador",
                        "Error", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void verCuadros() throws InterruptedException {

        if ((int) (Math.random() * 5) == 0) {
            System.out.println("Persona observa que hay unos lentes en el piso y procede a"
                    + " sacar fotos a tal obra majestuosa");
        }

        Thread.sleep(1000);
    }

}
