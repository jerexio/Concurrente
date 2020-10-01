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
public class ImpresoraByN extends Impresora {
    
    Semaphore semTipoB = new Semaphore(1);

    public ImpresoraByN(String nombre) {
        super(nombre);
    }
    
    public void imprimir(String nombre){
        try{
            semTipoB.acquire();
            
            System.out.println("La impresora Blanco y negro " +this.getNombre()+ " Esta en uso");
            super.imprimir(nombre);
        }
        catch(InterruptedException ignore){
            System.err.println("La impresora exploto, por suerte no hubo heridos");
        }
        finally{
            semTipoB.release();;
        }
    }
}
