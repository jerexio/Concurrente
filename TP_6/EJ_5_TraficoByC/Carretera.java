/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6.EJ_5.Trafico_ByC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 *
 * @author jerem
 */
public class Carretera extends JFrame {
    
    private JLabel fondo;
    private final int ANCHO = 1000,
                      ALTO = 400;
    private JButton botonInicio;
    
    public Carretera(int cantNorte, int cantSur){
        super("Cruzar Puente");
        
        getContentPane().setLayout(null); //Para definir un sistema de capas, no nos interesa
        
        crearFondo();
        
        crearBotonInicio(cantNorte, cantSur);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(0, 0, ANCHO, ALTO);
        setVisible(true);
    }
    
    /**
     * Crea el fondo, para asegurar que sea el fondo debe tener el mismo tamaño
     * que la ventana.
     */
    private void crearFondo(){
        fondo = new JLabel();
        getContentPane().add(fondo);
        fondo.setIcon(new ImageIcon("C:\\Users\\jerem\\Documents\\NetBeansProjects\\Prog.Concurrente2020\\src\\test\\java\\TP6\\EJ_5\\Trafico\\Fondo.png"));
        fondo.setBounds(0, 0, 1000, 400);
    }
    
    private void crearBotonInicio(int cantNorte, int cantSur){
        
        ImageIcon imagenBoton = new ImageIcon("C:\\Users\\jerem\\Documents\\NetBeansProjects\\Prog.Concurrente2020\\src\\test\\java\\TP6\\EJ_5\\Trafico\\Boton.png");
        Icon iconoBoton = new ImageIcon(imagenBoton.getImage().getScaledInstance(50, 50, 1));
        
        botonInicio = new JButton("FIUUUM");
        //botonInicio.setBorderPainted(false);
        //botonInicio.setOpaque(false);
        //botonInicio.setContentAreaFilled(false);
        fondo.add(botonInicio);
        //botonInicio.setVisible(true);
        botonInicio.setBounds(0, 0, 50, 50);
        botonInicio.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {               
                System.out.println("Que inicie el cruce");
                
                Puente puente = new Puente();
                AutoSur[] aSur = new AutoSur[cantSur];
                AutoNorte[] aNorte = new AutoNorte[cantNorte];
                int totalHilos = cantNorte + cantSur;
                Thread[] hilos = new Thread[totalHilos];
        
        
                for(int i = 0; i < cantSur; i++){
                    aSur[i] = new AutoSur(ANCHO - 160, -100, fondo, puente);
                    hilos[i] = new Thread(aSur[i]);
                }
                
                for(int i = 0; i < cantNorte; i++){
                    aNorte[i] = new AutoNorte(50, ANCHO + 200, fondo, puente);
                    hilos[(totalHilos-1)-i] = new Thread(aNorte[i]);
                }

                for(int i = 0; i < totalHilos; i++){
                    hilos[i].start();
                }
            }
        });
        
    }
}
