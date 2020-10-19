/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test_De_La_Clase.Barbero;

/**
 *
 * @author jerem
 */
public class BarberoDormilon {
    
    public static void main(String[] args){
        
        Barberia barberia = new Barberia(5);
        Barbero[] barberos = new Barbero[3];
        
        Cliente[] clientes = new Cliente[10];
        
        inicioClientes(clientes, barberia);
        
        for(int i = 0; i < 3; i++){
            barberos[i] = new Barbero(barberia, "BARBERO__"+i+""+i+""+i+""+i+"___");
            barberos[i].start();
        }
        
        for(int i = 0; i < 10; i++){
            clientes[i].start();
        }

//        BarberiaVisual bv = new BarberiaVisual(clientes, barbero, barberia);
//        bv.iniciarMain();
    }
    
    
    private static void inicioClientes(Cliente[] clientes, Barberia barberia){
        
        /**
         * Como se deberia iniciar:
         * <
         *  String[] nombres = new String[10];
         *  
         *  for(int i = 0; i < 10; i++){
         *      nombres[i] = "\u001B[3"+ (i+1) +"mCliente "+ i;
         * >
         * 
         * No cuestiones como uso las funciones de comentarios de java.
         */
        
        String[] nombres = {"\u001B[40;31mAlan Turing", "\u001B[40;32mAda Lovelace", "\u001B[40;33mGordon Moore",
                            "\u001B[40;35mRobin Milner", "\u001B[40;36mCharles Babbage", "\u001B[47;34mJohn McCarthy",
                            "\u001B[47;35mJohn Nash", "\u001B[47;31mKenneth Iverson", "\u001B[44;36mNiklaus Wirth",
                            "\u001B[44;30mEdsger Dijkstra"};
        
        for(int i = 0; i < 10; i++){
            clientes[i] = new Cliente(barberia, nombres[i]);
        }
    }
}
