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

    public static void main(String[] args) {
        int personas = 1,
            zombies = 2,
            golpes = 10,
            resistencia = zombies*golpes;

        Pared p = new Pared(resistencia);

        for (int i = 0; i < personas; i++) {
            new Persona(p, "P__" + i).start();
        }

        for (int i = 0; i < zombies; i++) {
            new Zombie(p, "Z__" + i, golpes).start();
        }
    }
}
