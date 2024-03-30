package midterm;

import midterm.SinglyLinkedList.SinglyLinkedList;
import java.util.Scanner;

public class SortedLinkedListSearch {
    public static void main(String[] args) {
        // Scanner object to read input from the standard input
        Scanner scanner = new Scanner(System.in);

        // Empty sorted linked list
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        System.out.println("Enter integers for the sorted linked list (separate with spaces):");
        String input = scanner.nextLine();
        String[] inputArray = input.split("\\s+");

        // Parse the input and add integers to the sorted linked list
        for (String num : inputArray) {
            list.add(Integer.parseInt(num));
        }

        scanner.close();

        boolean found = binarySearch(list, 50);

        System.out.println("Is 50 in the list?: " + found);
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