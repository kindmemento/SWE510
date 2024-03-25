package DoublyLinkedList;

public class DLLNode<V> {
    public V value;
    public DLLNode<V> prev;
    public DLLNode<V> next;

    public DLLNode(V value, DLLNode prev, DLLNode next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

    public V value() { return value; }
    public boolean hasPrev() { return prev != null; }
    public boolean hasNext() { return next != null; }
    public DLLNode prev() { return prev; }
    public DLLNode next() { return next; }
}