package 剑指Offer;

import java.util.HashSet;
import java.util.Set;

public class _03_数组中重复的数字 {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        //初始化一个返回结果
        int result = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                result = num;
                break;
            }
        }
        return result;
    }
}
