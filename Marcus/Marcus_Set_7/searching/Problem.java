package searching;



public interface Problem<S,A> {
    /**
     * Returns the initial state of this problem
     * @return S
     */
    public S initial();

    /**
     * 
     * @param state
     * @return true if the argument is a valid state in this problem.
     */
    public boolean isState(S state);
    public boolean isGoal(S state);
    public Iterable<A> actions(S state);
    public S result(S state, A action);
    public double cost(S state, A action);

}