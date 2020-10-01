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
public class Empleado implements Runnable {
    
    private Impresora impresora;
    private String nombre;

    public Empleado(Impresora impresora, String nombre) {
        this.impresora = impresora;
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public Impresora getImpresora() {
        return impresora;
    }
    
    public void run(){
        System.out.println(Thread.currentThread().getName()+ " Intentara usar "+ this.getImpresora().getNombre());
        
        this.impresora.imprimir(this.nombre);
    }
}
