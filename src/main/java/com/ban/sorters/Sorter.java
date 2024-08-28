package com.ban.sorters;

import java.util.*;

public class Sorter {
    public void sort() {
        Motocicleta[] moto = new Motocicleta[10];
        for (int i = 0; i < moto.length; i++) {
            moto[i] = new Motocicleta();
        }
        BubbleSort bs = new BubbleSort(moto);
        InsertionSort insertion = new InsertionSort(moto);
        MergeSort merge = new MergeSort(moto);
        QuickSort quick = new QuickSort(moto);
        BinarySearch binarySearch = new BinarySearch(moto);
        System.out.println("Datos sin ordenar:");
        imprimir(moto);
        System.out.println("Datos ordenados con Bubble sort por marca:");
        bs.bubbleSort();
        imprimir(moto);
        System.out.println("Datos ordenados con Insertion sort por modelo:");
        insertion.insertionSort();
        imprimir(moto);
        System.out.println("Datos ordenados con Merge sort por Centimetros Cubicos:");
        merge.mergeSort(0, moto.length - 1);
        imprimir(moto);
        System.out.println("Datos ordenados con Quick sort por anio:");
        quick.quickSort(0, moto.length - 1);
        imprimir(moto);
        System.out.println("Datos ordenados con Quick sort por precio (en orden inverso):");
        Arrays.sort(moto, new OrdenarPrecio().reversed());
        imprimir(moto);
        System.out.println("Busqueda binaria por Centimetros Cubicos:");
        merge.mergeSort(0, moto.length - 1);
        imprimir(moto);
        System.out.println(binarySearch);
        System.out.println();
    }

    public static void imprimir(Motocicleta[] A) {
        int i = 0;
        System.out.println();
        for (Motocicleta m : A) {
            System.out.println("ID: " + i + " " + m);
            i++;
        }
    }
}
