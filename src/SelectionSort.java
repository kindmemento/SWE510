import java.lang.System;

public class SelectionSort {
    public static void main(String[] args) {
        int[] my_arr = { 6, 5, 3, 1, 9, 12, 2 };

        int n = 7;

        for (int i = 0; i < n-1; i++) {
            int tmp_min = my_arr[i];
            int min_index = i;
            for (int j = i+1; j < n; j++) {
                if (my_arr[j] < tmp_min) {
                    tmp_min = my_arr[j];
                    min_index = j;
                }
            }
            my_arr[min_index] = my_arr[i];
            my_arr[i] = tmp_min;

            for (int j = 0; j < n; j++) {
                System.out.println(my_arr[j] + " ");
            }
        }
    }
}
