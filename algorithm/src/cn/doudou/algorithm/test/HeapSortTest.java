package cn.doudou.algorithm.test;

import cn.doudou.algorithm.heap.HeapSort;

import java.util.Arrays;

/**
 * Create By 王嘉浩
 * Time 2022-11-05 16:47
 */
public class HeapSortTest {
    public static void main(String[] args) {
        //待排序数组
        String[] arr = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        HeapSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
