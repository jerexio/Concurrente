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
public class Relevo {
    
    public static void main(String[] args){
        Thread[] equipo1 = new Thread[4],
                 equipo2 = new Thread[4];
        
        Testigo testigo1 = new Testigo(),
                testigo2 = new Testigo();
        
        
        Pista pista1 = new Pista(testigo1, System.currentTimeMillis());
        Pista pista2 = new Pista(testigo2, System.currentTimeMillis());
        
        for(int i = 0; i < 4; i++){
            equipo1[i] = new Thread(new Atleta(pista1), "T1_Atleta__"+(i+1));
            
            equipo2[i] = new Thread(new Atleta(pista2), "T2_Atleta__"+(i+1));
        }
        try{
            System.out.println("En sus marcas...");
            Thread.sleep(1500);
            System.out.println("Listos...");
            Thread.sleep(1500);
            System.out.println("Sonido de pistola\n");
        }
        catch(InterruptedException ignore){
        }
        
        for(int j = 0; j < 4; j++){
            equipo1[j].start();
            equipo2[j].start();
        }
    }
}
