package cn.doudou.algorithm.test;

import cn.doudou.algorithm.sort.Bubble;
import cn.doudou.algorithm.sort.Insertion;
import cn.doudou.algorithm.sort.Shell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Create By 王嘉浩
 * Time 2022-09-04 22:48
 * <p>
 * 希尔排序的时间为:30毫秒
 * 插入排序的时间为:17360毫秒
 * 冒泡排序的时间为:22808毫秒
 */
public class SortCompare {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(SortCompare.class.getClassLoader().getResourceAsStream("reverse_arr.txt")));
        String line = null;
        while ((line = br.readLine()) != null) {
            list.add(Integer.parseInt(line));
        }
        br.close();

        Integer[] a = new Integer[list.size()];
        list.toArray(a);

        //testInsertion(a);
        //testShell(a);
        //testBubble(a);
    }

    //测试希尔排序
    public static void testShell(Integer[] arr) {
        long start = System.currentTimeMillis();
        Shell.sort(arr);
        long end = System.currentTimeMillis();
        System.out.println("希尔排序的时间为:" + (end - start) + "毫秒");
    }

    //测试冒泡排序
    public static void testBubble(Integer[] arr) {
        long start = System.currentTimeMillis();
        Bubble.sort(arr);
        long end = System.currentTimeMillis();
        System.out.println("冒泡排序的时间为:" + (end - start) + "毫秒");
    }

    //测试插入排序
    public static void testInsertion(Integer[] arr) {
        long start = System.currentTimeMillis();
        Insertion.sort(arr);
        long end = System.currentTimeMillis();
        System.out.println("插入排序的时间为:" + (end - start) + "毫秒");
    }
}
