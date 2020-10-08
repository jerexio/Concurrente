/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.EJ_14_BarsitoEnPolleria_V2;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jerem
 */
public class Confiteria {

    /**
     * Soy una confiteria, aca se organiza como van a ser las comunicaciones
     * entre los hilos Empleados, Mozo y cocinero.
     */
    private Semaphore semEmpleado = new Semaphore(0, true);
    private Semaphore semMozo = new Semaphore(0, true);
    private Semaphore semCocinero = new Semaphore(0, true);
    private Semaphore semBar = new Semaphore(1, true);
    private String[] bebidas = {"Gaseosa", "Jugo", "Agua", "Vino", "Cervezas"};
    private String[] comidas = {"Pollo al horno", "Pollo al disco", "Asado", "Hamburguejas al Vapor", "Banquete"};
    private int numBebida = -1, numComida = -1;

    
    
    
    
    
    
    
    /**
     * Cosas que hace el Empleado.
     */
    public boolean puedoIngresar() {
        return (semBar.tryAcquire());
    }

    public void ordenarBebida(String nombre, int num) {
        try {
            if(num != -1){
                numBebida = num;
                System.out.println(nombre + ": \"Me gustaria probar " + bebidas[num] + "\"");
            }
            semMozo.release();
            semEmpleado.acquire();
        } catch (InterruptedException e) {
        }
    }

    public void ordenarComida(String nombre, int num) {
        try {
            if(num != -1){
                numComida = num;
                System.out.println(nombre + ": \"Me gustaria probar " + comidas[num] + "\"");
            }
            semMozo.release();
            semEmpleado.acquire();
        } catch (InterruptedException e) {
        }
    }

    public void recibirBebida(String nombre) {
        System.out.println(nombre + ": \"Gracias por la bebida\"");
        semMozo.release();
    }

    public void recibirComida(String nombre) {
        System.out.println(nombre + ": \"Gracias por la comida\"");
        semMozo.release();
    }

    public void salir(String nombre) {
        System.out.println(nombre + " termino de comer y se esta yendo");
        semBar.release();
    }

    public String[] mirarBebidas() {
        return bebidas;
    }

    public String[] mirarComidas() {
        return comidas;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * Cosas que hace el Mozo.
     */
    public boolean tomarOrdenbebida() {
        
        boolean tomar = false;
        try {
            semMozo.acquire();
            
            if (numBebida != -1) {
                System.out.println("Mozo: \"Aguarde un momento\"");
                tomar = true;
            }
            else{
                semMozo.release();
                semEmpleado.release();
            }
        }
        catch (InterruptedException e) {
        }
        
        return tomar;
    }

    public void entregarBebida() {
        System.out.println("Mozo: \"Aqui esta su bebida\"");
        semMozo.release();
        semEmpleado.release();
    }

    public boolean tomarOrdenComida() {
        
        boolean tomar = false;
        try {
            semMozo.acquire();
            
            if (numComida != -1) {
                System.out.println("Mozo: \"Aguarde un momento\"");
                System.out.println("Mozo: \"Hay una nueva orden chef\"");
                tomar = true;
                semCocinero.release();
            }
            else{
                semMozo.release();
                semEmpleado.release();
            }
        }
        catch (InterruptedException e) {
        }
        
        return tomar;
    }

    public void recibirComidaMozo() {
        try {
            semMozo.release();
            semCocinero.acquire();
            System.out.println("Mozo: \"Esto se ve muy bueno\"");
            semCocinero.release();

        } catch (InterruptedException ex) {
            Logger.getLogger(Confiteria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void entregarComida() {
        System.out.println("Mozo: \"Su comida y bebida señor\"");
        semEmpleado.release();

    }

    public void inventarBebidas() {
        try {

            semMozo.acquire();
            System.out.println("Mozo: \"Mmm...Si mezclo mirra, ruibarbo, manzanilla, cardamomo, orégano y azafrán\"");
            System.out.println("Mozo: \"Pues te voy a llamar fernet\"");

        } catch (InterruptedException ex) {
            Logger.getLogger(Confiteria.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * Cosas que hace cocinero.
     */
    public void recibirOrden() {
        try {
            semCocinero.acquire();
            System.out.println("Cocinero: \"Okey, ya lo cocino\"");
        } catch (InterruptedException e) {
        }
    }

    public void terminarComida() {
        try {

            semMozo.acquire();
            System.out.println("Cocinar: \"Ya termine de cocinar\"");
            semCocinero.release();

        } catch (InterruptedException ex) {
            Logger.getLogger(Confiteria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void inventarComidas() {
        try {
            semCocinero.acquire();
            System.out.println("Cocinero: \"A inventar Pollos\"");
        } catch (InterruptedException e) {
        }
    }
}
