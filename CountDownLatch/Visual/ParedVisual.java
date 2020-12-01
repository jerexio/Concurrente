/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test_De_La_Clase.CountDownLatch_Zombies;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 *
 * @author jerem
 */
public class ParedVisual extends Thread {
    
    private Pared pared;
    private JLabel muro;
    
    public ParedVisual(Pared pared, JLabel fondo, int X) {
        this.pared = pared;
        
        muro = new JLabel();
        fondo.add(muro);
        muro.setIcon(new ImageIcon("C:\\Users\\jerem\\Documents\\NetBeansProjects\\Prog.Concurrente2020\\src\\test\\java\\Test_De_La_Clase\\CountDownLatch_Zombies\\Pared.png"));
        muro.setBounds((X / 2) - 100, 200, 400, 300);
    }
    
    public void run(){
        try {
            pared.interaccionPared();
            muro.setVisible(false);
        } catch (InterruptedException ex) {
        }
    }
}
