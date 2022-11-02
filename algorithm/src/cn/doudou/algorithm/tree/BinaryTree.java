package cn.doudou.algorithm.tree;

import cn.doudou.algorithm.linear.Queue;

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

    /**
     * 使用前序遍历，获取整个树中的所有键
     *
     * @return
     */
    public Queue preErgodic() {
        Queue<Key> keys = new Queue<>();
        preErgodic(root, keys);
        return keys;
    }

    /**
     * 使用前序遍历，把指定树x中的所有键放入到keys队列中
     *
     * @param x
     * @param keys
     */
    private void preErgodic(Node x, Queue keys) {
        //判断x是否为空
        if (x == null) {
            return;
        }

        keys.enqueue(x.key);

        //递归遍历左节点
        if (x.left != null) {
            preErgodic(x.left, keys);
        }
        if (x.right != null) {
            preErgodic(x.right, keys);
        }
    }

    /**
     * 使用中序遍历，获取整个树中的所有键
     *
     * @return
     */
    public Queue midErgodic() {
        Queue<Key> keys = new Queue<>();
        midErgodic(root, keys);
        return keys;
    }

    /**
     * 使用中序遍历，把指定树x中的所有键放入到keys队列中
     *
     * @param x
     * @param keys
     */
    public void midErgodic(Node x, Queue keys) {
        //判断x是否为空
        if (x == null) {
            return;
        }

        //递归遍历左节点
        if (x.left != null) {
            midErgodic(x.left, keys);
        }

        keys.enqueue(x.key);

        if (x.right != null) {
            midErgodic(x.right, keys);
        }
    }

    /**
     * 使用后序遍历，获取整个树中的所有键
     *
     * @return
     */
    public Queue afterErgodic() {
        Queue<Key> keys = new Queue<>();
        afterErgodic(root, keys);
        return keys;
    }

    /**
     * 使用后序遍历，把指定树x中的所有键放入到keys队列中
     *
     * @param x
     * @param keys
     */
    public void afterErgodic(Node x, Queue keys) {
        //判断x是否为空
        if (x == null) {
            return;
        }

        //递归遍历左节点
        if (x.left != null) {
            afterErgodic(x.left, keys);
        }

        //递归遍历右节点
        if (x.right != null) {
            afterErgodic(x.right, keys);
        }

        //递归遍历首节点
        keys.enqueue(x.key);
    }

    /**
     * 使用层序遍历获得树中所有的键
     *
     * @return Queue
     */
    public Queue layerErgodic() {
        //创建2个队列分别存储节点和键的值
        Queue<Key> keys = new Queue<>();
        Queue<Node> nodes = new Queue<>();

        //向队列中放入根节点
        nodes.enqueue(root);

        //判断队列是否还有元素
        while (!nodes.isEmpty()) {
            //弹出一个元素
            Node node = nodes.dequeue();
            //把元素的key放入keys队列中
            keys.enqueue(node.key);
            //判断节点的左子节点不为空就把左子节点放入到队列
            if (node.left != null) {
                nodes.enqueue(node.left);
            }

            //判断节点的右子节点不为空就把右子节点放入到队列
            if (node.right != null) {
                nodes.enqueue(node.right);
            }
        }
        return keys;
    }

    /**
     * 计算整个树的最大深度
     *
     * @return
     */
    public int maxDepth() {
        return maxDepth(root);
    }

    /**
     * 计算x树的最大深度
     *
     * @param x
     * @return
     */
    private int maxDepth(Node x) {
        //判断x是否为空
        if (x == null) {
            return 0;
        }

        //定义x树的最大深度
        int max = 0;
        //定义left的最大深度
        int maxL = 0;
        //定义right的最大深度
        int maxR = 0;

        if (x.left != null) {
            maxL = maxDepth(x.left);
        }

        if (x.right != null) {
            maxR = maxDepth(x.right);
        }
        //找出最大值然后赋值给max
        max = maxL > maxR ? maxL + 1 : maxR + 1;
        //返回max值
        return max;
    }

}
