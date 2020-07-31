package com.abner.yan.leetcode;

/**
 * @Auther: yanguoqing
 * @Date: 2020/5/13 10:05
 * @Description:
 */
public class 二分查找 {
    public static void main(String[] args) {

    }

    public int binarySearch(int[] nums, int key) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == key) {
                return mid;
            } else if (nums[mid] > key) {
                r = mid - 1;
            } else if (nums[mid] < key) {
                l = mid + 1;
            }
        }
        return -1;
    }
}
