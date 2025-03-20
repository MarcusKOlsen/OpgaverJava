package searching;

public interface SearchStrategy<S,A> {
    public Node<S,A> search(Problem<S,A> problem);
}
