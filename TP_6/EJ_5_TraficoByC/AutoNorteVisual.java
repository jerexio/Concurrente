/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6.EJ_5.Trafico_ByC;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author jerem
 */
public class AutoNorteVisual {
    
    private int posIni;
    private int limite;
    private JLabel auto;
    private int velocidad = (int)(Math.random() * 10);

    public AutoNorteVisual(int posIni, int limite, JLabel fondo) {
        this.posIni = posIni;
        this.limite = limite;
        
        
        ImageIcon imgNor;
        
        if(velocidad < 6)
            imgNor = new ImageIcon("C:\\Users\\jerem\\Documents\\NetBeansProjects\\Prog.Concurrente2020\\src\\test\\java\\TP6\\EJ_5\\Trafico\\Norte.png");
        else{
            imgNor = new ImageIcon("C:\\Users\\jerem\\Documents\\NetBeansProjects\\Prog.Concurrente2020\\src\\test\\java\\TP6\\EJ_5\\Trafico\\RayoMQ.png");
        }
        auto = new JLabel();
        fondo.add(auto);
        auto.setIcon(imgNor);
        auto.setBounds(posIni, 160, 100, 62);
    }

    public void manejar() throws InterruptedException {
        int nuevaPos = posIni;
        
        while(nuevaPos <= limite) {
            nuevaPos = nuevaPos + 5;
            
            auto.setBounds(nuevaPos, 160, 100, 62);
            Thread.sleep(velocidad * 15);
        }
    }
    
    public void llegar() throws InterruptedException {
        int nuevaPos = -200;
        
        while(nuevaPos <= posIni) {
            nuevaPos = nuevaPos + 3;
            
            auto.setBounds(nuevaPos, 160, 100, 62);
            Thread.sleep(velocidad * 20);
        }
    }
}
