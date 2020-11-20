/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6.EJ_8_Hemoterapia;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author jerem
 */
public class SalaEspera {

    private int revistas = 9;
    private boolean camaLibre = false;
    private int turnoActual = 1;
    private int nroActual = 1;

    private Lock mutexRevista = new ReentrantLock();
    private Condition esperaRevista = mutexRevista.newCondition();
    private Condition esperaCama = mutexRevista.newCondition();
    private Condition esperaNoTurno = mutexRevista.newCondition();

    public int tomarTurno() throws InterruptedException {
        mutexRevista.lock();

        int num = nroActual;
        try {
            nroActual++;

            return num;
        } finally {
            mutexRevista.unlock();
        }
    }

    public boolean tomarRevista() throws InterruptedException {
        mutexRevista.lock();

        boolean tomada = false;
        try {
            if (revistas > 0) {
                revistas--;
                tomada = true;
            }

            return tomada;
        } finally {
            mutexRevista.unlock();
        }
    }

    public void esperarCama(boolean tomo, int turno) throws InterruptedException {
        mutexRevista.lock();
        try {

            while (!(turno != turnoActual)) {
                while (!camaLibre) {

                    if (tomo) {
                        esperaCama.await();
                        if (turno == turnoActual) {
                            revistas++;
                            esperaRevista.signalAll();
                        }
                    } else {
                        if (turno == turnoActual) {
                            tomo = tomarRevista();
                            esperaCama.await();
                            esperaRevista.signalAll(); /*NOTA AL PIE, REVISALA!!!*/
                        } else {
                            if (revistas > 0) {
                                tomo = tomarRevista();
                                if (!tomo) {
                                    esperaRevista.await();
                                }
                            }
                        }
                    }
                }

                esperaNoTurno.await();
            }

            turnoActual++;
            camaLibre = false;
            esperaNoTurno.signalAll();
        } finally {
            mutexRevista.unlock();
        }
    }

    public void notificarCama() {
        mutexRevista.lock();
        try {
            camaLibre = true;
            esperaCama.signalAll();
        } finally {
            mutexRevista.unlock();
        }
    }

    /**
     * Nota para el Jere del futuro:
     *
     * Porque SignalAll a revistas??, el no tomo revista
     *
     * Bien, yo me hice la siguiente pregunta: Qué pasa si el que tiene el turno
     * siguiente esta esperando tomar revista? - Asi es, se te bloquea todo
     *
     * Y ahora, te preguntas y por qué no quitas el esperarRevista.await() ?? -
     * Si no se lo estan preguntando, deberias cuestionar mas lo que ves - Si si
     * se lo estan preguntando, hay varias razones: - Si el siguiente no es mi
     * turno, yo quiero intentar tomar revista - Y no quiero hacer una espera
     * activa - Y el signal solo no me garantiza que se libere al siguiente .
     */
}
