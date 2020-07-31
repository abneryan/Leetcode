package com.abner.yan.leetcode;

/**
 * @Auther: yanguoqing
 * @Date: 2020/5/11 22:39
 * @Description: Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * 题目描述：可以删除一个字符，判断是否能构成回文字符串
 */
public class 回文字符串 {
    public static void main(String[] args) {
        System.out.println(validPalindrome("abca"));
    }

    public static boolean validPalindrome(String str) {
        if (str == null) {
            return false;
        }
        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return isPalindrome(str, i, j--) || isPalindrome(str, i++, j);
            }
        }
        return true;
    }

    public static boolean isPalindrome(String str, int i, int j) {
        if(str == null){
            return false;
        }
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
