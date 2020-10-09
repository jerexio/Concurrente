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
            
            int mesa = (int)(Math.random() * 2);
            
            if (confiteria[mesa].puedoIngresar()) {
                
                if(confiteria[mesa].deseaBebida()){
                    confiteria[mesa].ordenarBebida(Thread.currentThread().getName());
                    confiteria[mesa].recibirBebida(Thread.currentThread().getName());
                }
                
                if(confiteria[mesa].deseaComida()){
                    confiteria[mesa].ordenarComida(Thread.currentThread().getName());
                    confiteria[mesa].recibirComida(Thread.currentThread().getName());
                }
                
                comerYBeber();
                confiteria[mesa].salir(Thread.currentThread().getName());
                
                tuvoDescanso = true;
            } else {
                trabajar();
            }
        }
    }
    
    private void comerYBeber() {
        try {
            Thread.sleep(4500);
            System.out.println(Thread.currentThread().getName() + ": \"Muy buena la cuetion\"");
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
}
