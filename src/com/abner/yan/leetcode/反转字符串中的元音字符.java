package com.abner.yan.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther: yanguoqing
 * @Date: 2020/5/11 22:09
 * @Description: Given s = "leetcode", return "leotcede".
 * 使用双指针，一个指针从头向尾遍历，一个指针从尾到头遍历，当两个指针都遍历到元音字符时，交换这两个元音字符。
 * <p>
 * 为了快速判断一个字符是不是元音字符，我们将全部元音字符添加到集合 HashSet 中，从而以 O(1) 的时间复杂度进行该操作。
 */
public class 反转字符串中的元音字符 {

    public static void main(String[] args) {
        reverseVowels("hello");
    }

    public static String reverseVowels(String str) {
        List<Character> list = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        if (str == null) {
            return null;
        }
        char[] chars = new char[str.length()];
        int i = 0;
        int j = str.length() - 1;
        while (i <= j) {
            char ci = str.charAt(i);
            char cj = str.charAt(j);
            if (!list.contains(ci)) {
                chars[i++] = ci;// // chars i 的位置赋值为ci，然后i的值+1
            } else if (!list.contains(cj)) {
                chars[j--] = cj;
            } else {
                chars[j--] = ci;
                chars[i++] = cj;
            }
        }
        return new String(chars);
    }

}
