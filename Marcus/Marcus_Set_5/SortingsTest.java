
public class SortingsTest {
    public static void test_int(SortingAlgorithm algo){
        Integer[] test_arr = {3,7,200,1};

        System.out.println("Before: ");
        for(int i = 0; i < test_arr.length; i++){
            System.out.println(Integer.toString(test_arr[i]));
        }
        algo.sort(test_arr);

        System.out.println("After: ");
        for(int i = 0; i < test_arr.length; i++){
            System.out.println(Integer.toString(test_arr[i]));
        }
        System.out.println(isSorted(test_arr));
    }

    public static void main(String[] args) {
        InsertionSort i = new InsertionSort();
        test_int(i);
    }

    static <T extends Comparable<T>> boolean isSorted(T[] a) {
        boolean sorted = true;
        int i = 1;
        while( i < a.length && sorted ) {
            sorted = a[i].compareTo(a[i-1]) >= 0;
            i++;
        }
        return sorted;
    }
}