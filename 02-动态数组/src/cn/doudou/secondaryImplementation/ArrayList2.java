package cn.doudou.secondaryImplementation;


import java.util.Arrays;

/**
 * 我们在对动态的数组进行设计的时候
 * 设计数组的数量和数组的元素等等
 */
public class ArrayList2<E> {
    /**
     * 数组的数量
     */
    private int size;

    /**
     * 数组的元素集合
     */
    private E[] elements;

    private static final int DEFAULT_CAPACITY = 3;

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
        elements = (E[]) new Object[capacity];
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
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    /**
     * 添加元素到最后面
     *
     * @param element
     */
    public void add(E element) {
        add(size, element);
    }

    /**
     * 获得指定位置的元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    /**
     * 设置指定位置的元素
     *
     * @param index
     * @param element
     * @return
     */
    public E set(int index, E element) {
        rangeCheck(index);
        E oldElement = elements[index];
        elements[index] = element;
        return oldElement;
    }

    /**
     * 在index位置上面进行插入数据
     *
     * @param index
     * @param element
     */
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        ensureCapacity(size + 1);
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = element;
        size++;
    }

    /**
     * 数组的动态扩容
     *
     * @param capacity
     */
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newEls = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newEls[i] = elements[i];
        }
        elements = newEls;
}

    /**
     * 删除指定位置的元素并返回
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        rangeCheck(index);
        E old = elements[index];
        for (int i = index + 1; i <= size - 1; i++) {
            System.out.println(elements[i]);
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
    public int indexOf(E element) {
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

    /**
     * 对动态数组的检查方法
     *
     * @param index
     */
    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            outOfBounds();
        }
    }

    /**
     * 对动态数组add方法的检查方法
     *
     * @param index
     */
    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            outOfBounds();
        }
    }

    /**
     * 抛出异常信息
     */
    private void outOfBounds() {
        throw new IndexOutOfBoundsException("Array out of bounds exception!");
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
