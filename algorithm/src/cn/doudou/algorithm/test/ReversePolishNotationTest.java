package cn.doudou.algorithm.test;

import cn.doudou.algorithm.linear.Stack;

/**
 * Create By 王嘉浩
 * Time 2022-10-18 11:15
 */
public class ReversePolishNotationTest {
    public static void main(String[] args) {
        //中缀表达式 3*（17-15）+18/6 的逆波兰表达式如下 6+3=9
        String[] notation = {"3", "17", "15", "-", "*", "18", "6", "/", "+"};
        int result = caculate(notation);
        System.out.println("逆波兰表达式的结果为：" + result);
    }

    /**
     * @param notaion 逆波兰表达式的数组表示方式
     * @return 逆波兰表达式的计算结果
     */
    public static int caculate(String[] notaion) {
        //1.创建栈对象
        Stack<Integer> oprands = new Stack<>();
        //2.遍历循环数组
        for (int i = 0; i < notaion.length; i++) {
            String curr = notaion[i];
            Integer o1;
            Integer o2;
            Integer result;
            switch (curr) {
                //3.判断是否是运算符号是的话运算后在压入栈中
                case "+":
                    o1 = oprands.pop();
                    o2 = oprands.pop();
                    result = o1 + o2;
                    oprands.push(result);
                    break;
                case "-":
                    o1 = oprands.pop();
                    o2 = oprands.pop();
                    result = o2 - o1;
                    oprands.push(result);
                    break;
                case "*":
                    o1 = oprands.pop();
                    o2 = oprands.pop();
                    result = o1 * o2;
                    oprands.push(result);
                    break;
                case "/":
                    o1 = oprands.pop();
                    o2 = oprands.pop();
                    result = o2 / o1;
                    oprands.push(result);
                    break;
                default:
                    //4.如果不是运算符号 ,就直接压入栈中
                    oprands.push(Integer.parseInt(curr));
                    break;
            }
        }
        //5.弹出最后一个元素就是结果值
        Integer result = oprands.pop();
        return result;
    }
}
