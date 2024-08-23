public class BinarySearch {
    Motocicleta[] A;

    public BinarySearch(Motocicleta[] A) {
        this.A = A;
    }

    public int binarySearch(int x) {
        int left = 0, right = this.A.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (this.A[mid].getCentimetrosCubicos() == x)
                return mid;
            if (this.A[mid].getCentimetrosCubicos() < x)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    @Override
    public String toString() {
        int index = binarySearch(250);
        if (index != -1) {
            return "La Moto de 250CC se encuentra en la posición: " + index;
        }
        return "No hay Moto de 250CC.";
    }
}
