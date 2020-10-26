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
public class Consumidor extends Thread {
    
    Buffer buffer = new Buffer();
    
    public Consumidor(Buffer buffer){
        this.buffer = buffer;
    }
    
    public void run(){
        
        while(true){
            buffer.consumirElemento();
        }
    }
}
