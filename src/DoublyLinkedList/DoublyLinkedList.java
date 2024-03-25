package DoublyLinkedList;

public class DoublyLinkedList<V> {
    private DLLNode<V> head = null;
    public int length = 0;

    public boolean isEmpty() { return head == null; }

    public DLLNode<V> first() { return head; }

    public void add(V val) {
        DLLNode<V> newNode = new DLLNode<V>(val, head, head);
        DLLNode<V> tmp = head;
        head = newNode;
        head.next = tmp;
        tmp.prev = head;
        length++;
    }

    public int getLength() { return length; }

    public void remove() throws NullPointerException {
        head = head.next;
    }
}