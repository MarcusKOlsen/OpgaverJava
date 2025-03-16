public class MStack<E> implements MList<E> {
    Node head;
    int length = 1;

    class Node{
        E value;
        Node above;
        Node below;
        
        public Node(E val, Node over, Node under){
            this.value = val;
            this.above = over;
            this.below = under;
        }

        public Node(E val, Node under) {
            this.value = val;
            this.below = under;
        }

        public Node(E val) {
            this.value = val;
        }

    }
    public boolean add(E e) {
        if(this.head.equals(null)) 
        {
            this.head = new Node(e);
            this.length++;
        }
        else 
        {
            Node node_to_add = new Node(e, this.head);
            this.head.above = node_to_add;

            this.head = node_to_add;

        }

        // Increases the length int of the list.
        length++;
        return true;
    }
    public E get(int index) {
        // TODO: find ud af try & catch ting for at gøre dette bedre.
        if(index >= this.length) 
        {
            System.out.println("The index is out of the range of the stack. ");
        }

        Node current_node = this.head;

        for(int i = 0; i < index; i++) 
        {
            current_node = current_node.below;
        }
        return current_node.value;
    }
    @Override
    public void clear() {
       this.head.below = null;
    }
    @Override
    public boolean contains(Object o) {
        Node current_node = new Node(this.head.value, this.head.above, this.head.below);
        // Runs through every node in the stack and returns true if it finds the matching object.
        while(current_node.below != null)
        {
            if(current_node.value.equals(o))
            {
                return true;
            }
            
            current_node = current_node.below;
        }
        // At the end of the while loop, returns false if it never found the object.
        return false;
    }
    @Override
    public boolean remove(Object o) {
        Node current_node = new Node(this.head.value, this.head.above, this.head.below);

        // Runs through every node in the stack and returns true if it finds the matching object.
        while(current_node.below != null)
        {
            if(current_node.value.equals(o))
            {
                /*  Effectively removes the current node from the stack by making the 
                 *  Node above look the one under it instead,
                 *  And making the node below look at the node above instead.
                */
                current_node.below.above = current_node.above;
                current_node.above.below = current_node.below;
                this.length--;
                return true;

            }
            
            current_node = current_node.below;
        }
        // At the end of the while loop, returns false if it never found the object.
        return false;
    }
    @Override
    public int size() {
        return this.length;
    }
    @Override
    public boolean isEmpty() {
        return this.length == 1 && this.head.value == null;
    }
    @Override
    public MListIterator<E> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

    public void push(E e) {
        this.add(e);
    }

    public E peek(){
        return this.head.value;
    }

    public E pop(){
        E value_to_remove = new Node(this.head.value, this.head. above, this.head.below).value;
        this.remove(this.head.value);
        return value_to_remove;
    }   
}
