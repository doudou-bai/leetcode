package cn.doudou;

/**
 * 双向链表的实现
 */
public class LinkedList<E> extends AbstractList<E> {

    /**
     * 指向链表的头结点
     */
    private Node<E> first;
    /**
     * 指向链表的尾节点
     */
    private Node<E> last;

    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E old = node.element;
        node.element = element;
        return old;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        if (index == size) {
            Node<E> oldLast = last;
            last = new Node<>(oldLast, element, null);
            //即使第一个元素也是最后一个元素
            if (oldLast == null) {
                first = last;
            } else {
                oldLast.next = last;
            }
        } else {
            //找到需要进行插入的链表
            Node<E> next = node(index);
            //找到上一个链表
            Node<E> prev = next.prev;
            //构建一个Node节点进行插入
            Node node = new Node(prev, element, next);
            /**
             * 我们首先对插入的元素的prev的上一个元素进行相连接的操作
             */
            next.prev = node;
            if (prev == null) {
                first = node;
            } else {
                /**
                 * 我们对元素的下一个元素的上一个指针进行连接的操作
                 */
                prev.next = node;
            }
        }
        /**
         * 最后我们对链表的数量进行加++的操作
         */
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);

        Node<E> node = node(index);
        Node<E> next = node.next;
        Node<E> prev = node.prev;

        if (prev == null) { //index == 0
            first = next;
        } else {
            prev.next = next;
        }

        if (next == null) {//index == size-1
            last = prev;
        } else {
            next.prev = prev;
        }
        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = this.first;
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (node.element == null) return i;
                node = node.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) return i;
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * 内部类
     *
     * @param <E>
     */
    private static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;

        public Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            if (prev != null) {
                sb.append(prev.element);
            }
            sb.append("_").append(element).append("_");

            if (next != null) {
                sb.append(next.element);
            }
            return sb.toString();
        }
    }

    private Node<E> node(int index) {
        rangeCheck(index);

        /**
         * 我们这里进行判断
         * 主要实现的思路为
         * 判断index的是否小于size/2的数值 如果是就从左边开始查找,不是的话就从右边开始查找,等于的情况随便都可以
         */
        if (index < (size >> 1)) {
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            Node<E> node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            return node;
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("LinkedList{ size = ").append(size).append(", elements = [");
        Node<E> node = this.first;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(",");
            }
            string.append(node);
            node = node.next;
        }
        string.append("]");
        return string.toString();
    }
}
