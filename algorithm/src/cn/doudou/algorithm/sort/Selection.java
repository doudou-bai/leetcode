package cn.doudou.algorithm.sort;

import java.util.Arrays;

/**
 * Create By 王嘉浩
 * Time 2022-09-03 22:30
 *
 * 选择排序的实现
 *
 */
public class Selection {
    public static void main(String[] args) {
        long l1 = System.currentTimeMillis();
        Integer[] arr = {2, 3, 1, 4, 5, 7, 6, 8, 10, 9};
        Comparable[] sort = sort(arr);
        System.out.println(Arrays.toString(sort));
        long l2 = System.currentTimeMillis();
        System.out.println(l2 - l1);
    }

    /**
     * 对数组进行排序的操作
     *
     * @param arr
     * @return
     */
    public static Comparable[] sort(Comparable[] arr) {
        for (int i = 0; i <= arr.length - 2; i++) {
            //假设i处就是最小值的索引
            int minIndex = i;
            //控制比较的后面的那位数
            for (int j = i + 1; j < arr.length; j++) {
                //如果后面的数小于预设最小索引的那个数字那么就交换2个数字的位置就可以
                if (greater(arr[minIndex], arr[j])) {
                    minIndex = j;
                }
            }
            exch(arr, minIndex, i);
        }
        return arr;
    }

    /**
     * 比较2个数字的大小
     *
     * @param v
     * @param w
     * @return
     */
    public static boolean greater(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }

    /**
     * 交换数组的位置
     *
     * @param a
     * @param i
     * @param j
     */
    public static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    /**
     * 普通版选择排序的实现过程
     *
     * @param arr
     * @return
     */
    public int[] ordinary(int[] arr) {
        //int[] arr = {2, 3, 1, 4, 5, 7, 6, 8, 10, 9};
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
        //返回数组
        return arr;
    }
}
