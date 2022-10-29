package 数组;

/**
 * Create By 王嘉浩
 * Time 2022-10-23 16:09
 */
public class _11_盛最多水的容器 {
    public static void main(String[] args) {
        int[] arr = {7, 8, 6, 2, 5, 4, 8, 3, 7};
        int res = maxArea(arr);
        System.out.println(res);
    }

    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        //返回结果
        int res = 0;
        while (left < right) {
            int cur_area = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(res, cur_area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
