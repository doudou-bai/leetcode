package cn.doudou.firstRealization;

public class Assert {
    public static void test(boolean b){
        if (!b){
            throw  new IndexOutOfBoundsException("测试未通过!");
        }
    }
}
