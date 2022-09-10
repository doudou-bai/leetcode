package cn.doudou.algorithm.sort;

/**
 * Create By 王嘉浩
 * Time 2022-09-06 22:53
 * 快速排序的实现
 */
public class Quick {
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

    //对数组内的元素进行排序
    public static void sort(Comparable[] a) {
        int lo = 0;
        int hi = a.length - 1;

        sort(a, lo, hi);
    }

    //对数组a中从索引lo到索引hi之间的元素进行排序
    private static void sort(Comparable[] a, int lo, int hi) {
        //安全性校验
        if (lo >= hi) {
            return;
        }

        //需要对数组中lo索引到hi索引处的元素进行分组（左子组和右子组）
        int partition = partition(a, lo, hi);
        //让左子组有序 lo => partition-1
        sort(a, lo, partition - 1);
        //让右子组有序 partitio+1 =>hi
        sort(a, partition + 1, hi);
    }

    //对数组a中，从索引 lo到索引 hi之间的元素进行分组，并返回分组界限对应的索引
    public static int partition(Comparable[] a, int lo, int hi) {
        //定义一个临界值
        Comparable key = a[lo];

        //定义左右指
        int left = lo, right = hi + 1;

        //进行扫描数组如果right的值小于key的值那么就停止扫描.进行交换
        while (true) {
            while (less(key, a[--right])) {
                //证明扫描一遍都没有合适的
                if (right == lo) {
                    break;
                }
            }
            //进行扫描数组如果left的值大于key的值那么就停止扫描,进行交换
            while (less(a[++left], key)) {
                if (left == hi) {
                    break;
                }
            }
            if (left >= right) {
                break;
            } else {
                exch(a, left, right);
            }
        }
        exch(a, lo, right);
        return right;
    }

}
