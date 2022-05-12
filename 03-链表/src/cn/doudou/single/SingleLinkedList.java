package cn.doudou.single;

import cn.doudou.AbstractList;

public class SingleLinkedList<E> extends AbstractList<E> {

    private Node<E> first;

    @Override
    public void clear() {
        size = 0;
        first = null;
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
        if (index == 0) {
            first = new Node<>(element, first);
        } else {
            Node<E> prev = node(index - 1);
            prev.next = new Node<>(element, prev.next);
        }
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> oldNode = first;
        if (index == 0) {
            this.first = this.first.next;
        } else {
            Node<E> node = node(index - 1);
            oldNode = node.next;
            node.next = node.next.next;
        }
        size--;
        return oldNode.element;
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
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    private Node<E> node(int index) {
        rangeCheck(index);
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("LinkedList{ size = ").append(size).append(", elements = [");
        Node<E> node = this.first;
        for (int i = 0; i < size; i++) {
            string.append(node.element);
            node = node.next;
            if (i != size - 1) {
                string.append(",");
            }
        }
        string.append("] }");
        return string.toString();
    }
}
