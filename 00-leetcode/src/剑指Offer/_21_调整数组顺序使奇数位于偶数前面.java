package 剑指Offer;

public class _21_调整数组顺序使奇数位于偶数前面 {
    public int[] exchange(int[] nums) {
        //双指针 定义左和右的变量
        int i = 0, j = nums.length - 1, tmp;
        while (i < j) {
            while (i < j && (nums[i] % 2) == 1) i++;
            while (i < j && (nums[j] % 2) == 0) j--;
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(5 % 2);
    }
}
