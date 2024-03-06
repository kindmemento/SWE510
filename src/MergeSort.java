public class MergeSort {
    public static void main(String[] args) {
        int n = 4;
        int[] my_arr = new int[n];
        for (int i = 0; i < n; i++) {
            my_arr[i] = n-i;
        }
        print_array(my_arr, n);
        rec_divide_merge(my_arr, 0, n-1);
        print_array(my_arr, n);
    }

    public static void print_array(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    // No assumptions
    // Creates sorted a[s:e]
    public static void rec_divide_merge(int[] a, int s, int e) {
        if ((e-s) == 0) return;
        if ((e-s) == 1) return;
        int mid = (s+e)/2;
        rec_divide_merge(a, s, mid);
        rec_divide_merge(a, mid+1, e);
        merge_arrays(a, s, mid, mid+1, e);
        print_array(a, 4);
    }

    // Assumes a[s1:e1] and a[s2:e2] sorted
    // Creates sorted a[s1:e2]
    public static void merge_arrays(int[] a, int s1, int e1, int s2, int e2) {
        int new_n = e2 - s1 + 1;
        int[] new_arr = new int[new_n];
        int i = s1;
        int j = s2;
        int x = 0; // for new array
        while (true) {
            if (i == e1+1) {
                while (j <= e2) {
                    new_arr[x] = a[j];
                    j++; x++;
                }
                break;
            }
            if (j == e2+1) {
                while (i <= e1) {
                    new_arr[x] = a[i];
                    i++; x++;
                }
                break;
            }
            if (a[i] < a[j]) {
                new_arr[x] = a[i];
                i++; x++;
            } else {
                new_arr[x] = a[j];
                j++; x++;
            }
        }
        for (x = 0; x < new_n; x++) {
            a[s1+x] = new_arr[x];
        }
    }
}