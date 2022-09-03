package 数组;

public class _168_多数元素 {
    public static int majorityElement(int[] nums) {
        //假设第一个元素的票数
        int count = 1;
        //假设第一个元素为当选人
        int candidate = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candidate) {
                //如果数组遍历过程中，有元素和当选人元素一样，就加一
                count++;
            } else {
                //如果没有就减一
                count--;
            }
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
       int[] nums = new int[]{1,2,3,4,5,1,3,4,5,3,4,5,4,5};
        System.out.println(majorityElement(nums));
    }
}
