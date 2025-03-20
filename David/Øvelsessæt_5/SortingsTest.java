public class SortingsTest {
    public static void main(String[] args) {
        System.out.println("Test on insertstion sort with random, test passed?:" + random(new InsertionSort()));
    }

    public static boolean random(SortingAlgorithm sa) {
        Integer[] a = { 8, 4, 6, 1, 10 };
        sa.sort(a);
        return isSorted(a);

    }

    private static <T extends Comparable<T>> boolean isSorted(Integer[] a) {
        boolean sorted = true;
        int i = 1;
        while (i < a.length && sorted){
            sorted = a[i].compareTo(a[i-1]) >= 0 ;
            i++;
        }
        return sorted;
    }
}
