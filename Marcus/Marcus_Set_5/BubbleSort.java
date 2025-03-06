public class BubbleSort implements SortingAlgorithm {
    public <T extends Comparable<T>> void sort(T[] arr) {
        int n = arr.length;
            for(int i = 0; i < n; i++) {
                for(int j = n - 1; j > (i); j--){
                    if (arr[j].compareTo(arr[j-1]) < 0) {
                        T temp = arr[j-1];
                        arr[j - 1] = arr[j];
                        arr[j] = temp;
                    }
                }
                
            }
        }
            
}

