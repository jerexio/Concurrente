/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.EJ_7.Impresoras;

import java.util.concurrent.Semaphore;

/**
 *
 * @author jerem
 */
public class ImpresoraColor extends Impresora {

    Semaphore semTipoA = new Semaphore(1);

    public ImpresoraColor(String nombre) {
        super(nombre);
    }

    public void imprimir(String nombre){
        
        try {
            semTipoA.acquire();
            
            System.out.println("\nLa impresora Color "+ this.getNombre() +" Esta ocupada");
            super.imprimir(nombre);
            
        }
        catch(InterruptedException ignore){
            System.err.println("Parece que una impresora exploto, las paredesq tienen nueva decoracion");
        }
        finally{
            semTipoA.release();
        }
    }
}
