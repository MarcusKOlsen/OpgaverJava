/**
 * A collection represents a group of objects, known as its elements. 
 * This interface is a simplified version of {@code java.utils.Collection}.
 * @param <E> the type of elements in this collection.
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html">java.utils.Collection</a>
 */
public interface MCollection<E> extends Iterable<E>{
  
  /**
   * Ensures that this collection contains the specified element
   * @param e element whose presence in this collection is to be ensured
   * @return true if this collection changed as a result of the call
   */
  boolean add(E e);
  
  /**
   * Removes all elements in this collection.
   */
  void clear();
  
  /**
   * Checks whether this collection contains o.
   * @param o element whose presence in this collection is to be tested
   * @return true if this collection contains the specified element
   */
  boolean contains(Object o);

  /**
   * Removes a single instance of the specified element from this collection, 
   * if it is present.
   * @param o element to be removed from this collection, if present
   * @return if an element was removed as a result of this call
   */  
  boolean remove(Object o);

  /**
   * Returns the number of elements in this collection.
   * @return the number of elements in this collection.
   */
  int size();

  /**
   * Checks whether this collection is empty.
   * @return true if this collection contains no elements.
   */
  boolean isEmpty();
}