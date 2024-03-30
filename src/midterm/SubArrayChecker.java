package midterm;

public class SubArrayChecker {
    public static boolean mySubArray(int[] arr1, int[] arr2) {
        // Array lengths
        int m = arr1.length;
        int n = arr2.length;

        // Traverse both arrays
        int i = 0, j = 0;
        while (i < m && j < n) {
            // If the current elements match, move to the next element in both arrays
            if (arr1[i] == arr2[j]) {
                i++;
            }
            j++;
        }

        // If all elements of the first array have been traversed, it's a subarray
        return i == m;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3 };
        int[] arr2 = { 2, 3, 5, 1, 2, 3, 4, 5 };
        int[] arr3 = { 1, 2, 9, 11 };

        // Check if arr1 is a subarray of arr2
        boolean result = mySubArray(arr1, arr2);

        // Check if arr3 is a subarray of arr2
        boolean result2 = mySubArray(arr3, arr2);

        System.out.println("Is arr1 a subarray of arr2?: " + result);
        System.out.println("Is arr3 a subarray of arr2?: " + result2);
    }
}