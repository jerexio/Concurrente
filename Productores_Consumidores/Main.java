/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test_De_La_Clase.Productores_Consumidores;

/**
 *
 * @author jerem
 */
public class Main {
    
    public static void main(String[] args){
        
        int cant = 100;
        
        Buffer buffer = new Buffer();
        Consumidor[] consumidores = new Consumidor[cant];
        Productor[] productores = new Productor[cant];
        Selector s = new Selector(buffer);
        
        for(int i = 0; i < cant; i++){
            consumidores[i] = new Consumidor(buffer);
            productores[i] = new Productor(buffer);
        }
        
        for(int i = 0; i < cant; i++){
            consumidores[i].start();
            productores[i].start();
        }
        
        s.start();
    }
}
