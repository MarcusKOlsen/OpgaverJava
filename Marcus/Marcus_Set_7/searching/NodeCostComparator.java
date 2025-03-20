package searching;

import java.util.Comparator;

public class NodeCostComparator implements Comparator<Node<?,?>>{

    @Override
    public int compare(Node<?, ?> node1, Node<?, ?> node2) {
        return Double.compare(node1.cost(), node2.cost());
    }
    
}
