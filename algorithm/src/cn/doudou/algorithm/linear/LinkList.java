package cn.doudou.algorithm.linear;

import java.util.Iterator;

public class LinkList<T> implements Iterable<T> {
    //记录头结点
    private Node head;
    //记录链表的长度
    private int N;


    //结点类
    private class Node {
        //存储数据
        T item;
        //下一个节点
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    /**
     * 构造方法
     */
    public LinkList() {
        //初始化头结点
        this.head = new Node(null, null);
        //初始化元素个数
        this.N = 0;
    }

    //清空链表
    public void clear() {
        this.head.next = null;
        this.N = 0;
    }

    //获取链表的长度
    public int length() {
        return N;
    }

    //判断链表是否为空
    public boolean isEmpty() {
        return N == 0;
    }

    //获取指定位置i出的元素
    public T get(int i) {
        Node next = head.next;
        for (int j = 0; j < i; j++) {
            next = next.next;
        }
        return next.item;
    }

    //向链表中添加元素t
    public void insert(T t) {
        //设置临时头结点
        Node n = this.head;
        //遍历找到最后一个尾部结点
        while (n.next != null) {
            n = n.next;
        }
        //创建新的结点
        Node newNode = new Node(t, null);
        //将原来尾部结点的next指向新的结点就完后了插入操作
        n.next = newNode;
        //修改长度
        this.N++;
    }

    //向指定位置i出，添加元素t
    public void insert(int i, T t) {
        //找到i-1的节点
        Node pre = head;
        for (int j = 0; j < i - 1; j++) {
            pre = pre.next;
        }
        //找到i的节点
        Node curr = pre.next;
        //创建新的结点
        Node newNode = new Node(t, curr);
        pre.next = newNode;
        N++;
    }

    //删除指定位置i处的元素，并返回被删除的元素
    public T remove(int i) {
        //临时头部结点
        Node n = head;
        //找到i-1位置的节点
        for (int j = 0; j < i - 1; j++) {
            n = n.next;
        }
        //找到i位置的节点
        Node curr = n.next;
        //找到i+1位置的节点
        Node nextNode = curr.next;
        //将i-1节点的next变为i+1的节点
        n.next = nextNode;
        //将长度-1
        N--;
        //返回被删除的元素
        return curr.item;
    }

    //查找元素t在链表中第一次出现的位置
    public int indexOf(T t) {
        Node n = head;
        for (int i = 0; n.next != null; i++) {
            if (n.item == t) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new LIterator();
    }

    private class LIterator implements Iterator {
        private Node n;

        public LIterator() {
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
/*

    @Override
    public Iterator<T> iterator() {
    }

    private class LIterator implements Iterator {

    }

    //用来反转整个链表
    public void reverse() {


    }

    //反转指定的结点curr，并把反转后的结点返回
    public Node reverse(Node curr) {

    }

*/

}