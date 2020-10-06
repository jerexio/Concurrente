/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test_De_La_Clase.Barbero;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jerem
 */
public class Barberia {

    /**
     * Soy una barberia, llevo el control de los clientes y barberos
     *
     * Se agrego la sala de espera, lo implemente con una variable que controle
     * los espacios en la sala de espera
     *
     * Atributos:
     *      -semBarbero --> Controla que el barbero este despierto o no
     *      -semSillom --> Controla si hay un cliente siendo atendido
     *      -semCliente --> Controla que el cliente no se vaya antes de terminar
     *      -mutexSillas --> Para controlar que dos hilos no accedan o modifiquen la cantidad de sillas al mismo tiempo
     *      -mutexAbierto --> Para verificar si la barberia sigue abierta
     *      -cantSillas --> cantidad de sillas disponibles
     *      -abierto --> ignorar
     * .
     */
    private Semaphore semBarbero = new Semaphore(0, true);
    private Semaphore semSillon = new Semaphore(1, true);
    private Semaphore semCliente = new Semaphore(0, true);
    private Semaphore mutexSillas = new Semaphore(1, true);
    private int cantSillas;
    //private boolean abierto;
    private long horarioAbierto = System.currentTimeMillis(),
                 tiempoTranscurrido = System.currentTimeMillis(),
                 horaDeSalida = 20000;
    
    public Barberia(int espacios) {
        cantSillas = espacios;
        //abierto = true;
    }

    
    
    
    /**
     * COSAS QUE HACE EL CLIENTE.
     */
    public boolean ingresar(String nombre) {

        /**
         * El cliente verifica si puede entrar y ocupar un lugar
         *
         * Si soy el primer cliente paso directo a sillon, sino ocupo silla.
         */
        boolean ingreso = false;
        
        System.out.println(nombre + " esta viendo si puede ingresar");
        
//        if (semSillon.tryAcquire()) {  Esto es para implementar que el primer cliente ocupe sillon, ignorar
//            ingreso = true;
//        }
//        else{
        ingreso = verificarDisponibilidad(nombre);
        //}
        
        return ingreso;
    }

    private boolean verificarDisponibilidad(String nombre) {
        /**
         * El cliente verifica si puede entrar y ocupar un lugar.
         */
        boolean ocupoAsiento = false;

        try {

            mutexSillas.acquire();

            if (cantSillas >= 1) {
                cantSillas--;
                System.out.println(nombre + ": \"Hola muy buenas tardes a todos\"");
                ocupoAsiento = true;
            }

            mutexSillas.release();

        } catch (InterruptedException ignore) {
            System.err.println("Al parecer una silla se rompio");
        }

        return ocupoAsiento;
    }

    public void pedirCorte(String nombre) {

        /**
         * El cliente se sienta en sillon
         * Se verifica que este abierto
         * 
         * Como obtuve el sillon, tengo que liberar mi silla
         * 
         * El cliente pide el corte
         * Despierto al barbero
         * Y espero
         * 
         * Los clientes que estan dentro deben ser atendidos
         * .
         */
        try {

            semSillon.acquire();

            obtenerSillon();
            System.out.println("" + nombre + ": \"Seria de mi agrado, que me cortara el pelo\"");

            semBarbero.release();
            semCliente.acquire();

        } catch (InterruptedException ignore) {
            System.err.println("Parece ser que el barbero no esta dormido, sino inconsiente");

        }
    }

    private void obtenerSillon() {
        
        /**
         * Si obtuve el sillon libero silla.
         */
        try {
           mutexSillas.acquire();

            cantSillas++;
            mutexSillas.release();

        } catch (InterruptedException ignore) {
            System.err.println("Un cliente ha caido en su camino al sillon");
        }
    }

    public void pagarYSalir(String nombre) {

        System.out.println(nombre + ": \"Aqui esta su pago, nos vemos\"");
        semBarbero.release();

        try {
            Thread.sleep(2000); //Simula el tiempo de salida
        } catch (InterruptedException ignore) {
            System.err.println(nombre + " se resbalo y cayo en el piso de la barberia");
        } finally {
            semSillon.release();
        }
    }
    
    public boolean estaAbierto(){
        return (tiempoTranscurrido >= horaDeSalida);
    }

    
    
    
    
    
    
    
    
    
    /**
     * COSAS QUE HACE EL BARBERO.
     */
    public void atender() {

        try {
            semBarbero.acquire();

        } catch (InterruptedException ignore) {
            System.err.println("El barbero se rasbalo y cayo");
        }

        System.out.println("Barbero: \"Si, señor, un placer\"");
    }

    public void cobrar() {
        semCliente.release();
    }

    public void descansar() {
        try {

            semBarbero.acquire();

            System.out.println("A dormir pues");
            Thread.sleep(2000);

        } catch (InterruptedException ignore) {
            System.err.println("El barbero desperto por una pasadilla");
        }
    }

    public void cerrarBarberia() {
        
        /**
         * Por que estaran Deprecated los metodos para matar hilos??
         * Porque es responsabilidad del programdor lograr ese "matar".
         */
        
        System.out.println("Barbero: \"Ya es hora de cerrar\"");

        System.out.println("Fueron atendidas " + (10 - Thread.activeCount()) + " personas");

    }
    
    public boolean quedanClientes(){
        return (cantSillas < 5);
    }
}
