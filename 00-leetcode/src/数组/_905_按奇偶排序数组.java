package 数组;

public class _905_按奇偶排序数组 {
    public int[] sortArrayByParity(int[] nums) {
        int index = 0;
        int[] resArr = new int[nums.length];
        for (int num : nums) {
            if (num % 2 == 0) {
                resArr[index++] = num;
            }
        }
        for (int num : nums) {
            if (num % 2 == 1) {
                resArr[index++] = num;
            }
        }
        return resArr;
    }

    public int[] sortArrayByParity2(int[] nums) {
        int index = nums.length;
        int[] res = new int[index];
        //定义一个左
        //定义一个右
        int left = 0, right = index - 1;
        for (int num : nums) {
            if (num % 2 == 0) {
                res[left++] = num;
            } else {
                res[right--] = num;
            }
        }
        return res;
    }
}
