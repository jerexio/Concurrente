/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test_De_La_Clase.Barbero;

/**
 *
 * @author jerem
 */
public class Cliente extends Thread {
    
    /**
     * Soy un cliente, me hago cortar el pelo.
     */
    
    private Barberia barberia;
    private String nombre;

    public Cliente(Barberia barberia, String nombre) {
        this.barberia = barberia;
        this.nombre = nombre;
    }
    
    public void run(){
        
        if(barberia.estaAbierto() && barberia.ingresar(nombre)){
            barberia.pedirCorte(nombre);
            barberia.pagarYSalir(nombre);
        }
        else{
            caminar();
        }
    }
    
    private void caminar(){
        System.out.println(nombre + ": \"Voy a dar una vuelta y vuelvo a ver si se desocupa\"");
        
        try{
            Thread.sleep(3000);
        }
        catch(InterruptedException ignore){
            System.err.println(nombre + " se ha caido en un pozo");
        }
    }
    
    //public String getNombre(){
    //    return nombre.substring(13);
    //}
}
