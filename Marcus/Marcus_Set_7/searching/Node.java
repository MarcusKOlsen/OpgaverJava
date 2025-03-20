package searching;

public class Node<S,A> {
    private final S state;
    private final Node<S,A> parent;
    private final A action;
    private final double cost;

    public Node(S state) {
        this(state, null, null, 0);


    }

    public Node(S state, Node<S,A> parent, A action, double cost) {
            this.state = state;
            this.parent = parent;
            this.action = action;
            this.cost = cost;
    }

    public S state(){ return this.state; }
    public Node<S,A> parent() { return this.parent; }
    public A action(){ return this.action; }
    public Double cost() { return this.cost; }
}
