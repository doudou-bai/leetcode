package cn.doudou.firstRealization;

import java.util.Arrays;

/**
 * 动态数组的设计与实现过程,动态的数组主要有三个参数进行实现
 *  数组的数量 size
 *  一个可以容纳所有类的数组 E[] elements
 *  还有一个初始化的数组的容量 DEFAULT_CAPACIIY = 2
 *  默认的参数错误返回值 -1
 *
 * ==================================================
 *
 * 方法区:
 *
 * 构造方法:
 * 实现思路:首先要有2个构造方法的参数进行设计与实现主要的作用是构造新的数组进行使用
 *
 * clear() 清空动态数组里边的所有元素及长度归0
 * 实现思路:可以使用for进行循环一遍,全部设置为null后,在设置长度为0,就可以了
 *
 * size() 可以直接返回数组的size属性
 * 实现思路:我们已经在动态数组的里面设置size属性并且保持和动态数组的长度是一样的,所以我们直接返回size属性的值就可以
 *
 * isEmpty() 判断我们数组的元素是否为空
 * 实现思路:直接使用if判断下size是否等于0就可以返回结果
 *
 * get() 根据index参数返回动态数组下标为index位置的值
 * 实现思路:我们可以直接使用数组的下标就可以获得对应下标的值 如: E[2] = ???
 *
 * set() 根据传入的index下标修改数组index下标的数据并返回旧的数据
 * 实现思路:set()首先我们可以先进行判断下数组的下标是否有越界的异常,然后我们先取出对应index位置的旧元素进行赋值给一个临时变量,然后我们在对index位置上进行赋新的值,并且返回新的数据
 *
 * add() 在指定位置插入指定的数据
 * 实现思路:先去判断传入的index是否有越界的异常,然后会调用动态扩容的方法进行检测,循环让每个位置的元素进行向前移动一位 然后index位置的元素赋值就可以了最后在把size属性进行加一
 *
 * indexOf() 查看元素第一次出现的位置
 * 实现思路:
 *  思路一:元素为数值/其他类型 判断元素是不是等于null如果是的就进入判断字符串类型的里面 不是话就可以进行循环遍历数组进行判断元素是不是真实存在 找到元素返回i的值
 *  思路二:元素为字符串类型 以上同理
 *
 * remove() 删除指定位置的元素
 * 实现思路:判断是否越界异常 先新建临时的变量进行保存index位置的值 然后循环进行每个元素向前移动一位 size-- 最后把E[size]位置的数值赋值为空返回临时的变量
 *
 * ensureCapacity() 动态扩容的方法
 * 实现思路:会判断现在的数组长度和用户现在使用的数组长度进行比较 如果小于的话会新创建一个原来长度*1.5左右的一个数组进行循环赋值
 * @param <E>
 */
public class ArrayList<E> {
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
    private static final int DEFAULT_CAPACIIY = 2;

    /*
     * 默认错误的返回值
     */
    private static final int ELEMENT_NOT_FOUND = -1;

    /*
     * 有参数的构造方法
     */
    public ArrayList(int capaticy) {
        // 对数组的初始化的长度进行设置
        capaticy = (capaticy < DEFAULT_CAPACIIY) ? DEFAULT_CAPACIIY : capaticy;
        // 进行对数组的初始化设置
        elements = (E[]) new Object[capaticy];
    }

    /*
     * 无参数的构造发方法
     */
    public ArrayList() {
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
        return old;
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