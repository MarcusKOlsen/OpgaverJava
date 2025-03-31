class os_select {
    public class Node {
        int value;
        int size;
        Node left;
        Node right;
    }

    public static Node select(Node x, int i) {
        int r = x.left.size + 1;

        while(i != r) {
            r = x.left.size + 1;
            if(i < r) {
                x = x.left;
            }
            else {
                x = x.right;
                i = i - r;
            }
        }
        return x;
    }
}