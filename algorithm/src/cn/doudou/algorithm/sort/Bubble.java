package cn.doudou.algorithm.sort;

/**
 * Create By 王嘉浩
 * Time 2022-09-03 16:19
 *
 * 冒泡排序的实现方式
 */
public class Bubble {
    //对数组a中的元素进行排列
    public static void sort(Comparable[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (greater(a[j], a[j + 1])) {
                    exch(a, j, j + 1);
                }
            }
        }
    }

    //比较v和w的大小
    public static boolean greater(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }

    //交换i和j的位置
    public static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
