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
public class CuentaBanco {

    private int balance = 50;

    public CuentaBanco() {
    }

    public synchronized int getBalance() {
        return balance;
    }

    public synchronized void retiroBancario(int retiro) {
        balance = balance - retiro;
    }
}
