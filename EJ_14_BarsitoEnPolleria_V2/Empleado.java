/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.EJ_14_BarsitoEnPolleria_V2;


/**
 *
 * @author jerem
 */
public class Empleado implements Runnable {

    private Confiteria[] confiteria;
    private boolean tuvoDescanso;
            
    public Empleado(Confiteria[] confiteria) {
        this.confiteria = confiteria;
        this.tuvoDescanso = false;
    }

    public void run() {
        
        while(!tuvoDescanso){
            int random = (int) (Math.random() * 2);
            
            if (confiteria[random].puedoIngresar()) {
                
                int numBeb = elegirDelMenu(confiteria[random].mirarBebidas(), 0);
                procederAOrdenarBebida(random, numBeb);
                
                int numCom = elegirDelMenu(confiteria[random].mirarComidas(), numBeb);
                procederAOrdenarComida(random, numCom);
                
                confiteria[random].salir(Thread.currentThread().getName());
                tuvoDescanso = true;
            } else {
                trabajar();
            }
        }
    }
    
    private void procederAOrdenarBebida(int mesa, int numOrden){
        confiteria[mesa].ordenarBebida(Thread.currentThread().getName(), numOrden);
        confiteria[mesa].recibirBebida(Thread.currentThread().getName());
        beber();
    }
    
    private void procederAOrdenarComida(int mesa, int numOrden){
        confiteria[mesa].ordenarComida(Thread.currentThread().getName(), numOrden);
        confiteria[mesa].recibirComida(Thread.currentThread().getName());
        comer();
    }
    
    private void comer() {
        try {
            Thread.sleep(4500);
            System.out.println(Thread.currentThread().getName() + ": \"Ahh, mi ricorda la mia bella Italia\"");
        } catch (InterruptedException e) {
            System.err.println("Se ahogo con la comida");
        }
    }
    
    private void beber() {
        try {
            Thread.sleep(4500);
            System.out.println(Thread.currentThread().getName() + ": \"Muy buena bebida\"");
        } catch (InterruptedException e) {
            System.err.println("Se ahogo con la comida");
        }
    }

    private void trabajar() {
        try {
            Thread.sleep(((int) (Math.random() * 10) + 1) * 1000);
        } catch (InterruptedException e) {
            System.err.println("El empleado " + Thread.currentThread().getName()
                    + " ha sufrido un accidente");
        }
    }
    
    private int elegirDelMenu(String[] alim, int numPrev){
        int num = (int)(Math.random() * alim.length + 1); //
        
        if(num >= alim.length){
            if(numPrev != -1)
                num = -1;
            else
                num = (int)(Math.random() * alim.length);
        }     
        return num;
    }
}
