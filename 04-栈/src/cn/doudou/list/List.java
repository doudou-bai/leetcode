package cn.doudou.list;

public interface List<E>{
    /*
     * 默认错误的返回值
     */
    static final int ELEMENT_NOT_FOUND = -1;

    /**
     * 清楚所有的元素
     */
    void clear();

    /**
     * 元素的数量
     * @return
     */
    int size();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 是否包含某个元素
     * @return
     */
    boolean contains(E element);

    /**
     * 插入元素
     * @param element
     */
    void add(E element);

    /**
     * 获得index位置的元素
     * @param index
     * @return
     */
    E get(int index);

    /**
     * 设置某个位置的元素
     * @param index
     * @param element
     * @return
     */
    E set(int index,E element);

    /**
     * 插入指定位置的元素
     * @param index
     * @param element
     */
    void add(int index,E element);

    /**
     * 删除对应index位置的元素
     * @param index
     * @return
     */
    E remove(int index);

    /**
     * 查看元素第一次出现的位置
     * @param element
     * @return
     */
    int indexOf(E element);
}
