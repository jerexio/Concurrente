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
public class ZombieVisual {
    
    private JLabel zombie;
    private JLabel pow;
    private int ANCHO, ALTO, X, Y;
    
    public ZombieVisual(JLabel fondo, int ANCHO, int ALTO){
        this.Y = (int) (Math.random() * 200);
        this.ANCHO = ANCHO;
        this.ALTO = ALTO;
        this.X = (ANCHO/2) - 125;
        
        pow = new JLabel();
        fondo.add(pow);
        pow.setVisible(false);
        pow.setIcon(new ImageIcon("C:\\Users\\jerem\\Documents\\NetBeansProjects\\Prog.Concurrente2020\\src\\test\\java\\Test_De_La_Clase\\CountDownLatch_Zombies\\Pow.png"));
        pow.setBounds((ANCHO / 2) - 50, 200+Y, 100, 80);
        
        zombie = new JLabel();
        fondo.add(zombie);
        zombie.setIcon(new ImageIcon("C:\\Users\\jerem\\Documents\\NetBeansProjects\\Prog.Concurrente2020\\src\\test\\java\\Test_De_La_Clase\\CountDownLatch_Zombies\\Zombie.png"));
        zombie.setBounds(0, 200+Y, 150, 150);
        
        
    }
    
    public void encontrarHumano() throws InterruptedException{
        int velocidad = (int) (Math.random() * 3) + 1;
        for(int i = 0; i < X; i++){
            zombie.setBounds(i, 200+Y, 150, 150);
            Thread.sleep(velocidad * 15);
        }
    }
    
    public void ataque() throws InterruptedException{
        pow.setVisible(true);
        Thread.sleep(100);
        pow.setVisible(false);
    }
    
    public void perseguirHumano() throws InterruptedException{
        for(int i = X; i < 1200; i++){
            zombie.setBounds(i, 200+Y, 150, 150);
            Thread.sleep(25);
        }
    }
}
