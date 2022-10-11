package cn.doudou.algorithm.linear;

import javax.xml.soap.Node;
import java.util.Iterator;

/**
 * Create By 王嘉浩
 * Time 2022-09-20 16:59
 * 栈的实现
 */
public class Stack<T> implements Iterable<T> {
    //记录首节点
    private Node head;
    //栈中元素的个数
    private int N;


    /**
     * Node的节点内部类
     */
    private class Node {
        public T item;
        public Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    /**
     * 初始化栈内部的元素
     */
    public Stack() {
        this.head = new Node(null, null);
        this.N = 0;
    }

    /**
     * 判断栈中元素的个数是不是为0
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 获取栈中元素的个数
     *
     * @return int
     */
    public int size() {
        return N;
    }

    /**
     * 把元素t压入栈中
     *
     * @param t
     */
    public void push(T t) {
        //找到首节点指向的第一个节点
        Node oldFirst = head.next;
        //创建新的节点
        Node newNode = new Node(t, null);
        //让首节点指向新的节点
        head.next = newNode;
        //让新的节点指向原来第一个节点
        newNode.next = oldFirst;
        //元素个数+1
        N++;
    }

    /**
     * 弹出定栈元素
     *
     * @return T
     */
    public T pop() {
        //找到首节点指向的第一个节点
        Node oldFirst = head.next;
        if (oldFirst == null) {
            return null;
        }
        //修改head的next的指向
        head.next = oldFirst.next;
        //元素个数-1
        N--;
        //弹出元素
        return oldFirst.item;
    }


    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator {
        private Stack.Node n;

        public SIterator() {
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.item;
        }
    }
}