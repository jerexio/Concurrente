/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.EJ_13_BarsitoEnPolleria;

import TP4.EJ_13_BarsitoEnPolleria_ConLocks.Empleado;
import TP4.EJ_13_BarsitoEnPolleria_ConLocks.Cocinero;
import TP4.EJ_13_BarsitoEnPolleria_ConLocks.Confiteria;
import TP4.EJ_13_BarsitoEnPolleria_ConLocks.Mozo;

/**
 *
 * @author jerem
 */
public class BarsitoDePollo {
    
    public static void main(String[] args){
        
        Confiteria confiteria = new Confiteria();
        Thread[] empleados = new Thread[6];
        Cocinero cocinero = new Cocinero(confiteria);
        Mozo mozo = new Mozo(confiteria);
        Thread hiloMozo = new Thread(mozo);
        Thread hiloCocinero = new Thread(cocinero);
        
        String[] nombres = {"\u001B[31mJorge Luis Borges", "\u001B[32mJulio Cortazar", "\u001B[33mRicardo Piglia",
                            "\u001B[35mAdolfo Caseres", "\u001B[36mRodolfo Walsh", "\u001B[47;34mMaria Elena Walsh"};
        
        for(int i = 0; i < 6; i++){
            Empleado emp = new Empleado(confiteria);
            empleados[i] = new Thread(emp, nombres[i]);
            empleados[i].start();
        }
        hiloMozo.start();
        hiloCocinero.start();
        
    }
}
