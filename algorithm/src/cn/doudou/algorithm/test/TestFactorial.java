package cn.doudou.algorithm.test;

/**
 * Create By 王嘉浩
 * Time 2022-09-05 22:12
 * 递归测试
 */
public class TestFactorial {
    public static void main(String[] args) {
        long res = factorial(10);
        System.out.println(res);
    }

    public static long factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
