package 剑指Offer;

public class _53_I_在排序数组中查找数字I {
    public int search(int[] nums, int target) {
        //定义一个数量
        int count = 0;
        for (int num : nums) {
            if (target == num) {
                count++;
            }
        }
        return count;
    }

}
