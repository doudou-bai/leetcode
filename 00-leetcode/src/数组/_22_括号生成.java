package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Create By 王嘉浩
 * Time 2022-11-09 16:41
 */
public class _22_括号生成 {
    public static void main(String[] args) {
        List<String> strings = generateParenthesis(10);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static List<String> generateParenthesis(int n) {
        //结果数据
        ArrayList<String> result = new ArrayList<>();
        backtracking(n, result, 0, 0, new StringBuilder());
        return result;
    }

    public static void backtracking(int n, List<String> result, int left, int right, StringBuilder cur) {
        //字符串的长度刚浩等于输入进来的数的2倍就把字符串的添加到list集合中
        if (cur.length() == n * 2) {
            result.add(cur.toString());
            return;
        }

        //判断左边的数如果比输入进来的数小 那么就生成一个左括号
        if (left < n) {
            cur.append('(');
            backtracking(n, result, left + 1, right, cur);
            cur.deleteCharAt(cur.length() - 1);
        }

        //如果右边的数大于左边的数 生成右括号添加到list中
        if (right < left) {
            cur.append(')');
            backtracking(n, result, left, right + 1, cur);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
