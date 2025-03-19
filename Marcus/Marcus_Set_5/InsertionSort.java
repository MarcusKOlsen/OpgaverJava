public class InsertionSort implements SortingAlgorithm {
    public <T extends Comparable<T>> void sort(T[] arr) {
        int arr_length = arr.length;
        for(int i = 1; i < arr_length; i++) {
            T key = arr[i];
            int j = i - 1;

            while(j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
}
