package cn.doudou.algorithm.test;

import cn.doudou.algorithm.linear.Stack;

/**
 * Create By 王嘉浩
 * Time 2022-10-18 10:38
 */
public class BracketsMatchTest {
    public static void main(String[] args) {
        String str = "(上海(长安))";
        boolean match = isMatch(str);
        System.out.println(match);
    }

    private static boolean isMatch(String str) {
        //1.创建栈对象
        Stack<String> chars = new Stack<>();
        //2.循环遍历字符串的每个字符
        for (int i = 0; i < str.length(); i++) {
            String currChar = str.charAt(i) + "";
            //3.判断字符是不是等于左侧括号是的话就向栈里面进行添加一个左括号
            if (currChar.equals("(")) {
                chars.push(currChar);
            }
            //4.判断是不是右括号是的话就弹出一个左括号
            if (currChar.equals(")")) {
                String pop = chars.pop();
                //5.判断弹出的元素是否成功
                if (pop == null) {
                    return false;
                }
            }
        }
        //6.判断栈中是否还有左括号,如果有,证明不匹配.没有则匹配
        if (chars.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
