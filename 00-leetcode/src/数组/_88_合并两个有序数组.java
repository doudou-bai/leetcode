package 数组;

import java.util.Arrays;

/**
 * Create By 王嘉浩
 * Time 2022-10-21 17:13
 */
public class _88_合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i != n; ++i) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}
