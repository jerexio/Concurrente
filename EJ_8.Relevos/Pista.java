/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.EJ_8.Relevos;

/**
 *
 * @author jerem
 */
public class Pista {
    
    private Testigo testigo;
    private long tiempoInicio;
    private int contador = 0;

    public Pista(Testigo testigo, long tiempoInicio) {
        this.testigo = testigo;
        this.tiempoInicio = tiempoInicio;
    }
    
    public void correr(){
        
        this.testigo.tomarTestigo();
        
        System.out.println(Thread.currentThread().getName()+ " Comienza a correr");
        
        int random = (int) (Math.random() * 3) + 9;
        
        try{
            Thread.sleep(random * 1000);
        }
        catch(InterruptedException ignore){
        }
        
        contador++;
        
        if(contador == 4){
            System.out.println(Thread.currentThread().getName()+ " Cabecea la linea de llegada >>> Tiempo de carrera: "+ 
                    (System.currentTimeMillis() - this.tiempoInicio)/1000 +" Seg" );
        }
        else{
            System.out.print(Thread.currentThread().getName()+ " le pasa el testigo a ");
        }
        
        this.testigo.entregarTestigo();
    }
}
