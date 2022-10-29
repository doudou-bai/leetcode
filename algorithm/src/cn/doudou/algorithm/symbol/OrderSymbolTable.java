package cn.doudou.algorithm.symbol;

/**
 * Create By 王嘉浩
 * Time 2022-10-23 15:02
 * <p>
 * 有序符号表的设计与实现
 */

public class OrderSymbolTable<Key extends Comparable<Key>, Value> {
    //记录首结点
    private Node head;
    //记录符号表中元素的个数
    private int N;

    private class Node {
        //键
        public Key key;
        //值
        public Value value;
        //下一个结点
        public Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public OrderSymbolTable() {
        this.head = new Node(null, null, null);
        this.N = 0;
    }

    /**
     * 获取符号表的个数
     *
     * @return N
     */
    public int size() {
        return N;
    }

    /**
     * 符号表中插入键值对
     *
     * @param key
     * @param value
     */
    public void put(Key key, Value value) {
        //定义两个Node变量，分别记录当前结点和当前结点的上一个结点

        Node curr = head.next;
        Node pre = head;
        while(curr!=null && key.compareTo(curr.key)>0){

            //变换当前结点和前一个结点即可
            pre = curr;
            curr = curr.next;
        }

        //如果当前结点curr的键和要插入的key一样，则替换
        if (curr!=null && key.compareTo(curr.key)==0){
            curr.value = value;
            return;
        }

        //如果当前结点curr的键和要插入的key不一样，把新的结点插入到curr之前
        Node newNode = new Node(key, value, curr);
        pre.next = newNode;

        //元素的个数+1；
        N++;

    }

    /**
     * 删除符号表的键值对
     *
     * @param key
     */
    public void delete(Key key) {
        Node n = head;
        while (n.next != null) {
            if (n.next.key.equals(key)) {
                n.next = n.next.next;
                N--;
                return;
            }
            //变化n
            n = n.next;
        }
    }


    /**
     * 根据键获得符号表的值
     *
     * @param key
     * @return value
     */
    public Value get(Key key) {
        Node n = head;
        while (n.next != null) {
            n = n.next;
            if (n.key.equals(key)) {
                return n.value;
            }
        }
        return null;
    }
}
