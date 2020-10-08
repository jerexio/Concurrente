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
        
        Confiteria[] confiterias = {new Confiteria(), new Confiteria()};
        Thread[] empleados = new Thread[6];
        Cocinero cocinero = new Cocinero(confiterias[0]);
        Cocinero cocinero2 = new Cocinero(confiterias[1]);
        Mozo mozo = new Mozo(confiterias);
        Thread hiloMozo = new Thread(mozo);
        Thread hiloCocinero = new Thread(cocinero),
               hiloCocinero2 = new Thread(cocinero2);
        
        String[] nombres = {"\u001B[40;31mJorge Luis Borges", "\u001B[40;32mJulio Cortazar", "\u001B[40;33mRicardo Piglia",
                            "\u001B[40;35mAdolfo Caseres", "\u001B[40;36mRodolfo Walsh", "\u001B[47;34mMaria Elena Walsh"};
        
        for(int i = 0; i < 6; i++){
            Empleado emp = new Empleado(confiterias);
            empleados[i] = new Thread(emp, nombres[i]);
            empleados[i].start();
        }
        hiloMozo.start();
        hiloCocinero.start();
        hiloCocinero2.start();
        
    }
}
