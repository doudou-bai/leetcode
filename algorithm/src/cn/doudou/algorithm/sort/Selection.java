package cn.doudou.algorithm.sort;

import java.util.Arrays;

/**
 * Create By 王嘉浩
 * Time 2022-09-03 22:30
 */
public class Selection {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 4, 5, 7, 6, 8, 10, 9};
        //循环的次数为i-2次就可以
        for (int i = 0; i <= arr.length - 2; i++) {
            //假设i处就是最小值的索引
            int minIndex = i;
            //控制比较的后面的那位数
            for (int j = i + 1; j < arr.length; j++) {
                //如果后面的数小于预设最小索引的那个数字那么就交换2个数字的位置就可以
                if (arr[j] < arr[minIndex]) {
                    int temp = arr[j];
                    arr[j] = arr[minIndex];
                    arr[minIndex] = temp;
                }
            }
        }
        //输出数组
        System.out.println(Arrays.toString(arr));
    }
}
