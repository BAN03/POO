package com.ban.sorters;

import java.util.*;

public class Motocicleta {
    String marca;
    String modelo;
    int centimetrosCubicos, anio;
    double precio;
    String[] marcas = {
            "Honda", "Yamaha", "Kawasaki",
            "Suzuki", "BMW", "Ducati",
            "Harley-Davidson", "Triumph", "KTM",
            "Aprilia", "Moto Guzzi", "Royal Enfield",
            "Husqvarna", "Indian", "Benelli",
            "MV Agusta", "Bajaj", "CFMoto",
            "SYM", "Kymco"
    };
    String[] modelos = {
            "MT-09", "Ninja 400", "CBR500R",
            "GSX-R750", "S1000RR", "Panigale V4",
            "Iron 883", "Bonneville T120", "390 Duke",
            "RSV4", "V7", "Interceptor 650",
            "Vitpilen 401", "Scout", "TRK 502",
            "Brutale 800", "Pulsar NS200", "300NK",
            "Jet 14", "AK 550"
    };
    int[] tamanios = {
            50, 125, 150, 200, 250, 300,
            400, 500, 600, 750, 800, 900,
            1000, 1200, 1400, 1600, 1800, 2000
    };

    public Motocicleta() {
        Random rand = new Random();
        this.marca = marcas[rand.nextInt(marcas.length)];
        this.modelo = modelos[rand.nextInt(modelos.length)];
        this.centimetrosCubicos = tamanios[rand.nextInt(tamanios.length)];
        this.anio = rand.nextInt(37) + 1987;
        this.precio = rand.nextInt(28000000)/100 + 20000;
    }

    @Override
    public String toString() {
        return String.format("Marca: %s, Modelo: %s, CC: %s, Año: %s, Precio: %.2f",
                this.marca, this.modelo, this.centimetrosCubicos, this.anio, this.precio);
    }

    public String getMarca() {
        return this.marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public int getCentimetrosCubicos() {
        return this.centimetrosCubicos;
    }

    public int getAnio() {
        return this.anio;
    }

    public double getPrecio() {
        return this.precio;
    }
}

class OrdenarPrecio implements Comparator<Motocicleta> {
    @Override
    public int compare(Motocicleta m1, Motocicleta m2) {
        if (m2.getPrecio() - m1.getPrecio() > 0) {
            return 1;
        }
        if (m2.getPrecio() - m1.getPrecio() < 0) {
            return -1;
        }
        return 0;
    }
}