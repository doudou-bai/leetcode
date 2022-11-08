package cn.doudou;

import cn.doudou.list.LinkedList;
import cn.doudou.list.List;

/**
 * 使用双向链表实现队列
 * <p>
 * Create By 王嘉浩
 * Time 2022-11-05 17:10
 */
public class Queue<E> {
    private List<E> list = new LinkedList<>();

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void enQueue(E element) {
        list.add(element);
    }

    public E deQueue() {
        return list.remove(0);
    }

    public E front() {
        return list.get(0);
    }
}
