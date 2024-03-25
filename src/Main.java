import DoublyLinkedList.DoublyLinkedList;
import SinglyLinkedList.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        runSinglyLinkedList();
//        runDoublyLinkedList();
    }

    static void runSinglyLinkedList() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list.first().next.value);
        System.out.println("Current Length of List: " + list.getLength());
        System.out.println(list.at(1).value);
        list.remove();
        System.out.println(list.last().value);
        System.out.println("Current Length of List: " + list.getLength());
    }

    static void runDoublyLinkedList() {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
        dll.add(3);
        dll.add(2);
        dll.add(1);
        System.out.println(dll.first().value);
        System.out.println("Current Length of Doubly LinkedList: " + dll.getLength());
    }
}
