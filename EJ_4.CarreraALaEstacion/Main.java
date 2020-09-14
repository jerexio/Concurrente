/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.EJ_4.AutosViajando;

/**
 *
 * @author jerem
 */
public class Main {
    public static void main(String[] args){
        Thread[] hilosAutos = new Thread[5];
        Surtidor surt = new Surtidor();
                
        for(int i = 0; i < 5; i++){
            hilosAutos[i] = new Thread(new Auto(surt, "ABC-00"+i, "V-0."+i, "ReDuroMono", 120), "Auto-"+i);
        }
        
        hilosAutos[0].start();
        hilosAutos[1].start();
        hilosAutos[2].start();
        hilosAutos[3].start();
        hilosAutos[4].start();
        
    }
}
