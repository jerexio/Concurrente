/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.EJ_11_CajeraLocks;

/**
 *
 * @author jerem
 */
public class Main {
    public static void main(String[] args){
        Cliente cliente1 = new Cliente("Cliente 1", new int[] {2, 2, 1, 5, 2, 3}),
                
                cliente2 = new Cliente("Cliente 2", new int[] {1, 3, 5, 1, 1});
        
        FondoDonacion fondo = new FondoDonacion();
        
        long  initialTime = System.currentTimeMillis();
        Cajera cajera1 = new Cajera("Cajera 1", cliente1, initialTime, fondo),
               cajera2 = new Cajera("Cajera 2", cliente2, initialTime, fondo);
    
        cajera1.start();
        cajera2.start();
    }
}
