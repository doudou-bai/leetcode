package 剑指OfferII;

import java.util.Arrays;

public class _006_排序数组中两个数字之和 {
    public static int[] twoSum(int[] numbers, int target) {
        //定义一个快指针
        int high = numbers.length - 1;
        //定义一个满指针
        int low = 0;
        while (low < high) {
            //计算两数之和
            int sum = numbers[low] + numbers[high];
            //判断是否等于 等于直接返回
            if (sum == target) {
                return new int[]{low, high};
            } else if (sum < target) {//和是不是小于目标值 小于的话就让慢指针加1
                ++low;
            } else {//和如果大于就让 快指针进行－1
                --high;
            }
        }
        //没有找到返回-1的值表示没有找到
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 34, 4, 5, 6, 7, 8};
        System.out.println(Arrays.toString(twoSum(arr, 38)));
    }

}
