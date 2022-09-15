package cn.doudou.algorithm.linear;

import java.util.Iterator;

public class TowWayLinkList<T> implements Iterable<T> {
    //首结点
    private Node head;
    //最后一个结点
    private Node last;

    //链表的长度
    private int N;

    //结点类
    private class Node {
        //存储数据
        public T item;
        //指向上一个节点
        public Node pre;
        //指向下一个节点
        public Node next;

        public Node(T item, Node pre, Node next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }

    public TowWayLinkList() {
        //初始化头节点
        this.head = new Node(null, null, null);
        //初始化尾节点
        this.last = null;
        //初始化元素的个数
        this.N = 0;
    }

    //清空链表
    public void clear() {
        //让头结点的next不在进行指向数据
        this.head.next = null;
        //让尾节点的pre不在向前指向数据
        this.last.pre = null;
        //清楚长度
        this.N = 0;
    }

    //获取链表长度
    public int length() {
        return N;
    }

    //判断链表是否为空
    public boolean isEmpty() {
        return N == 0;
    }

    //获取第一个元素
    public T getFirst() {
        if (isEmpty()) {
            return null;
        }
        return head.next.item;
    }

    //获取最后一个元素
    public T getLast() {
        if (isEmpty()) {
            return null;
        }
        return last.item;
    }

    //插入元素t
    public void insert(T t) {
        if (isEmpty()) {
            //如果链表为空
            //创建新的结点
            Node node = new Node(t, head, null);
            //修改尾结点的指向
            last = node;
            //让头结点的下一个节点指向last节点
            head.next = last;
        } else {
            //如果链表不为空
            Node oldLast = last;
            //创建新的结点
            Node newNode = new Node(t, oldLast, null);
            //让原来尾部结点的下一个节点指向新创建的这个节点
            oldLast.next = newNode;
            //修改尾结点为现在创建的节点
            last = newNode;
        }
        //元素个数加一
        N++;
    }

    //向指定位置i处插入元素t
    public void insert(int i, T t) {
        //找到指定位置的节点
        Node oldhead = head;
        for (int j = 0; j < i; j++) {
            oldhead = oldhead.next;
        }
        //找到指定位置的上一个节点
        Node preHead = oldhead.pre;
        //找到指定位置的下一个节点
        Node nextNext = oldhead.next;
        //创建新的结点
        Node newNode = new Node(t, preHead, nextNext);
        //修改上一个节点的next指向
        preHead.next = newNode;
        //修改下一个节点的per指向
        newNode.pre = newNode;
        //修改长度
        N++;
    }

    //获取指定位置i处的元素
    public T get(int i) {
        Node oldhead = head.next;
        for (int j = 0; j < i; j++) {
            oldhead = oldhead.next;
        }
        return oldhead.item;
    }

    //找到元素t在链表中第一次出现的位置
    public int indexOf(T t) {
        Node oldhead = head.next;
        for (int j = 0; oldhead.item != null; j++) {
            oldhead = oldhead.next;
            if (oldhead.item.equals(t)) {
                return j;
            }
        }
        return -1;
    }

    //删除位置i处的元素，并返回该元素
    public T remove(int i) {
        //找到i位置的前一个节点
        Node pre = head;
        for (int j = 0; j < i; j++) {
            pre = pre.next;
        }
        //找到i位置的节点
        Node curr = pre.next;
        //找到i位置下一个位置的节点
        Node nextNode = curr.next;
        //找到i位置前一个节点的下一个节点变为i位置的下一个节点
        pre.next = nextNode;
        //找到i位置下一个节点的上一个节点变为i位置的前一个节点
        nextNode.pre = pre;
        //修改长度
        N--;
        //返回数据
        return curr.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new TIterator();
    }

    private class TIterator implements Iterator {
        private Node n;

        public TIterator() {
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