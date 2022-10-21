package cn.doudou.algorithm.test;

import cn.doudou.algorithm.linear.Queue;

/**
 * Create By 王嘉浩
 * Time 2022-10-21 16:04
 */
public class QueueTest {
    public static void main(String[] args) {
        //创建队列对象
        Queue<String> qs = new Queue<>();
        //测试插入
        qs.enqueue("a");
        qs.enqueue("b");
        qs.enqueue("c");
        qs.enqueue("d");
        qs.enqueue("e");
        //测试删除
        qs.dequeue();
        qs.dequeue();

        for (String q : qs) {
            System.out.println(q);
        }
    }
}
