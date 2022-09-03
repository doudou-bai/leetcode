package cn.doudou.algorithm.test;

import cn.doudou.algorithm.sort.Bubble;

import java.util.Arrays;

/**
 * Create By 王嘉浩
 * Time 2022-09-03 16:29
 */
public class TestBubble {
    public static void main(String[] args) {
        Integer[] arr = {2, 3, 1, 4, 6, 5};
        Bubble.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
