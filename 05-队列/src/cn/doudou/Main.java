package cn.doudou;

import cn.doudou.circle.CircleQueue;

/**
 * Create By 王嘉浩
 * Time 2022-11-05 17:10
 */
public class Main {
    public void test1() {
         /*Queue<String> queue = new Queue<>();
        queue.enQueue("A");
        queue.enQueue("B");
        queue.enQueue("C");
        queue.enQueue("D");
        queue.enQueue("E");*/
        Deque<String> queue = new Deque<>();

        queue.enQueueFront("11");
        queue.enQueueFront("22");
        queue.enQueueRear("33");
        queue.enQueueRear("44");

        while (!queue.isEmpty()) {
            System.out.println(queue.deQueueRear());
        }
    }

    public static void main(String[] args) {
        CircleQueue<String> cq = new CircleQueue<>();
        cq.enQueue("AA");
        cq.enQueue("BB");
        cq.enQueue("CC");
        cq.enQueue("DD");
        cq.enQueue("EE");
        cq.enQueue("FF");
        cq.enQueue("GG");
        cq.enQueue("HH");
        cq.enQueue("II");
        cq.enQueue("JJ");
        cq.deQueue();
        cq.deQueue();
        cq.enQueue("11");
        cq.enQueue("22");
        cq.enQueue("33");
        System.out.println(cq.toString());
    }
}
