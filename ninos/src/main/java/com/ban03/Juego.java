package com.ban03;

import java.util.PriorityQueue;
import java.util.Random;

import javafx.scene.control.TextArea;

public class Juego {
    private PriorityQueue<Alumnos>[] mesas = new PriorityQueue[5];
    private boolean isFirst = true;
    private Alumnos[] alumnos;
    private TextArea[] textos;

    public Juego(Alumnos[] alumnos, TextArea[] textos) {
        for (int i = 0; i < 5; i++) {
            this.mesas[i] = new PriorityQueue<Alumnos>(new MasAlta());
        }
        this.alumnos = alumnos;
        this.textos = textos;
    }

    public void etapas() {
        if (this.isFirst) {
            this.isFirst = false;
            for (Alumnos alumno : this.alumnos) {
                checarExistencia(alumno);
            }
        } else {
            this.alumnos = new Alumnos[5];
            for (int i = 0; i < 5; i++) {
                if (!this.mesas[i].isEmpty()) {
                    this.alumnos[i] = this.mesas[i].poll();
                }
            }
            for (int i = 0; i < 5; i++) {
                if (this.alumnos[i] != null) {
                    checarExistencia(this.alumnos[i]);
                }
            }
        }
        imprimirMesas();
    }

    public void checarExistencia(Alumnos alumno) {
        Integer[] mesasDisponibles = alumno.mesas.toArray(new Integer[alumno.mesas.toArray().length]);
        if (mesasDisponibles.length != 0) {
            int mesagenerada = mesasDisponibles[new Random().nextInt(mesasDisponibles.length)];
            this.mesas[mesagenerada].add(alumno);
            alumno.cambioMesa(mesagenerada);
        } else {
            this.textos[6].appendText(alumno.toString());
        }
    }

    public void imprimirMesas() {
        for (int i = 0; i < 5; i++) {
            this.textos[i].clear();
            if (!this.mesas[i].isEmpty()) {
                this.textos[i].appendText(this.mesas[i].toString());
            }
        }
    }
}
