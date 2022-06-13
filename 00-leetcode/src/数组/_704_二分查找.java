package 数组;

public class _704_二分查找 {
    public static int search(int[] nums, int target) {
        //定义left right 变量
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            /**
             * 先使用右边的变量减去左边的变量 结果让向右边位移1位 然后在加上left的值
             */
            int mid = left+((right - left) >> 1);
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
        }
        return -1;
    }

}
