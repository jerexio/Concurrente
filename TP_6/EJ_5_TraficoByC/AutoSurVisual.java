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
public class AutoSurVisual {
    
    private int posIni;
    private int limite;
    private JLabel auto;
    private int velocidad = 4;
    
    public AutoSurVisual(int posIni, int limite, JLabel fondo) {
        this.posIni = posIni;
        this.limite = limite;
        
        ImageIcon imgSur;
        
        //(velocidad < 6)
            imgSur = new ImageIcon("C:\\Users\\jerem\\Documents\\NetBeansProjects\\Prog.Concurrente2020\\src\\test\\java\\TP6\\EJ_5\\Trafico\\Sur.png");
        //else
        //    imgSur = new ImageIcon("C:\\Users\\jerem\\Documents\\NetBeansProjects\\Prog.Concurrente2020\\src\\test\\java\\TP6\\EJ_5\\Trafico\\Franchesko.png");
        
        auto = new JLabel();
        fondo.add(auto);
        auto.setIcon(imgSur);
        auto.setBounds(posIni, 160, 100, 62);
    }

    public void manejarPrimera() throws InterruptedException {
        int nuevaPos = posIni;
        int primerLimite = posIni - 150;;
        
        while(nuevaPos >= primerLimite){
            nuevaPos = nuevaPos - 5;
            
            auto.setBounds(nuevaPos, 160, 100, 62);
            Thread.sleep(velocidad * 15);
        }
        
        posIni = nuevaPos;
    }
    
    public void manejarSegunda() throws InterruptedException {
        int nuevaPos = posIni;
        
        while(nuevaPos >= limite){
            nuevaPos = nuevaPos - 5;
            
            auto.setBounds(nuevaPos, 160, 100, 62);
            Thread.sleep(velocidad * 15);
        }
    }
    
    public void llegar() throws InterruptedException {
        int nuevaPos = 1200;
        int llegada = (int) Math.random() * 10 + 1;
        
        while(nuevaPos >= posIni){
            nuevaPos = nuevaPos - 3;
            
            auto.setBounds(nuevaPos, 160, 100, 62);
            Thread.sleep(llegada * 20);
        }
    }
}
