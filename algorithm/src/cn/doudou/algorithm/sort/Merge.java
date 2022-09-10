package cn.doudou.algorithm.sort;

import java.util.ArrayList;

/**
 * Create By 王嘉浩
 * Time 2022-09-05 22:57
 * 归并排序的实现
 */
/**
 * 归并排序的思想分析
 * 首先给我们一个数组,然后把数组分为一个一个的分区后,
 * 对每个分区的相邻位置的元素进行倒叙的比较后=>进行排序=>重组元素,
 * 一直递归完成
 * 然后再把辅助元素的数组拷贝到原数组
 */
public class Merge {
    //归并所需要的辅助数组
    private static Comparable[] assist;

    /*
     比较v元素是否小于w元素
    */
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /*
    数组元素i和j交换位置
    */
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * 对数组中的a进行排序
     *
     * @param a 数组
     */
    public static void sort(Comparable[] a) {
        //初始化辅助数组的长度
        assist = new Comparable[a.length];
        //定义一个lo变量，和hi变量，分别记录数组中最小的索引和最大的索引；
        int lo = 0;
        int hi = a.length - 1;
        //调用sort重载方法完成数组a中，从索引lo到索引hi的元素的排序
        sort(a, lo, hi);
    }

    /**
     * 对数组a中从lo到hi的元素进行排序
     *
     * @param a  数组
     * @param lo 最小索引
     * @param hi 最大索引
     */
    private static void sort(Comparable[] a, int lo, int hi) {
        //做个安全的检验 如果最小值大于最大值的话我们直接return空即可
        if (hi <= lo) {
            return;
        }

        //对lo到hi之间的数据进行分为2组
        int mid = lo + (hi - lo) / 2;
        System.out.println("分组的数:" + mid + "&hi=" + hi + "&lo=" + lo);

        //分别对每个数组的数据进行排列
        sort(a, lo, mid);
        sort(a, mid + 1, hi);

        //两个数组进行归并的操作
        merge(a, lo, mid, hi);
    }

    /**
     * 对2个数组的数据进行归并操作
     *
     * @param a   数组
     * @param lo  最小值
     * @param mid 分组的数
     * @param hi  最大值
     */
    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        /**
         * 定义三个指针
         * i 临时数组的指针
         * p1 左数组的指针
         * p2 右数组的指针
         */
        int i = lo;
        int p1 = lo;
        int p2 = mid + 1;

        while (p1 <= mid && p2 <= hi) {
            if (less(a[p1], a[p2])) {
                assist[i++] = a[p1++];
            } else {
                assist[i++] = a[p2++];
            }
        }

        //假如一个数组现行赋完成纳那么移动另一个数组进行移动操作
        while (p1 <= mid) {
            System.out.println("p1等于:" + p1);
            System.out.println("mid等于:" + mid);
            assist[i++] = a[p1++];
        }
        while (p2 <= hi) {
            System.out.println("p2等于:" + p2);
            System.out.println("hi等于:" + hi);
            assist[i++] = a[p2++];
        }

        //吧辅助数组中的元素进行拷贝到原数组中
        for (int index = lo; index <= hi; index++) {
            a[index] = assist[index];
        }
    }
}
