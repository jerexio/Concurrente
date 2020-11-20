/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6.EJ_7_Pasteleria;


public class Cola { //COLA DINAMICA
    //El metodo toString esta como comentario
    private Nodo frente;
    private Nodo fin;
    
    public Cola(){
        this.frente = null;
        this.fin = null;
    }
    
    public boolean poner(Object elem){
        Nodo nuevoNodo;
        
        nuevoNodo = new Nodo(elem, null);
        
        if(this.fin == null){
            this.fin = nuevoNodo;
            this.frente = nuevoNodo;
        }
        else{
            this.fin.setEnlace(nuevoNodo);
            this.fin = this.fin.getEnlace();
        }
        
        
        return true;
    }
    
    public boolean sacar(){
        boolean exito = true;
        
        if(this.frente == null)
            exito = false;
        else{
            this.frente = this.frente.getEnlace(); //Se asigna al frente, su enlace con el nodo siguiente
            if(this.frente == null){ //Si el frente es nulo quiere decir que no quedan elementos en la cola
                this.fin = null;
            }
        }
        
        return exito;
    }
    
    public Object obtenerFrente(){
        Object elem;
        
        if(this.frente == null)
            elem = null;
        else
            elem = this.frente.getElem();
        
        return elem;
    }
    
    public boolean esVacia(){
        boolean esVacia;
        
        esVacia = (this.frente == null);
        
        return esVacia;
    }
    
    public void vaciar(){
        this.frente = null;
        this.fin = null;
    }
    
    public Cola clone(){
        Cola clonCola = new Cola();
        Nodo aux1 = this.frente;
        
        if(this.frente != null){ //Para evitar error por si se clona una cola vacia
            clonCola.frente = new Nodo(aux1.getElem(), null);
            aux1 = aux1.getEnlace();
            Nodo aux2 = clonCola.frente;
        
            while(aux1 != null){
                aux2.setEnlace(new Nodo(aux1.getElem(), null)); //Se asigna al clon los elementos de la cola original
                aux2 = aux2.getEnlace(); //El puntero que apunta a la cola clon avanza
                aux1 = aux1.getEnlace(); //El puntero que apunta a la cola original avanza
            }
            clonCola.fin = aux2;
        }

        return clonCola;
    }
    /*
    public String toString(){
        String cad = "[ ";
        Nodo aux1 = this.frente;
        
        while(aux1 != null){
            cad += aux1.getElem() + " ";
            aux1 = aux1.getEnlace();
        }
        cad += "]";
        if(this.frente != null)
            cad += "\nFrente: "+ this.frente.getElem() +"\nFin: "+ this.fin.getElem();
        
        return cad;
    }
    */
}
