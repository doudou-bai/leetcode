package cn.doudou.algorithm.test;

import cn.doudou.algorithm.linear.LinkList;

/**
 * Create By 王嘉浩
 * Time 2022-09-10 22:57
 */
public class TestLinkList {
    public static void main(String[] args) {
        LinkList<String> sl = new LinkList<>();
        sl.insert("姚明");
        sl.insert("科比");
        sl.insert("爱迪");
        sl.insert(1, "乔布斯");

        for (String s : sl) {
            System.out.println(s);
        }
        System.out.println("翻转后========================");
        sl.reverse();
        for (String s : sl) {
            System.out.println(s);
        }
    /*    System.out.println("======================");

        //测试获取
        String s = sl.get(1);
        System.out.println(s);
        //测试删除
        String remove = sl.remove(0);
        System.out.println(remove);
        //测试清空
        sl.clear();
        System.out.println(sl.length());*/
    }
}
