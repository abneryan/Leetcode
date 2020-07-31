package com.abner.yan.leetcode;

/**
 * @Auther: yanguoqing
 * @Date: 2020/5/11 21:53
 * @Description:
 * Input: 5
 * Output: True
 * Explanation: 1 * 1 + 2 * 2 = 5
 * 题目描述：判断一个非负整数是否为两个整数的平方和。
 */
public class 两数平方和 {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(5));

    }

    public static boolean judgeSquareSum(int target) {
        if (target < 0) {
            return false;
        }
        int i = 0;
        int j = (int) Math.sqrt(target);
        while (i < j) {
            int temp = i * i + j * j;
            if (temp > target) {
                j--;
            } else if (temp < target) {
                i++;
            } else if (target == temp) {
                return true;
            }
        }
        return false;
    }
}
