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
public class PersonaVisual {
    
    private JLabel person;
    private int ANCHO, ALTO, X, Y;
    
    public PersonaVisual(JLabel fondo, int ANCHO, int ALTO){
        
        this.ANCHO = ANCHO;
        this.ALTO = ALTO;
        this.X = ANCHO - 300;
        this.Y = 350;
        
        person = new JLabel();
        fondo.add(person);
        person.setIcon(new ImageIcon("C:\\Users\\jerem\\Documents\\NetBeansProjects\\Prog.Concurrente2020\\src\\test\\java\\Test_De_La_Clase\\CountDownLatch_Zombies\\Persona.png"));
        person.setBounds(X, Y, 150, 175);
    }
    
    public void escapar() throws InterruptedException{
        
        for(int i = X; i < 1200; i++){
            person.setBounds(i, Y, 150, 175);
            Thread.sleep(15);
        }
    }
}
