/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.EJ_6.Letras;

/**
 *
 * @author jerem
 */
public class Letra{ 

    private char letra;
    private int cantImp;
    private Printear print;

    public Letra(char letra, int cantImp, Printear print) {
        this.letra = letra;
        this.cantImp = cantImp;
        this.print = print;
    }

    public char getLetra() {
        return this.letra;
    }
    
    public int getCantImp(){
        return this.cantImp;
    }
    
    public void imprimir() {
        //imprimir llama a otro imprimir, What?
        print.imprimir(this.letra, this.cantImp);
    }
}
