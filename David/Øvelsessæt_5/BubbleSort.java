package David.Øvelsessæt_5;

public class BubbleSort implements SortingAlgorithm{

    @Override
    public <T extends Comparable<T>> void sort(T[] a) {
        for(int i = 0; i < a.length; i++){
            for(int j = a.length - 1; j > i+1;j--){
                if (a[j].compareTo(a[j-1]) < 0) {
                    T temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                }
            }
        }
    }
}
