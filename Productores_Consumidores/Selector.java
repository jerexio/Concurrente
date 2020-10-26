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
public class Selector extends Thread {

    Buffer buffer = new Buffer();

    public Selector(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {

        int random = (int) (Math.random() * 2);;

        while (true) {
            try {
                if (random == 0) {
                    buffer.habilitarPoner();
                } else {
                    buffer.habilitarQuitar();
                }
                
                random = actualizar(random);
            }
            catch(InterruptedException e){
                
            }
        }

    }
    
    private int actualizar(int num){
        if(num == 0)
            num = 1;
        else
            num = 0;
        
        return num;
    }
}
