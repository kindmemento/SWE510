package midterm;

import midterm.SinglyLinkedList.SinglyLinkedList;

public class SortedLinkedListSearch {
    public static void main(String[] args) {
        // @TODO: Implement main method
    }

    public static boolean binarySearch(SinglyLinkedList<Integer> list, int target) {
        int left = 0;
        int right = list.getLength() - 1;
        int traversedNodes = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = list.get(mid);

            if (midValue == target) {
                System.out.println("Number of traversed nodes: " + (traversedNodes + 1));
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

            traversedNodes++;
        }

        System.out.println("Number of traversed nodes: " + traversedNodes);
        return false;
    }
}