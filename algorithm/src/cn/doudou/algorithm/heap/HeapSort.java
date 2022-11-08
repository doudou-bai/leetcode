package cn.doudou.algorithm.heap;

/**
 * Create By 王嘉浩
 * Time 2022-11-05 15:07
 */
public class HeapSort {
    /**
     * 判断数组i索引的值是否小于j索引处的值
     *
     * @param heap
     * @param i
     * @param j
     * @return
     */
    private static boolean less(Comparable[] heap, int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;
    }

    /**
     * 交换数组i索引和j索引处的值
     *
     * @param heap
     * @param i
     * @param j
     */
    private static void exch(Comparable[] heap, int i, int j) {
        Comparable temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    /**
     * 根据原数组source，构造出堆heap
     *
     * @param source
     * @param heap
     */
    private static void createHeap(Comparable[] source, Comparable[] heap) {
        System.arraycopy(source, 0, heap, 1, source.length);

        for (int i = (heap.length) / 2; i > 0; i--) {
            sink(heap, i, heap.length - 1);
        }

    }


    /**
     * 对source数组中的数据从小到大排序
     *
     * @param source
     */
    public static void sort(Comparable[] source) {
        //构建堆
        Comparable[] heap = new Comparable[source.length + 1];
        createHeap(source, heap);
        //定义一个变量，记录未排序的元素中最大的索引
        int N = heap.length - 1;
        //通过循环，交换1索引处的元素和排序的元素中最大的索引处的元素
        while (N != 1) {
            //交换元素
            exch(heap, 1, N);
            //排序交换后最大元素所在的索引，让它不要参与堆的下沉调整
            N--;
            //需要对索引1处的元素进行对的下沉调整
            sink(heap, 1, N);
        }

        //把heap中的数据复制到原数组source中
        System.arraycopy(heap, 1, source, 0, source.length);

    }

    /**
     * 在heap堆中，对target处的元素做下沉，范围是0~range
     *
     * @param heap   堆数据
     * @param target 指定的索引,其实就是heap的长度/2
     * @param range  heap的长度
     */
    private static void sink(Comparable[] heap, int target, int range) {
        //指定索引*2的结果必须小于等于堆的长度
        while (2 * target <= range) {
            //新建一个变量储存最大的值
            int max;
            //指定索引*2+1的值必须小于等于堆的长度
            if (2 * target + 1 <= range) {
                if (less(heap, 2 * target, 2 * target + 1)) {
                    max = 2 * target + 1;
                } else {
                    max = 2 * target;
                }
            } else {
                //如果2*指定索引+1 大于堆的长度 我们就把2* targer的值赋值给max
                max = 2 * target;
            }
            if (!less(heap, target, max)) {
                break;
            }
            //交换heap中target索引和max索引位置的值
            exch(heap, target, max);

            //修改下target的值 下次循环准备
            target = max;
        }
    }
}
