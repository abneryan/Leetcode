package com.abner.yan.leetcode;

/**
 * @Auther: yanguoqing
 * @Date: 2020/5/11 23:23
 * @Description:
 */
public class 归并两个有序数组 {
    public static void main(String[] args) {

    }

    public static void merge(int[] num1, int m, int[] num2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int mergeIndex = m + n - 1;
        while (index1 >= 0 || index2 >= 0) {
            if (index1 < 0) {
                num1[mergeIndex--] = num2[index2--];
            } else if (index2 < 0) {
                num1[mergeIndex--] = num1[index1--];
            } else if (num1[index1] > num2[index2]) {
                num1[mergeIndex--] = num1[index1--];
            } else {
                num1[mergeIndex--] = num2[index2--];
            }
        }
    }

    public static void merge1(int[] num1, int m, int[] num2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int mergeIndex = m + n - 1;
        while (index1 >= 0 && index2 >= 0) {
            num1[mergeIndex--] = num1[index1] > num2[index2] ? num1[index1--] : num2[index2--];
        }
        System.arraycopy(num2, 0, num1, 0, index2+1);
    }
}
