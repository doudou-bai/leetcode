package cn.doudou.algorithm.test;

import cn.doudou.algorithm.heap.Heap;

/**
 * Create By 王嘉浩
 * Time 2022-11-02 16:35
 */
public class HeapTest {
    public static void main(String[] args) {
        Heap<String> heap = new Heap<String>(10);

        heap.insert("A");
        heap.insert("B");
        heap.insert("C");
        heap.insert("D");
        heap.insert("E");
        heap.insert("F");
        heap.insert("G");

        String res = null;
        while ((res = heap.delMax()) != null) {
            System.out.print(res + "  ");
        }
    }
}
