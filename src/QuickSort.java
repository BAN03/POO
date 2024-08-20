public class QuickSort {
    Motocicleta[] A;

    public QuickSort(Motocicleta[] A) {
        this.A = A;
    }

    public void quickSort(int ini, int fin) {
        if (ini < fin) {
            int pvt = divide(ini, fin);
            quickSort(ini, pvt - 1);
            quickSort(pvt + 1, fin);
        }
    }

    int divide(int ini, int fin) {
        Motocicleta pvt = this.A[ini];
        int izq = ini;
        int der = fin;
        Motocicleta temp;
        while (izq < der) {
            while (this.A[der].getAnio() > pvt.getAnio()) {
                der--;
            }
            while (izq < der && this.A[izq].getAnio() <= pvt.getAnio()) {
                izq++;
            }
            if (izq < der) {
                temp = this.A[izq];
                this.A[izq] = this.A[der];
                this.A[der] = temp;
            }
        }
        temp = this.A[der];
        this.A[der] = this.A[ini];
        this.A[ini] = temp;
        return der;
    }
}
