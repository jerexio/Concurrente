/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.EJ_13_BarsitoEnPolleria;


/**
 *
 * @author jerem
 */
public class Empleado implements Runnable {

    private Confiteria confiteria;
    private boolean tuvoDescanso;
            
    public Empleado(Confiteria confiteria) {
        this.confiteria = confiteria;
        this.tuvoDescanso = false;
    }

    public void run() {
        
        while(!tuvoDescanso){
            if (confiteria.puedoIngresar()) {
                confiteria.ordenar(Thread.currentThread().getName());
                confiteria.recibirComida(Thread.currentThread().getName());
                comer();
                confiteria.salir(Thread.currentThread().getName());
                
                tuvoDescanso = true;
            } else {
                trabajar();
            }
        }
    }

    private void comer() {
        try {
            Thread.sleep(4500);
            System.out.println(Thread.currentThread().getName() + ": \"Ahh, mi ricorda la mia bella Italia\"");
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
