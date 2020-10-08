/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.EJ_11_CajeraLocks;

/**
 *
 * @author jerem
 */
public class Cajera extends Thread {
    private String nombre;
    private Cliente cliente;
    private long initialTime;
    private FondoDonacion fondo;

    public Cajera(String nombre, Cliente cliente, long intialTime, FondoDonacion fondo) {
        this.nombre = nombre;
        this.cliente = cliente;
        this.initialTime = intialTime;
        this.fondo = fondo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public long getIntialTime() {
        return initialTime;
    }

    public void setIntialTime(long initialTime) {
        this.initialTime = initialTime;
    }

    public void run(){
        
        System.out.println("La cajera "+ this.nombre +" COMIENZA A "
                       + "PROCESAR LA COMPRA DEL CLIENTE "+ this.cliente.getNombre()
                       + " EN EL TIEMPO: "+
                       (System.currentTimeMillis() - this.initialTime) / 1000 + "seg\n");
       
        int longCarro = this.cliente.getCarroCompra().length,
            precioFinal = 0;
        
        for(int i = 0; i < longCarro; i++){
            this.esperarXsegundos(this.cliente.getCarroCompra()[i]);
            /*
             * SE PODRIA AGREGAR OTRA CLASE QUE SEA PRODUCTO Y HACER EL ARREGLO
             * EN BASE A ESO. PERO DEBERIA MODIFICAR CODIGO
             */
            precioFinal += this.cliente.getCarroCompra()[i] * 100;
            
            System.out.println("Procesando el producto "+ (i + 1)+
            " -> Tiempo: "+ (System.currentTimeMillis() - this.initialTime) / 1000 + "seg\n");
        }
        
        System.out.println("La Cajera "+ this.nombre +" HA TERMINADO DE PROCESAR "+
                       this.cliente.getNombre() + " EN EL TIEMPO: " + 
                       (System.currentTimeMillis() - this.initialTime) / 1000 + "Seg\n"
                       + "Costo Total: "+ precioFinal);
        
        this.fondo.agragarFondos(precioFinal/100);
    }
    
    private void esperarXsegundos(int tiempo){
        try{
            Thread.sleep(1000 * tiempo);
        }
        catch(InterruptedException e){
        }
    }
}
