/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test_De_La_Clase.CountDownLatch_Zombies;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author jerem
 */
public class Animacion extends JFrame {

    private JLabel fondo;
    private final int ANCHO = 1200,
            ALTO = 800;
    private JButton botonInicio;

    public Animacion(int personas, int zombies, int golpes, int resistencia) {
        super("Zombie");

        getContentPane().setLayout(null); //Para definir un sistema de capas, no nos interesa

        fondo = new JLabel();
        getContentPane().add(fondo);
        fondo.setBounds(0, 0, ANCHO, ALTO);
        
        crearBotonInicio(personas, zombies, golpes, resistencia);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(0, 0, ANCHO, ALTO);
        setVisible(true);

    }

    private void crearBotonInicio(int personas, int zombies, int golpes, int resistencia) {

        botonInicio = new JButton("START");
        fondo.add(botonInicio);
        botonInicio.setVisible(true);
        botonInicio.setBounds(0, 0, 100, 50);
        botonInicio.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                Pared p = new Pared(resistencia);
                
                for (int i = 0; i < personas; i++) {
                    new Persona(p, "P__" + i, fondo, ANCHO, ALTO).start();
                }

                for (int i = 0; i < zombies; i++) {
                    new Zombie(p, "Z__" + i, golpes, fondo, ANCHO, ALTO).start();
                }
                
                new ParedVisual(p, fondo, ANCHO).start();
            }
        });

    }
}
