package cn.doudou.algorithm.sort;

import java.util.Arrays;

/**
 * Create By 王嘉浩
 * Time 2022-09-04 15:57
 * <p>
 *
 */
public class Insertion {

    public static void main(String[] args) {
        Integer[] arr = {2, 3, 1, 4, 5, 7, 6, 8, 10, 9};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void sort(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (greater(arr[j - 1], arr[j])) {
                    exch(arr, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }

    private static boolean greater(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
