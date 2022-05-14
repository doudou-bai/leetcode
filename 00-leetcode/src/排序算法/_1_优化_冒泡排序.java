package 排序算法;

import java.util.Arrays;

public class _1_优化_冒泡排序 {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,3,4,5,6,7,8,10,9};

        Integer[] sort = sort(arr);
        System.out.println(Arrays.toString(sort));
    }

    public static Integer[] sort(Integer[] arr) {
        int flag = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = 1;
                }
            }
        }
        if (flag == 0) {
            return arr;
        }
        return arr;
    }
}
