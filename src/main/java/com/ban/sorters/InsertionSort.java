package com.ban.sorters;

public class InsertionSort {
    Motocicleta[] A;

    public InsertionSort(Motocicleta[] A) {
        this.A = A;
    }

    public void insertionSort() {
        int n = this.A.length;
        for (int i = 1; i < n; i++) {
            Motocicleta val = this.A[i];
            int j = i - 1;
            while (j >= 0 && this.A[j].getModelo().compareToIgnoreCase(val.getModelo()) > 0) {
                this.A[j + 1] = this.A[j];
                j--;
            }
            this.A[j + 1] = val;
        }
    }
}
