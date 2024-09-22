package com.ban03;

import java.util.Random;
import java.util.ArrayList;
import java.util.Comparator;

public class Alumnos {
    Random random = new Random();
    private double[] calificaciones = { (random.nextDouble() * 10), (random.nextDouble() * 10),
            (random.nextDouble() * 10), (random.nextDouble() * 10), (random.nextDouble() * 10) };
    public ArrayList<Integer> mesas = new ArrayList<Integer>();
    public double Calificacion = 0.0;
    private String nombre;

    public Alumnos(String nombre) {
        this.nombre = nombre;
        for (int i = 0; i < 5; i++) {
            this.mesas.add(i);
        }
    }

    public void cambioMesa(int numeroDeMesa) {
        this.mesas.remove(this.mesas.indexOf(numeroDeMesa));
        this.Calificacion = calificaciones[numeroDeMesa];
    }

    @Override
    public String toString() {
        return String.format(
                "{Alumno: %s, linguistica: %.2f, musical: %.2f, matematica: %.2f, espacial: %.2f, kinestesica: %.2f}%n",
                this.nombre, this.calificaciones[0],
                this.calificaciones[1], this.calificaciones[2],
                this.calificaciones[3], this.calificaciones[4]);
    }
}

class MasAlta implements Comparator<Alumnos> {
    @Override
    public int compare(Alumnos a1, Alumnos a2) {
        if (a1.Calificacion > a2.Calificacion) {
            return 1;
        }
        if (a1.Calificacion < a2.Calificacion) {
            return -1;
        }
        return 0;
    }
}
