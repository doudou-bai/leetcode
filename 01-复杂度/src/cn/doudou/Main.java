package cn.doudou;

/*
 * 求斐波那契
 * */
public class Main {
    public static void main(String[] args) {
       TimeTool.check("fib1", new TimeTool.Task() {
           @Override
           public void execute() {
               fib(40);
           }
       });
       TimeTool.check("fib2", new TimeTool.Task() {
           @Override
           public void execute() {
               fib1(40);
           }
       });
    }

    public static long fib(long a) {
        if (a <= 1) return a;
        return fib(a - 1) + fib(a - 2);
    }

    public static long fib1(long a) {
        if (a <= 1) return a;
        long first = 0;
        long second = 1;
        for (int i = 0; i < a - 1; i++) {
            long sum = first + second;
            second = sum;
            first = second;
        }
        return second;
    }

}
