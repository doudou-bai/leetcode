package cn.doudou.secondaryImplementation;


import java.util.Arrays;

/**
 * 我们在对动态的数组进行设计的时候
 * 设计数组的数量和数组的元素等等
 */
public class ArrayList2 {
    /**
     * 数组的数量
     */
    private int size;

    /**
     * 数组的元素集合
     */
    private int[] elements;

    private static final int DEFAULT_CAPACITY = 10;

    private static final int ELEMENT_NOT_FOUND = -1;

    /**
     * 提供构造的方法可以让用户自定义的创建动态数组的容量
     * <p>
     * 用户传参数进来的容量
     *
     * @param capacity
     */
    public ArrayList2(int capacity) {
        capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
        elements = new int[capacity];
    }

    public ArrayList2() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 元素的数量
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 查看参数的元素是否存在
     *
     * @param element
     * @return
     */
    public boolean contains(int element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    /**
     * 添加元素到最后面
     *
     * @param element
     */
    public void add(int element) {
        elements[size++] = element;
    }

    /**
     * 获得指定位置的元素
     *
     * @param index
     * @return
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Array out of bounds exception!");
        }
        return elements[index];
    }

    /**
     * 设置指定位置的元素
     *
     * @param index
     * @param element
     * @return
     */
    public int set(int index, int element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Array out of bounds exception!");
        }
        int oldElement = elements[index];
        elements[index] = element;
        return oldElement;
    }

    /**
     * 在index位置上面进行插入数据
     *
     * @param index
     * @param element
     */
    public void add(int index, int element) {

    }

    /**
     * 删除指定位置的元素并返回
     *
     * @param index
     * @return
     */
    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Array out of bounds exception!");
        }
        int old = elements[index];
        for (int i = index + 1; i <= size - 1; i++) {
            elements[i - 1] = elements[i];
        }
        size--;
        return old;
    }

    /**
     * 查看元素第一次出现的位置并返回
     *
     * @param element
     * @return
     */
    public int indexOf(int element) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == element) {
                return i;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * 清楚数组的内容
     */
    public void clear() {
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("size = ").append(size).append(",[");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(elements[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}
