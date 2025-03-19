package David.Øvelsessæt_5;

public interface SortingAlgorithm {
    /**
    * Sorts the specified array of objects according to their natural order.
    * @param <T> the type of objects to be sorted
    * @param a the array to be sorted
    */
    public <T extends Comparable<T>> void sort(T[] a);
}
