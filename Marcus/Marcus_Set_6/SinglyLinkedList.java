

public class SinglyLinkedList<E> implements MList<E> {
    Node head;
    int listlength = 1;

    Location penis = new Location(1,5,"din mor" );

    penis.add_location("din far");

    class Node {
        E value;
        Node next = null;

        public Node(E val) {
            this.value = val;
        }
    }

    public boolean add(E val) {
        if (this.head == null) {
            this.head = new Node(val);
            this.listlength++;
            return true;
        }
        else {
            // Iterates to the next node
            Node working = this.head.next;

            // While the next node is not empty
            while(working.next != null) {
                // Iterates to the next node
                working = working.next;
            }

            // Changes the next empty node to be equal to a new node with our given value.
            working.next = new Node(val);
            this.listlength++;
            return true;
        }
            
    }
    public void clear() {
        this.head.next = null;
        this.listlength = 1;
    }
    public boolean contains(Object o) {
        Node working = this.head;
        if(working.value.equals(o)) {
            return true;
        }
        
        else {
            // Control variable
            boolean found = false;

            // While the next node is not empty, and the object has not been found yet.
            while(working.next != null && !found) {
                // Make found true if the next value is equal to the object
                if(working.next.value.equals(o)) {
                    found = true;
                }
                else { 
                    // Iterate to the next node.
                    working = working.next;
                }
            }
            return found;
        }
    }
    public boolean remove(Object o) {
        Node working = this.head;
        boolean is_removed = false;

        if(working.value.equals(o)) {
            working = new Node(null);
            this.listlength = 0;
            return true;
        }
        else {
            while(working.next != null && !is_removed) {
                if(working.next.value.equals(o)) {
                    // Skips the next node, effectively removing it by removing any links to it.
                    working.next = working.next.next;
                    this.listlength--;
                    is_removed = true;
                }
                else {
                    // Iterate to the next node
                    working = working.next;
                }

            }
            return is_removed;

        }

    }
    public int size() {
        return this.listlength;
    }
    public boolean isEmpty(){
        return this.head == null;
    } 
    public E get(int index){
        Node working = this.head;
        for(int i = 0; i < index; i++) {
            working = working.next;
        }
        return working.value;
    }
    @Override
    public MListIterator<E> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }
}

