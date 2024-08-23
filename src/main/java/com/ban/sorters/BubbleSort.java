package com.ban.sorters;

public class BubbleSort {
    Motocicleta[] A;

    public BubbleSort(Motocicleta[] A) {
        this.A = A;
    }

    public void bubbleSort() {
        int n = this.A.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (this.A[j].getMarca().compareToIgnoreCase(this.A[j + 1].getMarca()) > 0) {
                    Motocicleta temp = this.A[j];
                    this.A[j] = this.A[j + 1];
                    this.A[j + 1] = temp;
                }
            }
        }
    }
}
