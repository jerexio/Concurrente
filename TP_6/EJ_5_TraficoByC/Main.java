/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6.EJ_5.Trafico_ByC;

/**
 *
 * @author jerem
 */
public class Main {
    
    public static void main(String[] args){
        
        /**
         * (FIXED Version 0.2) BLOQUEADISIMO:
         *  - Entra un vehiculo pasa el puente, y no hay autos esperando
         * 
         * (FIXED Version 0.3) ROTISIMO:
         *  - Entra un auto pasa, le habilita a otro y se rompe
         * 
         * (FIXED Version 0.3) CONCURRENCIA DE LLEGADA:
         *  - Todos los autos llegan juntos
         * 
         * (FIXED Version 0.3) ROTISIMO_2:
         *  - Con mas de 10, pasan los primeros 10 y se da el paso a 1
         * 
         * .
         */
        Carretera c = new Carretera(12,12);
    }
}
