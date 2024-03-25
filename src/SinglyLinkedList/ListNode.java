package SinglyLinkedList;

public class ListNode<V> {
    public V value;
    public ListNode<V> next;

    public ListNode(V value, ListNode<V> next) {
        this.value = value;
        this.next = next;
    }

    public V value() { return value; }
    public boolean hasNext() { return next != null; }
    public ListNode<V> next() { return next; }
}