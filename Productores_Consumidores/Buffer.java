/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test_De_La_Clase.Productores_Consumidores;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 *
 * @author jerem
 */
public class Buffer {
    
    /**
     * Buffer o recurso compartido
     * 
     * semProductor -> Libera n permisos para los productores que estan esperando
     * entren a producir
     * semPSalida -> Libera n permisos para que los productores terminen
     * de producir
     * semConsumidor -> Libera m permisos para los consumidores que estan esperando
     * entren a consumir
     * semCSalida -> Libera m permisos para que los consumidores terminen
     * de consumir
     * 
     * lockEltos -> Asegura la exclusion mutua a la hora de producir o consumir
     * 
     * cantEltos -> Cantidad de elementos actuales, se inicia en una cantidad
     * distinta de 0 (Se puede iniciar en 0, pero si primero ingresan
     * consumidores van a entrar por nanosegundos y salir)
     * limMax -> Limite maximo de elementos para producir (Si se pone en -1 no hay limite).
     */
    
    private Semaphore semProductor = new Semaphore(0);
    private Semaphore semConsumidor = new Semaphore(0);
    private Semaphore semPSalida = new Semaphore(0);
    private Semaphore semCSalida = new Semaphore(0);
    private Lock lockEltos = new ReentrantLock();
    private int cantEltos = (int) ((Math.random() * 100000) % 100) + 1;
    private int limMax = 100000;
    
    public void ponerElemento(){
        try {
            
            semProductor.acquire();
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while(!semPSalida.tryAcquire()){
            lockEltos.lock();
            try{
                if(cantEltos != limMax){
                    cantEltos = cantEltos + 1;
                    System.out.println("Producto creado (+1), Total = "+ cantEltos);
                }
            }
            finally{
                lockEltos.unlock();
            }
        }
    }
    
    public void consumirElemento(){
        try {
            semConsumidor.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while(!semCSalida.tryAcquire()){
            lockEltos.lock();
            try{
                if(cantEltos > 0){
                    cantEltos = cantEltos - 1;
                    System.out.println("Ñam Ñam Ñam Producto consumido (-1), Total = "+ cantEltos);
                }
            }
            finally{
                lockEltos.unlock();
            }
        }
    }
    
    /**
     * Logica en terminos generales:
     *  - Productores y consumidores esperan en semaforos hasta que se libere
     *      la cantidad de hilos esperando en semaforos (EJ: Puedo tener 10 hilos creados,
     *      pero solo 5 esperando en semaforo solo se liberan 5 semaforos)
     * 
     *  - El selector (Planificador de Hilos?) decide a quien le toca, productor
     *      o consumidor
     * 
     *  - El selector averigua cuantos hilos hay esperando y libera esa cantidad de permisos,
     *      la finalidad es evitar el caso donde un productor muy lento entre
     *      a producir cuando no es su turno
     * 
     *  - Luego el selector espera a que "Pase tiempo", en el caso que ya no haya
     *      eltos por consumir o no hay mas lugar para producir, el selector
     *      pasa el turno al otro.
     * .
     */
    
    public void habilitarPoner() throws InterruptedException{
        int cant = semProductor.getQueueLength();
        
        semProductor.release(cant);
        tiempoRandom(limMax);
        semPSalida.release(cant);
    }
    
    public void habilitarQuitar() throws InterruptedException{
        int cant = semConsumidor.getQueueLength();
        
        semConsumidor.release(cant);
        tiempoRandom(0);
        semCSalida.release(cant);
    }
    
    private void tiempoRandom(int cant){
        //El cant no es tiempo, sino el limite de elementos que puede haber
        
        int n1 = (int)(Math.random() * 5000),
            n2 = (int)(Math.random() * 5000),
            n3 = (int)(Math.random() * 5000);
        
        while ((cantEltos != cant) && (n1 != n2 || n2 != n3)){
            n1 = (int)(Math.random() * 5000);
            n2 = (int)(Math.random() * 5000);
            n3 = (int)(Math.random() * 5000);
        }
        
        /**
         * Esto hace espera activa, seria mejor usar:
         * 
         * Thread.sleep((int)((Math.random() * 10) + 1l) * ((Math.random() * 1000) + 1));
         * 
         * Pero la concurrencia se aprecia mejor con lo que se hizo antes
         * ya que puede durar de 0,1 seg hasta 10 seg maximo.
         */
    }
}
