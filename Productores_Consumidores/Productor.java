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
public class Productor extends Thread{
    
    Buffer buffer = new Buffer();
    
    public Productor(Buffer buffer){
        this.buffer = buffer;
    }
    
    public void run(){
        
        while(true){
            buffer.ponerElemento();
        }
    }
}
