/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.EJ_1.CuentaBanco;

/**
 *
 * @author jerem
 */
public class Main {
    public static void main(String[] args) {
        VerificarCuenta vc = new VerificarCuenta();
        
        Thread Luis = new Thread(vc, "Luis");
        Thread Manuel = new Thread(vc, "Manuel");
        
        Luis.start();
        Manuel.start();
    }
}
