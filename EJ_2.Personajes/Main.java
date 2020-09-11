/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.EJ_2.Personajes;

/**
 *
 * @author jerem
 */
public class Main {
    public static void main(String[] args){
        
        Vida miVida = new Vida();
        
        Personaje orco = new Personaje(-3, miVida),
                  curandero = new Personaje(3, miVida);
        
        Thread hiloOrco = new Thread(orco, "Orco"),
               hiloCuran = new Thread(curandero, "Curandero");
               
        hiloOrco.start();
        hiloCuran.start();
    }
}