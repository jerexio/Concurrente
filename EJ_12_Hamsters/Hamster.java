/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.EJ_12_Hamsters;

/**
 *
 * @author jerem
 */
public class Hamster extends Thread{
    private Comida comida;
    private Rueda rueda;
    private Hamaca hamaca;
    private Aleatorio aleat;
    private String nombre;

    public Hamster(String nombre ,Comida comida, Rueda rueda, Hamaca hamaca, Aleatorio aleat) {
        this.comida = comida;
        this.rueda = rueda;
        this.hamaca = hamaca;
        this.aleat = aleat;
        this.nombre = nombre;
    }
    
    public void run(){
        boolean yaComio = false,
                yaCorrio = false,
                yaDurmio = false;
        
        while(!yaComio || !yaCorrio || !yaDurmio){
            int aleatorio = this.aleat.actualizar();
            
            switch(aleatorio%3){
                case 0:
                    if(!yaComio){
                        this.comida.comer(nombre);
                        yaComio = true;
                    }
                    break;
                case 1:
                    if(!yaCorrio){
                        this.rueda.correrEnLaRueda(nombre);
                        yaCorrio = true;
                    }
                    break;
                case 2:
                    if(!yaDurmio){
                        this.hamaca.dormir(nombre);
                        yaDurmio = true;
                    }
                    break;
            }
        }
    }
}
