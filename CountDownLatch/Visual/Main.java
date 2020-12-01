/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test_De_La_Clase.CountDownLatch_Zombies;

/**
 *
 * @author jerem
 */
public class Main {
    
    public static void main(String[] args){
        /**
         * No te olvides de cambiar la ubicacion de las imagenes en:
         *  ParedVisual
         *  ZombieVisual
         *  PersonaVisual
         *  Animacion
         * .
         */
        int personas = 1,
            zombies = 1,
            golpes = 3,
            resistencia = zombies*golpes* 10;
        
        new Animacion(personas, zombies, golpes, resistencia);
    }
}
