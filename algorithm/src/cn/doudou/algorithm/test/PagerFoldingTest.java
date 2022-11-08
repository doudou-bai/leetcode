package cn.doudou.algorithm.test;

import cn.doudou.algorithm.linear.Queue;

/**
 * Create By 王嘉浩
 * Time 2022-11-02 9:00
 * <p>
 * 对于折纸问题的分析与实现
 */
public class PagerFoldingTest {
    public static void main(String[] args) {
        Node<String> tree = createTree(2);
        pintTree(tree);
    }

    public static Node<String> createTree(int N) {
        //通过代码进行模拟产生树
        Node<String> root = null;
        for (int i = 0; i < N; i++) {
            //判断是不是第一次添加
            if (i == 0) {
                root = new Node<>("down", null, null);
                continue;
            }
            //不是第一次进行添加
            Queue<Node> queue = new Queue<>();
            queue.enqueue(root);
            while (!queue.isEmpty()) {
                //弹出一个节点
                Node<String> dequeue = queue.dequeue();
                //判断队列如果有左子节点就把左子节点 放入队列中
                if (dequeue.left != null) {
                    queue.enqueue(dequeue.left);
                }
                //判断队列如果有右子节点就把右子节点 放入队列中
                if (dequeue.right != null) {
                    queue.enqueue(dequeue.right);
                }
                //如果同时没有左子节点和右子节点就需要给他们同时添加左子节点和右子节点
                if (dequeue.left == null && dequeue.right == null) {
                    dequeue.left = new Node("down", null, null);
                    dequeue.right = new Node("up", null, null);
                }
            }
        }
        return root;
    }

    public static void pintTree(Node<String> root) {
        //判断root是否为空
        if (root == null) {
            return;
        }
        //判断是否有左子节点
        if (root.left != null) {
            pintTree(root.left);
        }
        //打印当前节点
        System.out.print(root.item + "  ");

        //判断是否有右子节点
        if (root.right != null) {
            pintTree(root.right);
        }


    }

    //结点类
    private static class Node<T> {
        public T item;//存储元素
        public Node left;
        public Node right;

        public Node(T item, Node left, Node right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }

}
