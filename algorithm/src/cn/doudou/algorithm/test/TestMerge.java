package cn.doudou.algorithm.test;

import cn.doudou.algorithm.sort.Merge;

import java.util.Arrays;

/**
 * Create By 王嘉浩
 * Time 2022-09-05 23:16
 */
public class TestMerge {
    public static void main(String[] args) {
        Integer[] arr = {1, 4, 0, 3, 2, 5, 6, 9, 7, 8};
        Merge.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
