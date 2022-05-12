package cn.doudou;

/**
 * 动态数组的缩容问题
 *
 * @param <E>
 */
public class ArrayList2<E> {
    /*
     * 动态数组的数量
     */
    private int size;
    /*
     * 动态数组的所有元素
     */
    private E[] elements;

    /*
     * 初始化数组的容量
     */
    private static final int DEFAULT_CAPACIIY = 10;

    /*
     * 默认错误的返回值
     */
    private static final int ELEMENT_NOT_FOUND = -1;

    /*
     * 有参数的构造方法
     */
    public ArrayList2(int capaticy) {
        // 对数组的初始化的长度进行设置
        capaticy = (capaticy < DEFAULT_CAPACIIY) ? DEFAULT_CAPACIIY : capaticy;
        // 进行对数组的初始化设置
        elements = (E[]) new Object[capaticy];
    }

    /*
     * 无参数的构造发方法
     */
    public ArrayList2() {
        // 调用有参数的构造方法进行设置 直接传入默认值
        this(DEFAULT_CAPACIIY);
    }

    /*
     * 清楚所有的元素
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    /*
     * 元素的数量
     * @return
     */
    public int size() {
        return size;
    }

    /*
     * 是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /*
     * 是否包含某个元素
     * @param element
     * @return
     */
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    /*
     * 根据index进行获取对应位置的元素
     * @param index
     * @return
     */
    public E get(int index) {
        return elements[index];
    }

    /**
     * 设置index位置的元素
     *
     * @param index
     * @param element
     * @return
     */
    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("数组越界异常！");
        }
        //取出原来的元素进行赋值
        E old = elements[index];
        //对新的元素进行赋值
        elements[index] = element;
        //返回旧的数据
        return old;
    }

    /**
     * 添加到数组的尾部
     *
     * @param element
     */
    public void add(E element) {
        add(size, element);
    }

    /**
     * 在指定位置插入指定的数据
     *
     * @param index
     * @param element
     */
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("数组越界异常！");
        }
        ensureCapacity(size + 1);
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    /**
     * 查看元素第一次出现的索引
     *
     * @param element
     * @return
     */
    public int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) {
                    return i;
                }
            }
        }

        return ELEMENT_NOT_FOUND;
    }


    /**
     * 删除数组对应index里面的元素
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("数组越界异常！");
        }
        E old = elements[index];
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        size--;
        elements[size] = null;

        trim();

        return old;
    }

    /**
     * 规则的定义
     * <p>
     * 比如剩下的空间占总空间一般的时候,就进行缩容
     */
    private void trim() {
        int capacity = elements.length;
        //新的容量
        int newCapacity = capacity >> 1;
        if (size >= newCapacity || capacity <= DEFAULT_CAPACIIY) return;

        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
        System.out.println(capacity + "执行缩减的方法:===>" + newCapacity);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("ArrayList{ size = ").append(size).append(", elements = [");
        for (int i = 0; i < size; i++) {
            string.append(elements[i]);
            if (i != size - 1) {
                string.append(",");
            }
        }
        string.append("] }");
        return string.toString();
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;
        int newCapacity = oldCapacity + (oldCapacity << 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }
}