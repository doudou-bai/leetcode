package cn.doudou.algorithm.sort;

import java.util.Arrays;

/**
 * Create By 王嘉浩
 * Time 2022-09-04 16:41
 * 希尔排序的实现
 */
public class Shell {

    public static void main(String[] args) {
        Integer[] arr = {2, 3, 1, 4, 5, 7, 6, 8, 10, 9};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(Comparable[] arr) {
        //首先确定h的值
        int h = 1;
        while (h < arr.length / 2) {
            h = 2 * h + 1;
        }
        //希尔排序
        while (h >= 1) {
            //排序
            //找到代插入的元素
            for (int i = h; i < arr.length; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (greater(arr[j-h], arr[j])) {
                        exch(arr, j-h, j);
                    } else {
                        break;
                    }
                }
            }
            //减小h的值
            h = h / 2;
        }
    }

    public static boolean greater(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
