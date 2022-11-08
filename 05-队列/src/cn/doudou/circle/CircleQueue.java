package cn.doudou.circle;

/**
 * 循环队列的实现
 * <p>
 * Create By 王嘉浩
 * Time 2022-11-08 20:14
 */
public class CircleQueue<E> {
    /**
     * 头部索引
     */
    private int front;
    /**
     * 数量
     */
    private int size;
    /**
     * 使用动态数组进行实现 默认为10
     */
    private E[] elements;

    /**
     * 默认的容量
     */
    private static final int DEFAULT_CAPACIIY = 10;

    public CircleQueue() {
        elements = (E[]) new Object[DEFAULT_CAPACIIY];
    }

    /**
     * 返回双向队列的个数
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 判断是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 入队
     *
     * @param element
     */
    public void enQueue(E element) {
        ensureCapacity(size + 1);
        //计算下要入队的元素的索引值在哪里
        int i = index(size);
        elements[i] = element;
        size++;
    }

    /**
     * 出队
     *
     * @return
     */
    public E deQueue() {
        //取出元素
        E frontElement = elements[front];
        //原来位置的元素设置为空
        elements[front] = null;
        //调整front的指向
        front = index(1);
        //数组个数--
        size--;
        return frontElement;
    }

    /**
     * 返回第一个头部元素
     *
     * @return
     */
    public E front() {
        return elements[front];
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("CircleQueue{ size = ").append(size)
                .append(" length = ").append(elements.length)
                .append(", elements = [");
        for (int i = 0; i < size; i++) {
            string.append(elements[i]);
            if (i != size - 1) {
                string.append(",");
            }
        }
        string.append("] }");
        return string.toString();
    }

    /**
     * 动态扩容
     *
     * @param capacity
     */
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;

        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newElements[i] = elements[index(i)];
        }
        elements = newElements;
        //重置front指向为0
        front = 0;
    }

    /**
     * 封装索引
     *
     * @param i
     * @return
     */
    private int index(int i) {
        return (front + i) % elements.length;
    }
}
