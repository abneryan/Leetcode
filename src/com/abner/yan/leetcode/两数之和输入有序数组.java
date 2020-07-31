package com.abner.yan.leetcode;

import java.util.Arrays;

/**
 * @Auther: yanguoqing
 * @Date: 2020/5/11 21:31
 * @Description:
 */
public class 两数之和输入有序数组 {
    public static void main(String[] args) {
        int[] result = towSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(result));
    }

    public static int[] towSum(int[] numbers, int target) {
        if (numbers == null) {
            return null;
        }
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (target == numbers[left] + numbers[right]) {
                return new int[]{left + 1, right + 1};
            } else if (target < numbers[left] + numbers[right]) {
                right--;
            } else {
                left++;
            }
        }

        return null;
    }
}
