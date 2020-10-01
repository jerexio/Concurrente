/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.EJ_6.Letras;

import java.util.concurrent.Semaphore;
/**
 *
 * @author jerem
 */
public class Printear {
    
    private Semaphore semA = new Semaphore(1),
                      semB = new Semaphore(0),
                      semC = new Semaphore(0);
    
    public void imprimir(char letra, int cant){
        
        switch (letra){ //Hola soy un Switch que verifica la letra
            
            case 'A':
                try{
                    semA.acquire();
                }catch(InterruptedException e){
                }
                
                impresar(letra, cant);
                semB.release();
                break;
                
            case 'B':
                try{
                    semB.acquire();
                }catch(InterruptedException e){
                }
                
                impresar(letra, cant);
                semC.release();
                break;
                
            case 'C':
                try{
                    semC.acquire();
                }catch(InterruptedException e){
                }
                
                impresar(letra, cant);
                semA.release();
                break;
        }
    }
    
    private void impresar(char letra ,int cant){
        //Yo solo imprimo, ...
        
        for(int i = 0; i < cant; i++){
            System.out.print(letra);
        }
    }
}
