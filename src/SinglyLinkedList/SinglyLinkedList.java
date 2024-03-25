package SinglyLinkedList;

public class SinglyLinkedList<V> {
    private ListNode<V> head = null;
    private int length = 0;

    public boolean isEmpty() { return head == null; }

    public ListNode<V> first() { return head; }

    public ListNode<V> last() { return at(length - 1); }

    public void add(V val) {
        if (head == null) {
            head = new ListNode<V>(val, head);
            length++;
            return;
        }

        ListNode<V> lastNode = head;
        for (int x = 0; x < length; x++) {
            if (lastNode.next != null) {
                lastNode = lastNode.next;
            } else {
                break;
            }
        }
        lastNode.next = new ListNode<V>(val, null);
        length++;
    }

    public int getLength() {
        return length;
    }

    public ListNode<V> at(int index) {
        ListNode<V> curr = head;
        for (int x = 0; x < length; x++) {
            if (x != index) {
                curr = curr.next;
                continue;
            }
            return curr;
        }
        return curr;
    }

    public void remove() throws NullPointerException {
        ListNode<V> elToRemove = at(length - 1);
        elToRemove.next = null;
        length--;
    }

}