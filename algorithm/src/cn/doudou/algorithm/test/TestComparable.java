package cn.doudou.algorithm.test;

import cn.doudou.algorithm.sort.Student;

/**
 * Create By 王嘉浩
 * Time 2022-09-03 15:54
 */
public class TestComparable {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setAge(12);
        s1.setUserName("zhangsan");
        Student s2 = new Student();
        s1.setAge(18);
        s1.setUserName("lisi");

        Comparable max = getMax(s1, s2);
        System.out.println(max);
    }

    public static Comparable getMax(Comparable c1, Comparable c2) {
        int result = c1.compareTo(c2);
        if (result >= 0) {
            return c1;
        } else {
            return c2;
        }
    }
}
