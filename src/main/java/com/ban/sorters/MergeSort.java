package com.ban.sorters;

import java.util.*;

public class MergeSort {
    Motocicleta[] A;

    public MergeSort(Motocicleta[] A) {
        this.A = A;
    }

    public void mergeSort(int min, int max) {
        if (min < max) {
            int mid = (min + max) / 2;
            mergeSort(min, mid);
            mergeSort(mid + 1, max);
            merge(min, mid, max);
        }
    }

    public void merge(int min, int mid, int max) {
        int i;
        Vector<Motocicleta> B = new Vector<>();
        Vector<Motocicleta> C = new Vector<>();
        for (i = min; i <= mid; i++) {
            B.add(this.A[i]);
        }
        for (i = mid + 1; i <= max; i++) {
            C.add(this.A[i]);
        }
        i = min;
        while (!B.isEmpty() && !C.isEmpty()) {
            if (B.get(0).getCentimetrosCubicos() <= C.get(0).getCentimetrosCubicos()) {
                this.A[i++] = B.get(0);
                B.remove(0);
            } else {
                this.A[i++] = C.get(0);
                C.remove(0);
            }
        }
        while (!B.isEmpty()) {
            this.A[i++] = B.get(0);
            B.remove(0);
        }
        while (!C.isEmpty()) {
            this.A[i++] = C.get(0);
            C.remove(0);
        }
    }
}
