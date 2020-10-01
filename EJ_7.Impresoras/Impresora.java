/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.EJ_7.Impresoras;

/**
 *
 * @author jerem
 */
public abstract class Impresora {
    
    private String nombre;

    public Impresora(String nombre) {
        this.nombre = nombre;
    }
    
    public void imprimir(String nombre){
        
        int timer = (int) (Math.random() * 10);
        
        System.out.println(nombre + " Actualmente esta Imprimiendo\n");
        
        try{
            if(timer > 7){
                System.out.println("Se ve que " +Thread.currentThread().getName()+ " Tiene para rato");
            }
            Thread.sleep(timer * 1000);
        }
        catch(InterruptedException ignore){
            System.err.println("Se volvieron a dormir en la impresora");
        }
    }

    public String getNombre() {
        return nombre;
    }
}
