/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.EJ_13_BarsitoEnPolleria_ConLocks;

import TP4.EJ_13_BarsitoEnPolleria_ConLocks.Cocinero;
import TP4.EJ_13_BarsitoEnPolleria_ConLocks.Empleado;
import TP4.EJ_13_BarsitoEnPolleria_ConLocks.Confiteria;
import TP4.EJ_13_BarsitoEnPolleria_ConLocks.Mozo;

/**
 *
 * @author jerem
 */
public class BarsitoDePollo {
    
    public static void main(String[] args){
        
        /**
         * JERE, EL PROGRAMA A HACER DEBE TENER UN CENTRO DE CONTROL ENTRE:
         *      EMPLEADO - MOZO
         *      MOZO - COCINERO
         * PODRIAS HACR ALGO COMO NOTIFICACIONES QUE VERIFIQUEN SI SE ORDENO COMIDA
         * ALGO ASI COMO ESTADOS.
         */
        
        Confiteria confiteria = new Confiteria();
        Empleado empleado = new Empleado(confiteria);
        Cocinero cocinero = new Cocinero(confiteria);
        Mozo mozo = new Mozo(confiteria);
        
        Thread hiloEmp = new Thread(empleado, "\u001B[33mJoven"),
               hiloCocin = new Thread(cocinero),
               hiloMozo = new Thread(mozo);
        
        hiloEmp.start();
        hiloCocin.start();
        hiloMozo.start();
    }
}
