package cn.doudou.algorithm.linear;

import java.util.Iterator;

/**
 * Create By 王嘉浩
 * Time 2022-09-08 23:21
 * <p>
 * 线性表
 */
public class SequenceList<T> implements Iterable<T> {
    //存储元素的数组
    private T[] eles;
    //记录当前顺序表中的元素个数
    private int N;

    //错误返回code
    private static final int ERR_RESULT_CODE = -1;

    //构造方法
    public SequenceList(int capacity) {
        //初始化数组
        this.eles = (T[]) new Object[capacity];
        //初始化长度
        this.N = 0;
    }

    //将一个线性表置为空表
    public void clear() {
        this.N = 0;
    }

    //判断当前线性表是否为空表
    public boolean isEmpty() {
        return N == 0;
    }

    //获取线性表的长度
    public int length() {
        return N;
    }

    //获取指定位置的元素
    public T get(int i) {
        return eles[i];
    }

    //向线型表中添加元素t
    public void insert(T t) {
        if (N == eles.length) {
            resize(2 * eles.length);
        }
        eles[N++] = t;
    }

    /**
     * 在i元素处插入元素t
     *
     * @param index 索引
     * @param t     元素
     */
    public void insert(int index, T t) {
        if (N == eles.length) {
            resize(2 * eles.length);
        }
        //最后一个元素到index位置的元素进行向后面移动一位
        for (int i = N; i > index; i--) {
            eles[i] = eles[i - 1];
        }
        //插入index位置的元素
        eles[index] = t;

        N++;
    }

    //删除指定位置i处的元素，并返回该元素
    public T remove(int i) {
        //记录原来的元素
        T ele = eles[i];
        //元素向前移动一位
        for (int index = i; i < N - 1; i++) {
            eles[index] = eles[index + 1];
        }
        //修改长度
        N--;

        if (N < eles.length / 4) {
            resize(eles.length / 2);
        }

        //返回原来的元素
        return ele;
    }


    //查找t元素第一次出现的位置
    public int indexOf(T t) {
        for (int i = 0; i < N; i++) {
            if (t.equals(eles[i])) {
                return i;
            }
        }
        return ERR_RESULT_CODE;
    }

    //根据参数newSize，重置eles的大小
    public void resize(int newSize) {
        T[] temp = eles;
        eles = (T[]) new Object[newSize];
        for (int i = 0; i < N; i++) {
            eles[i] = temp[i];
        }
    }


    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator {
        private int cusor;

        public SIterator() {
            this.cusor = 0;
        }

        @Override
        public boolean hasNext() {
            return cusor < N;
        }

        @Override
        public Object next() {
            return eles[cusor++];
        }
    }
}