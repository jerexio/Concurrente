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
public class CentroDeImpresion {
    
    public static void main(String[] args){
        
        ImpresoraByN impByN = new ImpresoraByN("Imp-ByN-0");
        ImpresoraColor impColor = new ImpresoraColor("Imp-Color-1");
        
        EmpleadoColor[] empColor = new EmpleadoColor[5];
        EmpleadoByN[] empByN = new EmpleadoByN[5];
        
        Thread[] hilos = new Thread[10];
        
        for(int i = 0; i < 5; i++){
            empColor[i] = new EmpleadoColor(impColor, "\u001B[3"+i+"m EmpColor-"+i);
            hilos[i] = new Thread(empColor[i], "Hilo-"+i);
            
            empByN[i] = new EmpleadoByN(impByN, "\u001B[3"+(6-i)+"m EmpByN-"+(9-i));
            hilos[i+5] = new Thread(empByN[i], "Hilo-"+(9-i));
        }
        
        for(int j = 0; j < 5; j++){
            hilos[j].start();
            hilos[j+5].start();
        }
    }
}
