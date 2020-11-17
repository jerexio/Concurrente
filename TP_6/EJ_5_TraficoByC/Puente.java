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
    
    /**
     * Casos cubiertos:
     *      - Hay autos de ambos lados
     *      - Paso la maxima cantidad de autos posibles:
     *              - Hay autos en este lado y no del otro
     *              - No quedan autos de este lado y si del otro lado
     *      - No paso la cantidad de autos posibles:
     *              - No quedan autos de este lado y del otro si
     *              - Queda un auto que llego tarde de este lado
     *      - No hay autos
     *
     *      - Que pasa si solo hay autos de un solo lado, al principio de la ejecucion??
     *              *Si eso pasa ya no habria concurrencia, asi que no entra en consideracion.
     */
    
    private final Object monitorNorte = new Object(); //MONITORNORTE
    private final Object monitorSur = new Object(); //MONITORSUR
    private int cantNorte = 10; //Esto es para saber quien es el ultimo que pasa del norte
    private int cantSur = 10;   //Esto es para saber quien es el ultimo que pasa del sur
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

    public void entrarCocheDelNorte() throws InterruptedException {
        synchronized (monitorNorte) {

            esperaNor++;

            while (pasaronNor == 10) {
                monitorNorte.wait();
            }

            esperaNor--;

            pasaronNor++;
            cantNorte--;
            System.out.println("SALIENDO SUR");
        }
    }

    public void salirCocheDelNorte() throws InterruptedException {
        
        synchronized(monitorNorte){
            cantNorte++;
        
            if (cantNorte == 10) { //Soy el ultimo de los que puede pasar
                pasaronNor = 10;
                if (esperaSur != 0) { //Todavia hay autos en el sur
                    System.out.println("PASEN");
                    darPasoSur(0);
                } else { //No quedan autos en el sur
                    darPasoNorte(1);
                    
                }
            }
        }
    }

    public void entrarCocheDelSur() throws InterruptedException {
        synchronized (monitorSur) {

            esperaSur++;

            while (pasaronSur == 10) {
                monitorSur.wait();
            }

            esperaSur--;

            pasaronSur++;
            cantSur--;
            System.out.println("SALIENDO SUR");
        }
    }

    public void salirCocheDelSur() throws InterruptedException {
        synchronized (monitorSur) {
            cantSur++;

            if (cantSur == 10) { //Soy el ultimo de los que puede pasar
                pasaronSur = 10;
                if (esperaNor != 0) { //Todavia hay autos en el norte
                    darPasoNorte(0);
                } else { //No quedan autos en el norte
                    darPasoSur(1);
                }
            }
        }
    }

    private void darPasoSur(int n) {
        synchronized (monitorSur) {
            pasaronSur = n;
            monitorSur.notifyAll();
        }
    }

    private void darPasoNorte(int n) {
        synchronized (monitorNorte) {
            pasaronNor = n;
            monitorNorte.notifyAll();
        }
    }
}
