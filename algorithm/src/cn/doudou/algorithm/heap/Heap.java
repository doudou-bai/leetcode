package cn.doudou.algorithm.heap;

/**
 * Create By 王嘉浩
 * Time 2022-11-02 14:37
 */
public class Heap<T extends Comparable<T>> {

    private T[] items;

    private int N;


    public Heap(int capacity) {
        this.items = (T[]) new Comparable[capacity+1];
        this.N = 0;
    }

    /**
     * 判断堆中索引i出的元素是否小于索引j处的元素
     *
     * @param i
     * @param j
     * @return
     */
    private boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }

    /**
     * 交换堆中i索引和j索引的值
     *
     * @param i
     * @param j
     */
    private void exch(int i, int j) {
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    /**
     * 向堆中插入一个元素
     *
     * @param t
     */
    public void insert(T t) {
        items[++N] = t;
        swim(N);
    }

    /**
     * 使用上浮算法对堆中的数据进行顺序的调整
     *
     * @param k
     */
    private void swim(int k) {
        while (k > 1) {
            if (less(k / 2, k)) {
                exch(k / 2, k);
            }
            k = k / 2;
        }
    }

    /**
     * 删除堆中最大的元素
     *
     * @return
     */
    public T delMax() {
        //创建临时变量存储最大值
        T max = items[1];
        //交换位置
        exch(1, N);
        //把最大的变量改为null
        items[N] = null;
        //长度减一
        N--;
        //使用下沉算法让堆里面的元素处于正确的位置
        sink(1);
        //返回最大值
        return max;
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int max;
            if (2 * k + 1 <= N) {
                if (less(2 * k, 2 * k + 1)) {
                    max = 2 * k + 1;
                } else {
                    max = 2 * k;
                }
            } else {
                max = 2 * k;
            }
            if (!less(k, max)) {
                break;
            }

            exch(k, max);
            k = max;
        }
    }

}
