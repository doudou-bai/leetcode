package cn.doudou.algorithm.test;

import cn.doudou.algorithm.linear.Stack;

/**
 * Create By 王嘉浩
 * Time 2022-09-20 21:42
 */
public class TestStack {
    public static void main(String[] args) {
        //创建栈对象
        Stack<String> ss = new Stack<>();

        ss.push("a");
        ss.push("b");
        ss.push("c");
        ss.pop();
        ss.pop();
        ss.push("d");
        ss.pop();
        ss.pop();
        for (String s : ss) {
            System.out.println(s);
        }

        System.out.println("=========================");
        //测试弹栈
        String pop = ss.pop();
        System.out.println(pop);
        System.out.println("剩余元素的个数为:" + ss.size());
    }
}
