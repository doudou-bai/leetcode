package cn.doudou.circle;

/**
 * 循环双端队列
 * <p>
 * Create By 王嘉浩
 * Time 2022-11-09 11:12
 */
public class CircleDeque<E> {
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

    public CircleDeque() {
        elements = (E[]) new Object[DEFAULT_CAPACIIY];
    }

    /**
     * 清空队列
     */
    public void clear() {
        for (int i = 0; i < i; i++) {
            elements[index(i)] = null;
        }
        front = 0;
        size = 0;
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
     * 从尾部入队
     *
     * @param element
     */
    public void enQueueRear(E element) {
        ensureCapacity(size + 1);
        //计算下要入队的元素的索引值在哪里
        elements[index(size)] = element;
        size++;
    }

    /**
     * 从头部入队
     *
     * @param element
     */
    public void enQueueFront(E element) {
        ensureCapacity(size + 1);
        front = index(-1);
        elements[front] = element;
        size++;
    }

    /**
     * 从尾部出队
     */
    public E deQueueFrRear() {
        int rearIndex = index(size - 1);
        E element = elements[rearIndex];
        elements[rearIndex] = null;
        size--;
        return element;
    }

    /**
     * 从头部出队
     */
    public E deQueueFront() {
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
     * 获取头部的元素
     *
     * @return
     */
    public E front() {
        return elements[front];
    }

    /**
     * 获取尾部的元素
     *
     * @return
     */
    public E Rear() {
        return elements[index(size - 1)];
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("CircleQueue{ size = ").append(size)
                .append(" length = ").append(elements.length)
                .append(", elements = [");
        for (int i = 0; i < elements.length; i++) {
            string.append(elements[i]);
            if (i != elements.length - 1) {
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
        i += front;
        //需要判断下如果是负数的情况下就加上elements.length
        if (i < 0) {
            return i + elements.length;
        }
        return i - (i >= elements.length ? elements.length : 0);

    }
}
