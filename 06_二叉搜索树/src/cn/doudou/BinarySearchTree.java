package cn.doudou;

/**
 * 二叉搜索树的实现
 * <p>
 * Create By 王嘉浩
 * Time 2022-11-12 14:35
 */

import cn.doudou.printer.BinaryTreeInfo;

import javax.sound.midi.MidiFileFormat;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 我们在对于二叉搜索树的比较设计方法中我们可以使用二种方法进行编写
 * <p>
 * 方法一:
 * 创建一个Comparable接口定义一个compareTo的方法
 * 然后让二叉搜索树的泛型进行集成这个接口 然后我们定义比较规则
 * 主要是比较简单的 但是这个方法比较单一
 * <p>
 * <p>
 * 方法二
 * 创建一个Comparator的比较器 然后提供一个compare的方法
 * 然后让提供一个内部类实现这个接口的方法进行定义比较规则
 * 最后在把这个比较规则传给二叉搜索树
 */
public class BinarySearchTree<E> implements BinaryTreeInfo {
    private int size;
    //根节点
    private Node<E> root;
    private Comparator<E> comparator;

    BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    BinarySearchTree() {
        this(null);
    }

    /**
     * 二叉搜索树的长度
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 是否为空
     *
     * @return
     */
    public Boolean isEmpty() {
        return size == 0;
    }

    /**
     * 清空
     */
    public void clear() {

    }

    /**
     * 添加元素
     *
     * @param element
     */
    public void add(E element) throws IllegalAccessException {
        //检测元素是否为空
        elementNotNullCheck(element);
        //如果root为空那么就添加为根节点
        if (root == null) {
            root = new Node<>(element, null);
            size++;
            return;
        }
        //添加的不是根节点
        //父节点初始化
        Node<E> parent = root;
        Node<E> node = root;
        //比较的结果
        int cmp = 0;
        while (node != null) {
            cmp = compare(element, node.element);

            parent = node;

            if (cmp > 0) {//大于
                node = node.right;
            } else if (cmp < 0) {//小于
                node = node.left;
            } else {//等于
                node.element = element;
                return;
            }
        }
        //创建新的节点
        Node<E> eNode = new Node<>(element, parent);
        if (cmp > 0) {//向左子节点进行添加
            parent.right = eNode;
        } else if (cmp < 0) {//向右子节点进行添加
            parent.left = eNode;
        }
    }


    /**
     * 删除元素
     *
     * @param element
     */
    public void remove(E element) {

    }

    /**
     * 是否包含某个元素
     *
     * @param element
     * @return
     */
    public boolean contains(E element) {
        return false;
    }

    private void elementNotNullCheck(E element) throws IllegalAccessException {
        if (element == null) {
            throw new IllegalAccessException("参数为空!!!");
        }
    }

    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>) node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>) node).right;
    }

    @Override
    public Object string(Object node) {
        return ((Node<E>) node).element;
    }


    /**
     * 通过递归方式实现前序遍历
     */
    public void preorderTraversal(Visitor<E> visitor) {
        preorderTraversal(root, visitor);
    }

    private void preorderTraversal(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor.stop) return;
        visitor.stop = visitor.visit(node.element);
        preorderTraversal(node.left, visitor);
        preorderTraversal(node.right, visitor);
    }

    /**
     * 通过递归方式实现中序遍历
     */
    public void inorderTraversal(Visitor<E> visitor) {
        inorderTraversal(root, visitor);
    }

    private void inorderTraversal(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor.stop) return;
        inorderTraversal(node.left, visitor);
        if (visitor.stop) return;
        visitor.stop = visitor.visit(node.element);
        inorderTraversal(node.right, visitor);
    }

    /**
     * 通过递归方式实现后序遍历
     */
    public void postorderTraversal(Visitor<E> visitor) {
        postorderTraversal(root, visitor);
    }

    private void postorderTraversal(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor.stop) return;
        postorderTraversal(node.left, visitor);
        postorderTraversal(node.right, visitor);
        if (visitor.stop) return;
        visitor.stop = visitor.visit(node.element);
    }


    /**
     * 层序遍历
     * <p>
     * 实现思路:
     * 根据传入进来节点 判断是否为空
     * 然后创建一个队列 先把头节点添加进去
     * 然后一直循环 让队列弹出一个节点 打印一下节点的元素
     * 判断下左右子节点是否为弄 如果不为空那就把左右子节点添加到队列中继续循环
     */
    public void levelorderTranversal() {
        if (root == null) return;

        //创建队列
        Queue<Node> queue = new LinkedList<>();
        //先把头结点入队
        queue.offer(root);

        //如果队列不为空 那就一直循环
        while (!queue.isEmpty()) {
            //去除队列的节点
            Node node = queue.poll();
            //打印节点
            System.out.println(node.element);
            //判断node 的左子节点不为空 就把node的左子节点进行添加到队列中
            if (node.left != null) {
                queue.offer(node.left);
            }
            //判断node 的右子节点不为空 就把node的左子节点进行添加到队列中
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public void levelorder(Visitor visitor) {
        if (root == null || visitor == null) return;
        //创建队列
        Queue<Node> queue = new LinkedList<>();
        //先把头结点入队
        queue.offer(root);
        //如果队列不为空 那就一直循环
        while (!queue.isEmpty()) {
            //去除队列的节点
            Node node = queue.poll();
            //节点
            if (visitor.visit(node.element)) return;
            //System.out.println(node.element);
            //判断node 的左子节点不为空 就把node的左子节点进行添加到队列中
            if (node.left != null) {
                queue.offer(node.left);
            }
            //判断node 的右子节点不为空 就把node的左子节点进行添加到队列中
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public static abstract class Visitor<E> {
        boolean stop;

        abstract boolean visit(E element);
    }

    /**
     * 获得二叉搜索树的最大高度
     *
     * @return int
     */
    public int height() {
        return height(root);
    }

    public int height(Node<E> node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    /**
     * 判断是否为完全二叉树
     *
     * @return
     */
    public boolean isComplete() {
        //判断二叉搜索树是否为空
        if (root == null) return false;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        boolean leaf = false;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (leaf && !node.isLeaf()) return false;

            if (node.left != null) {
                queue.offer(node.left);
            } else if (node.right != null) {
                return false;
            }

            if (node.right != null) {
                queue.offer(node.right);
            } else {
                leaf = true;
            }
        }
        return true;
    }

    /*public boolean isComplete() {
        //判断二叉搜索树是否为空
        if (root == null) return false;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        boolean leaf = false;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (leaf && (!poll.isLeaf())) {
                return false;
            }

            if (poll.hasTuoChildren()) {
                queue.offer(poll.left);
                queue.offer(poll.right);
            } else if (poll.left == null && poll.right != null) {
                return false;
            } else {
                leaf = true;
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
            }
        }
        return true;
    }*/


    /**
     * e1>e2 返回 1
     * e1<e2 返回-1
     * e1==e2 返回0
     *
     * @param e1
     * @param e2
     * @return
     */
    private int compare(E e1, E e2) {
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }
        return ((Comparable<E>) e1).compareTo(e2);
    }

    /**
     * 成员内部类
     * 我们实现二叉搜索树的时候需要维护一个内部的节点类进行实现
     *
     * @param <E>
     */
    private static class Node<E> {
        //储存的元素
        E element;
        //左边的子节点
        Node<E> left;
        //右边的子节点
        Node<E> right;
        //父节点
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        public boolean hasTuoChildren() {
            return left != null && right != null;
        }
    }

}
