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
class Nodo {
    private Object elem;
    private Nodo enlace;
    
    public Nodo (Object elemen, Nodo enlac){
        this.elem = elemen;
        this.enlace = enlac;
    }
    
    public Object getElem(){
        return this.elem;
    }
    
    public Nodo getEnlace(){
        return this.enlace;
    }
    
    public void setElem(Object elemen){
        this.elem = elemen;
    }
    
    public void setEnlace(Nodo enlac){
        this.enlace = enlac;
    }
}
