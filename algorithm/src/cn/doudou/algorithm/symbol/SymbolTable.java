package cn.doudou.algorithm.symbol;

/**
 * Create By 王嘉浩
 * Time 2022-10-23 15:02
 * <p>
 * 符号表的设计与实现
 */

public class SymbolTable<Key, Value> {
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

    public SymbolTable() {
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
        Node n = head;
        //如果键已经存在的情况下 就直接替换值
        while (n.next != null) {
            n = n.next;
            if (n.key.equals(key)) {
                n.value = value;
                return;
            }
        }
        //如果不存在 就插入一个键值对
        Node newNode = new Node(key, value, null);
        Node oldNext = head.next;
        newNode.next = oldNext;
        head.next = newNode;
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
