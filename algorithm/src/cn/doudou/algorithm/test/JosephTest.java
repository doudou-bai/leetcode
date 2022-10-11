package cn.doudou.algorithm.test;

public class JosephTest {
    public static void main(String[] args) {
        //约瑟夫问题
        //构建循环链表
        //存储首个节点
        Node<Integer> first = null;
        //存储记录的前一个节点
        Node<Integer> pre = null;
        for (int i = 1; i <= 41; i++) {
            //如果是首节点
            if (i == 1) {
                first = new Node<>(i, null);
                pre = first;
                continue;
            }
            //如果不是首节点
            Node<Integer> newNode = new Node<>(i, null);
            pre.next = newNode;
            pre = newNode;
            //如果是尾节点
            if (i == 41) {
                pre.next = first;
            }
        }
        //需要count计数器 模拟报数
        int count = 0;
        //遍历循环列表
        //记录每次拿到的节点 默认从首节点开始
        Node<Integer> n = first;
        //记录当前节点的上一个节点
        Node<Integer> before = null;
        while (n != n.next) {
            //模拟报数
            count++;
            //判断当前报数是不是3
            if (count == 3) {
                //如果是3就删除节点并打印节点 重置计数器 让当前节点进行后移
                before.next = n.next;
                System.out.print(n.item + ",");
                count = 0;
                n = n.next;
            } else {
                //如果不是3就让当前节点后移 让before变成当前节点
                before = n;
                n = n.next;
            }
        }
        System.out.println(n.item);
    }


    //结点类
    private static class Node<T> {
        //存储数据
        T item;
        //下一个结点
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
