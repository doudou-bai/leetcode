package 初级算法;

public class _1_删除排序数组中的重复项 {
    public static int removeDuplicates(int[] nums) {
        //定义指针进行移动
        int j = 0;
        //循环数组
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j = j + 1;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 0,11,223,11};
        removeDuplicates(arr);
    }
}
