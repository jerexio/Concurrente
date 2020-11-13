/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6.EJ_5.Trafico_ByC;

/**
 *
 * @author jerem
 */
public class Puente {

    private final Object monitorSur = new Object(); //MONITORSUR
    private int cantNorte = 10;
    private int cantSur = 10;
    private int pasaronNor = 10;
    private int pasaronSur = 10;
    private int esperaNor = 0;
    private int esperaSur = 0;

    public Puente() {
        int n = (int) (Math.random() * 2);

        if (n == 0) {
            pasaronNor = 0;
        } else {
            pasaronSur = 0;
        }
    }

    public synchronized void entrarCocheDelNorte() throws InterruptedException {

        while (pasaronNor == 10) {
            esperaNor++;
            wait();
        }

        if (esperaNor > 0) {
            esperaNor--;
        }
        
        pasaronNor++;
        cantNorte--;
    }

    public synchronized void salirCocheDelNorte() throws InterruptedException {
        cantNorte++;

        /**
         * Casos cubiertos:
         *      - Hay autos de ambos lados
         *      - Paso la maxima cantidad de autos posibles:
         *              - Hay autos en este lado y no del otro
         *              - No quedan autos de este lado y si del otro lado
         *      - No paso la cantidad de autos posibles:
         *              - No quedan autos de este lado y del otro si
        *               - Queda un auto que llego tarde de este lado
         *      - No hay autos
         *
         *      - Que pasa si solo hay autos de un solo lado, al principio de la ejecucion??
         *              *Si eso pasa ya no habria concurrencia, asi que no entra en consideracion.
         */
        
        if (cantNorte == 10) { //Soy el ultimo de los que puede pasar
            pasaronNor = 10; //Soy el ultimo de los que llego a pasar el puente
            if (esperaSur != 0) { //Todavia hay autos en el sur
                synchronized (monitorSur) {
                    pasaronSur = 0;
                    monitorSur.notifyAll();
                }
            } else { //No quedan autos en el sur
                if (esperaNor != 0) { //Quedan autos en el norte
                    this.notifyAll();
                }

            }
        }
    }

    public void entrarCocheDelSur() throws InterruptedException {
        synchronized (monitorSur) {

            while (pasaronSur == 10) {
                esperaSur++;
                monitorSur.wait();
            }

            if (esperaSur > 0) {
                esperaSur--;
            }
            
            pasaronSur++;
            cantSur--;
        }
    }

    public void salirCocheDelSur() throws InterruptedException {
        synchronized (monitorSur) {
            cantSur++;

            if (cantSur == 10) { //Soy el ultimo de los que puede pasar
                pasaronSur = 10; //Soy el ultimo de los que llego a pasar el puente
                if (esperaNor != 0) { //Todavia hay autos en el norte
                    synchronized (this) {
                        pasaronNor = 0;
                        this.notifyAll();
                    }
                } else { //No quedan autos en el norte
                    if (esperaSur != 0) { //Quedan autos en el sur
                        monitorSur.notifyAll();
                    }
                }
            }
        }
    }

}
