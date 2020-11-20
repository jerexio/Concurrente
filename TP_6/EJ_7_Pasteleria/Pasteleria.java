/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6.EJ_7_Pasteleria;

/**
 *
 * @author jerem
 */
public class Pasteleria {
    
    public static void main(String[] args){
        
        BufferCajas bCajas = new BufferCajas();
        Mostrador most = new Mostrador();
        Brazo br = new Brazo(bCajas);
        HornoA hA = new HornoA(most);
        HornoB hB = new HornoB(most);
        HornoC hC = new HornoC(most);
        Empaquetador emp1 = new Empaquetador(bCajas, most),
                     emp2 = new Empaquetador(bCajas, most);
        
        
        hA.start();
        hB.start();
        hC.start();
        br.start();
        emp1.start();
        emp2.start();
        
    }
}
