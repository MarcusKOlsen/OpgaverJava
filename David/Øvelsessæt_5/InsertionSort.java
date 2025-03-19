package David.Øvelsessæt_5;


public class InsertionSort implements SortingAlgorithm {

    @Override
    public <T extends Comparable<T>> void sort(T[] a) {
        int n = a.length;

        for (int i = 1; i < n; i++) {
            T key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j].compareTo(key) == 1) {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = key;
        }
    }

}
