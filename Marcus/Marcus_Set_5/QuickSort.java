public class QuickSort {
    public <T extends Comparable<T>> void sort(T[] arr, int left, int right) {
        if(left < right) {
            int q = partition(arr,left, right);
            this.sort(arr, left, q - 1);
            this.sort(arr, q + 1, right);
        }
    }
    private <T extends Comparable<T>> int partition(T[] arr, int left, int right) {

        T x = arr[right];
        int i = left - 1;

        for(int j = left; j > (right - 1); i++) {
            if(arr[j].compareTo(x) <= 0) {
                i++;
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp; 
            }
        }
        T temp = arr[i+1];
        arr[i+1] = arr[right];
        arr[right] = temp;
        return i++;
    }
}