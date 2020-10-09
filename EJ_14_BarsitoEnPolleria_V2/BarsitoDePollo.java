/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.EJ_14_BarsitoEnPolleria_V2;

/**
 *
 * @author jerem
 */
public class BarsitoDePollo {
    
    public static void main(String[] args){
        
        Confiteria[] confiteria = {new Confiteria(), new Confiteria()};
        Thread[] empleados = new Thread[6];
        Cocinero cocinero1 = new Cocinero(confiteria[0]);
        Cocinero cocinero2 = new Cocinero(confiteria[1]);
        Mozo mozo = new Mozo(confiteria);
        Thread hiloMozo = new Thread(mozo);
        Thread hiloCocinero1 = new Thread(cocinero1);
        Thread hiloCocinero2 = new Thread(cocinero2);
        String[] nombres = {"\u001B[31mJorge Luis Borges", "\u001B[32mJulio Cortazar", "\u001B[33mRicardo Piglia",
                            "\u001B[35mAdolfo Caseres", "\u001B[36mRodolfo Walsh", "\u001B[47;34mMaria Elena Walsh"};
        
        for(int i = 0; i < 6; i++){
            Empleado emp = new Empleado(confiteria);
            empleados[i] = new Thread(emp, nombres[i]);
            empleados[i].start();
        }
        hiloMozo.start();
        hiloCocinero1.start();
        hiloCocinero2.start();
    }
}
