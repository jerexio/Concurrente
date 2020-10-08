/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.EJ_12_Hamsters;

/**
 *
 * @author jerem
 */
public class Main {
    
    public static void main(String[] args){
        Comida plato = new Comida();
        Rueda rueda = new Rueda();
        Hamaca hamaca = new Hamaca();
        
        int cantHamsters = 5;
        Hamster[] hamsters = new Hamster[cantHamsters];
        Aleatorio aleat = new Aleatorio();
        
        String[] nombres = {"\u001B[31mMr.RED", "\u001B[32mMr.GREEN", "\u001B[33mMr.YELLOW",
                            "\u001B[35mMr.PURPLE", "\u001B[47;36mMr.TURQUESA"};
        
        iniciarHamsters(hamsters, cantHamsters, nombres, plato, rueda, hamaca, aleat);
    }
    
    public static void iniciarHamsters(Hamster[] hamsters, int cant, String[] nombres,
                                       Comida plato, Rueda rueda, Hamaca hamaca, Aleatorio aleat){
        
        for(int i = 0; i < cant; i++){
            hamsters[i] = new Hamster(nombres[i] ,plato, rueda, hamaca, aleat);
        }
        
        for(int j = 0 ; j < cant; j++){
            hamsters[j].start();
        }
    }
}
