package com.abner.yan.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: yanguoqing
 * @Date: 2020/5/11 21:03
 * @Description:
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class 两数之和 {
    public static void main(String[] args) {
        int[] result = towSum(new int[]{2,7,11,15},9);
    }

    public static int[] towSum(int[] numbers, int target) {
        if (numbers == null) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int temp = numbers[i];
            int result = target - temp;
            if (map.containsKey(result) && i != map.get(result)) {
                return new int[]{i, map.get(result)};
            }
            map.put(temp, i);
        }

        return null;
    }
}
