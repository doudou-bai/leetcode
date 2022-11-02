package cn.doudou;

import cn.doudou.list.ArrayList;
import cn.doudou.list.List;


/**
 * Create By 王嘉浩
 * Time 2022-11-01 21:37
 */
public class Stack<E> {

    private List<E> list = new ArrayList<>();

    /**
     * 获得栈中的元素个数
     *
     * @return int
     */
    public int size() {
        return list.size();
    }

    /**
     * 判断栈中是否为空
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }


    /**
     * 向栈中添加一个元素E
     *
     * @param element
     */
    public void push(E element) {
        list.add(element);
    }

    /**
     * 弹出一个元素
     *
     * @return E
     */
    public E pop() {
        return list.remove(list.size() - 1);
    }

    /**
     * 获得顶部元素
     *
     * @return E
     */
    public E top() {
        return list.get(list.size() - 1);
    }

    /**
     * 清空栈里面的元素
     */
    public void clear() {
        list.clear();
    }
}
