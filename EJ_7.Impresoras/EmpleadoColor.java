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
public class EmpleadoColor extends Empleado {

    public EmpleadoColor(ImpresoraColor impresora, String nombre) {
        super(impresora, nombre);
    }

    public void run(){
        System.out.println(Thread.currentThread().getName()+ " Intentara usar "+ this.getImpresora().getNombre());
        
        this.getImpresora().imprimir(this.getNombre());
    }
}
