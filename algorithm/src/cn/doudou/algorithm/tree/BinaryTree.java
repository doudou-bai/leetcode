package cn.doudou.algorithm.tree;

/**
 * Create By 王嘉浩
 * Time 2022-10-24 14:38
 */
public class BinaryTree<Key extends Comparable<Key>, Value> {
    //记录根结点
    private Node root;
    //记录树中元素的个数
    private int N;

    private class Node {
        //存储键
        public Key key;
        //存储值
        private Value value;
        //记录左子结点
        public Node left;
        //记录右子结点
        public Node right;

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 获取书中的元素个数
     *
     * @return
     */
    public int size() {
        return N;
    }

    /**
     * 向书中添加元素
     *
     * @param key
     * @param value
     */
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    /**
     * 向x树中插入key-value并返回添加元素后的树
     *
     * @param x
     * @param key
     * @param value
     */
    public Node put(Node x, Key key, Value value) {
        //如果x为空
        if (x == null) {
            N++;
            return new Node(key, value, null, null);
        }
        //如果x不为空
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            //如果key大于x节点的键,则继续找x节点的右子树
            x.right = put(x.right, key, value);
        } else if (cmp < 0) {
            //如果key小于x节点的键,则继续找x节点的左子树
            x.left = put(x.left, key, value);
        } else {
            //如果key等于x节点的键,则替换x节点的值为value即可
            x.value = value;
        }
        return x;
    }

    /**
     * 查找树中指定key的值
     *
     * @param key
     * @return
     */
    public Value get(Key key) {
        return get(root, key);
    }

    /**
     * 从指定的树中查找key的值
     *
     * @param x
     * @param key
     * @return Value
     */
    private Value get(Node x, Key key) {
        //x树为null
        if (x == null) {
            return null;
        }

        //x数不为null
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            return get(x.right, key);
        } else if (cmp < 0) {
            return get(x.left, key);
        } else {
            return x.value;
        }
    }

    /**
     * 删除对应树中的key的值
     *
     * @param key
     */
    public void delete(Key key) {
        delete(root, key);
    }

    /**
     * 删除指定x树中的key对应的值
     *
     * @param x
     * @param key
     */
    public Node delete(Node x, Key key) {
        //x树为null
        if (x == null) {
            return null;
        }

        //x数不为null
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            x.right = delete(x.right, key);
        } else if (cmp < 0) {
            x.left = delete(x.left, key);
        } else {
            N--;
            if (x.right == null) {
                return x.left;
            }

            if (x.left == null) {
                return x.right;
            }
            Node minNode = x.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }

            Node n = x.right;
            while (n.left != null) {
                if (n.left.left == null) {
                    n.left = null;
                } else {
                    n = n.left;
                }
            }

            minNode.left = x.left;
            minNode.right = x.right;
            x = minNode;


        }
        return x;
    }

    /**
     * 找出树中最小的键
     *
     * @return
     */
    public Key min() {
        return min(root).key;
    }

    /**
     * 找出指定树X中,最小键所在的节点
     *
     * @param x
     * @return
     */
    public Node min(Node x) {
        if (x.left != null) {
            return min(x.left);
        } else {
            return x;
        }
    }

    /**
     * 找出树中最大的键
     *
     * @return
     */
    public Key max() {
        return max(root).key;
    }

    /**
     * 找出指定树X中,最大键所在的节点
     *
     * @param x
     * @return
     */
    public Node max(Node x) {
        if (x.right != null) {
            return max(x.right);
        } else {
            return x;
        }
    }
}
