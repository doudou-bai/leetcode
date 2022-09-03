package 排序算法;

import java.util.Arrays;

public class _1_冒泡排序 {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{2, 3, 1, 5, 7, 6, 4};

        Integer[] sort = sort(arr);
        System.out.println(Arrays.toString(sort));
    }

    public static Integer[] sort(Integer[] arr) {
        //控制循环要多少次
        for (int i = 0; i < arr.length; i++) {
            //每次循环就减去-i-1的值就是我们要比较的那个数字
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //如果j+1小于j那么就交换位置
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        //返回数组
        return arr;
    }
}
