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
public class Aleatorio {
    private int random;
    
    public Aleatorio(){
        this.random = this.aleat();
    }
    
    private int aleat(){
        return ((int) ((Math.random() * 100000) % 3));
    }
    
    public int actualizar(){
        return this.aleat();
    }
}
