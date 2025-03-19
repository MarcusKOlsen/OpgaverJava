public class SinglyLinkedList<E> implements MList<E> {
    Node head;
    int listlength; 

    

private class Node{
    E value;
    Node next;



    public Node(E value){
        this.value = value;
        this.next = null;
        
    }
}



    @Override
    public boolean add(E e){
        if (this.head == null){
            this.head = new Node(e);
        } else {
            Node current = this.head;
            while(current.next != null){
                current = current.next;
            }
            current.next = new Node(e);
            listlength++;
         }

        return true;
        
    }
    @Override
    public void clear(){
        this.head = null;
        this.listlength = 0;
    }
    @Override
    public boolean contains(Object o){
        boolean contains = false;
        Node current = this.head;
        if (this.head == null){
            return false;
        }
        else{ 
            
            while(current.next != null && !contains){
                contains = (o.equals(current.value));
            }
        }
        return contains;
    }
    @Override
    public boolean remove(Object o){
        Node current = this.head;
        Node last = null;
        boolean removed = false;
        if (this.head == null){
            return false;
        }
        else {
            while(current.next != null && !removed){
                if(o.equals(current.value)){
                    last.next = current.next;
                    removed = true;
                    }
                last = current;
                current = current.next;
                listlength--;
                }
             }
        return removed;
        }
    
    @Override
    public int size(){
        return listlength;
    }
    @Override
    public boolean isEmpty(){
        return head.equals(null);
    }
}