package com.abner.yan.leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public final class Solution {


	//数字翻转：1234   转换为：4321
	public static int reverseNum(int num){
		int result = 0;
		while (num != 0){
			result = result *10 + num%10;
			num = num/10;
		}
		return result;
	}
	
	// -----------NO.8----START----
	/**
	 * Input:"tree"
	 * Output:eert
	 * 问题描述：给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
	 * 解释:
	 * 'e'出现两次，'r'和't'都只出现一次。
	 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
	 * 
	 * 解题思路：
	 * 1，遍历字符串，将字符存储到map中，key 为字符，value为该字符在字符串中出现的次数
	 * 2，初始化一个水桶数组，数组的角标代表字符出现的次数，将字符串中出现次数等于该数的字符
	 *		存储黛该数组位置的集合中
	 * 3，从高位向低位遍历水桶数组，将字符添加到StringBuilder 中
	 * 
	 * 力扣：https://leetcode-cn.com/problems/sort-characters-by-frequency/description/
	 * @param str
	 * @return
	 */
	public static String frequencySort(String str) {
		if (str == null) {
			return null;
		}
		HashMap<Character, Integer> frequencyChars = new HashMap<Character, Integer>();
		for (char c : str.toCharArray()) {
			frequencyChars.put(c, frequencyChars.getOrDefault(c, 0) + 1);
		}

		ArrayList<Character>[] buckets = new ArrayList[str.length() + 1];

		for (char key : frequencyChars.keySet()) {
			int frequency = frequencyChars.get(key);
			if (buckets[frequency] == null) {
				buckets[frequency] = new ArrayList();
			}
			buckets[frequency].add(key);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = buckets.length - 1; i >= 0; i--) {
			if (buckets[i] == null) {
				continue;
			}
			for (char c : buckets[i]) {
				for (int j = 0; j < i; j++) {//数组角标索引代表该数组位置存储的字符有多少个
					sb.append(c);
				}
			}
		}

		return sb.toString();
	}
	// -----------NO.8----END----
	
	
	// -----------NO.7----START----
	/**
	 * Input:nums = [1,1,1,2,2,3], k = 2
	 * Output:nums = [1,2]
	 * 问题描述：给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
	 * 
	 * 解题思路：
	 * 设置若干个桶，每个桶存储出现频率相同的数。桶的下标表示数出现的频率，即第 i 个桶中存储的数出现的频率为 i。
	 * 把数都放到桶之后，从后向前遍历桶，最先得到的 k 个数就是出现频率最多的的 k 个数。
	 * 
	 * 力扣：https://leetcode-cn.com/problems/top-k-frequent-elements/description/
	 * @param nums
	 * @param k
	 * @return
	 */
	public static List<Integer> topKFrequent(int nums[], int k) {
		if (nums == null) {
			return null;
		}
		HashMap<Integer, Integer> frequencyNum = new HashMap<>();
		for (int num : nums) {
			frequencyNum.put(num, frequencyNum.getOrDefault(num, 0) + 1);
		}

		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] buckets = new ArrayList[nums.length + 1];
		for (int num : frequencyNum.keySet()) {
			int frequency = frequencyNum.get(num);
			if (buckets[frequency] == null) {
				buckets[frequency] = new ArrayList<>();
			}
			buckets[frequency].add(num);
		}
		ArrayList<Integer> topKlist = new ArrayList<>();
		for (int i = buckets.length - 1; i >= 0 && topKlist.size() < k; i--) {
			if (buckets[i] == null) {
				continue;
			}
			if (buckets[i].size() <= (k - topKlist.size())) {
				topKlist.addAll(buckets[i]);
			} else {
				topKlist.addAll(buckets[i].subList(0, k - topKlist.size()));
			}
		}

		return topKlist;
	}
	// -----------NO.7----END----
	
	
	// -----------NO.6----START----
	/**
	 * Input:[3,2,1,5,6,4] 和 k = 2
	 * Output: 5
	 * 问题描述：在未排序的数组中找到第 k 个最大的元素。
	 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int findKthLargest(int[] nums, int k) {
		if (nums == null || nums.length == 0) {

		}
		Arrays.sort(nums);
		return nums[nums.length - k];
	}
	
	/**
	 * 利用小顶堆特性
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int findKthLargest1(int nums[], int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(); // 小顶堆
		for (int num : nums) {
			queue.add(num);
			if (queue.size() > k) {// 维护堆的大小为 K
				queue.poll();
			}
		}
		return queue.peek();
	}
	// -----------NO.6----END-----
	
	public static int findThrid(int[] nums, int k) {
		return 0;
	}

	// -----------NO.5----START----
	/**
	 * Input:
	 * nums1 = [1,2,3,0,0,0], m = 3
	 * nums2 = [2,5,6],       n = 3
	 * 
	 * Output: [1,2,2,3,5,6]
	 * 问题描述：
	 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组
	 * 
	 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
	 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
	 * 
	 * 解题思路：
	 * 需要从尾开始遍历，否则在 nums1 上归并得到的值会覆盖还未进行归并比较的值。
	 * 
	 * 力扣：https://leetcode-cn.com/problems/merge-sorted-array/description/
	 * 
	 * 需要从尾开始遍历，否则在 nums1 上归并得到的值会覆盖还未进行归并比较的值。
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 * @return
	 */
	public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
		int index1 = m - 1, index2 = n - 1, mergeIndex = m + n - 1;

		while (index1 >= 0 || index2 >= 0) { // 只要两个数组中有任意一个非空就需要继续取未完成的数组中元素
			if (index1 < 0) { // num1 遍历完成
				nums1[mergeIndex--] = nums2[index2--];
			} else if (index2 < 0) {
				nums1[mergeIndex--] = nums1[index1--];
			} else if (nums1[index1] > nums2[index2]) {
				nums1[mergeIndex--] = nums1[index1--];
			} else {
				nums1[mergeIndex--] = nums2[index2--];
			}
		}
		return nums1;
	}
	
	/**
	 * 
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 * @return
	 */
	public static int[] merge1(int[] nums1, int m, int[] nums2, int n) {
		// two get pointers for nums1 and nums2
		int p1 = m - 1;
		int p2 = n - 1;
		// set pointer for nums1
		int p = m + n - 1;

		// while there are still elements to compare
		while ((p1 >= 0) && (p2 >= 0)) //结束循环的条件：有一个数组已经遍历完成
			// compare two elements from nums1 and nums2
			// and add the largest one in nums1
			nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

		// add missing elements from nums2
		System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
		return nums1;
	}
	// -----------NO.5----END----
	
	// -----------NO.4----START----
	/**
	 * Input: abcdcwba
	 * Output:true
	 * 问题描述：给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
	 * 
	 * 解题思路：双指针
	 * 使用双指针可以很容易判断一个字符串是否是回文字符串：令一个指针从左到右遍历，
	 * 一个指针从右到左遍历，这两个指针同时移动一个位置，每次都判断两个指针指向的字符是否相同，
	 * 如果都相同，字符串才是具有左右对称性质的回文字符串。
	 * 
	 * 本题的关键是当遇到左右指针指向的元素不对称的时候可做一次删除，然后再做回文子判断，
	 * 我们此时可以删除左侧，或者右侧的一个元素，只要有一个方向的元素删除之后满足回文子的条件即可。
	 * 
	 * 删除之后我们直接判断子串是否是回文子串即可
	 * 
	 * 注：回文字符串：是指具有左右对称特点的字符串，例如 "abcba" 就是一个回文字符串
	 * 
	 * 力扣：https://leetcode-cn.com/problems/valid-palindrome-ii/description/
	 * @param target
	 * @return
	 */
	public static boolean validPalindrome(String target) {
		if (target == null) {
			return false;
		}
		int i = 0, j = target.length() - 1;
		while (i < j) {
			if (target.charAt(i) != target.charAt(j)) {
				return isPalindrome(target, i+1, j) || isPalindrome(target, i, j-1);
			} else {
				i++;
				j--;
			}
		}
		return true;
	}
	/**
	 * @param str
	 * @return
	 */
	public static boolean isPalindrome(String str, int i, int j) {
		if (str == null) {
			return false;
		}
		while (i < j) {
			if (str.charAt(i++) != str.charAt(j--)) {
				return false;
			}
		}
		return true;
	}
	// -----------NO.4----END----

	// -----------NO.3----START----
	/**
	 * InPut: hello world 
	 * OutPut: hollo werld 
	 * 问题描述：反转该字符串中的元音字母
	 * 
	 * 解题思路:双指针 
	 * 1，左侧指针指向字符串开始端字符，右侧指针指向末端字符 
	 * 2，当左侧指针指向的元素不是元音字符时，把当前字符保存到已知数组中，
	 *    位置与当前指针位置一致，此时左侧指针++，进行下一次循环 
	 * 3，当左侧指针指向的元素是元音字符时，查看右侧指针指向的元素，当右侧指向的元素不是元音字符时，
	 *    把当前字符保存到已知数组中，位置与当前指针位置一致，此时右侧指针--，进行下一次循环
	 * 4，当左右两侧指针指向的元素都为元音字符时交换位置，保存到一直数组中，指针分别向前，向后移动一位
	 * 
	 * 注：元音字符：'a','e','i','o','u' (以及对应的大写字符)
	 * 
	 * @param str
	 * @return
	 */
	public static String reverseVowels(String str) {
		if (str == null) {
			return null;
		}
		// 先把元音字符加入集合中，以便后面判断字符是否为元音字符
		final HashSet<Character> vowelsSet = new HashSet<Character>(
				Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
		int i = 0, j = str.length() - 1;
		char[] result = new char[str.length()];
		while (i <= j) {
			char ci = str.charAt(i);
			char cj = str.charAt(j);
			if (!vowelsSet.contains(ci)) {
				result[i++] = ci; // 先将result i 的位置赋值为ci，然后i的值+1
			} else if (!vowelsSet.contains(cj)) {
				result[j--] = cj;
			} else {
				result[i++] = cj;
				result[j--] = ci;
			}
		}
		return new String(result);
	}
	// -----------NO.3----END----

	// -----------NO.2----START----
	/**
	 * Input: target = 5 Output: i = 1, j= 2 true;
	 * 
	 * 问题描述，输入一个非负整数，查找是否存在两个整数 i，j 使 i*i+j*j = target
	 * 
	 * 解题思路：双指针 1，使用双指针，一个指向0，一个指向 target 的开方值取整 2，指向0的指针从左侧向右移动，指向较大元素的指针从右侧向左移动 -
	 * 如果两个指针指向元素的和sum = target,那么就得到想要的结果； -如果sum > target 移动指向较大元素的指针，使sum变小 -
	 * 如果sum < target 移动指向较小元素的指针，使sum变大
	 * 
	 * 力扣：https://leetcode-cn.com/problems/sum-of-square-numbers/description/
	 * 
	 * @param target
	 * @return
	 */
	public static boolean jugeSquareSum(int target) {
		if (target < 0) {
			return false;
		}
		int i = 0, j = (int) Math.sqrt(target);
		while (i <= j) {
			int sum = i * i + j * j;
			if (sum == target) {
				return true;
			} else if (sum > target) {
				j--;
			} else {
				i++;
			}
		}
		return false;
	}
	// -----------NO.2----END-------

	// ----------------NO.1--START---
	/**
	 * Input: numbers={2,7,11,15}, target = 9; Output: index1 = 1, index2 = 2
	 * 题目描述：在有序(升序)数组中找出两个数，使他们的和等于target 考察要点：双指针 解题思路： 1，使用双指针，一个指针指向较小元素，一个指向较大元素
	 * 2，指向较小元素的指针从前往后遍历，指向较大元素的指针从后往前遍历 - 如果两个指针指向元素的和sum = target,那么就得到想要的结果；
	 * -如果sum > target 移动指向较大元素的指针，使sum变小 - 如果sum < target 移动指向较小元素的指针，使sum变大
	 * 
	 * 力扣：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/description/
	 * 
	 * @param numbers
	 * @param target
	 * @return
	 */

	public static int[] towSum(int[] numbers, int target) {
		if (numbers == null) {
			return null;
		}

		int l = 0, r = numbers.length - 1;
		while (l < r) {
			int sum = numbers[l] + numbers[r];
			if (sum == target) {
				return new int[] { l + 1, r + 1 };
			} else if (sum > target) {
				r--;
			} else {
				l++;
			}
		}
		return null;
	}

	// -------------------------------以下是非有序数组----start----
	/**
	 * 暴力查找
	 * 
	 * @param numbers
	 * @param target
	 * @return
	 */
	public static int[] towSum1(int[] numbers, int target) {// [3,2,4] 6
		if (numbers == null) {
			return null;
		}
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] + numbers[j] == target) {
					return new int[] { i, j };
				}
			}
		}
		return null;
	}

	public static int[] twoSum2(int[] numbers, int target) {
		if (numbers == null) {
			return null;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			map.put(numbers[i], i);
		}
		for (int i = 0; i < numbers.length; i++) {
			int result = target - numbers[i];
			if (map.containsKey(result) && map.get(result) != i) {
				return new int[] { i, map.get(result) };
			}
		}
		return null;
	}

	public static int[] twoSum3(int[] numbers, int targer) {
		if (numbers == null) {
			return null;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			int result = targer - numbers[i];
			if (map.containsKey(result) && map.get(result) != i) {
				return new int[] { i, map.get(result) };
			}
			map.put(numbers[i], i);
		}
		return null;
	}

	// -------------------------------以下是非有序数组----end----

	// ----------------NO.1--END---

	/**
	 * 冒泡排序
	 * 
	 * @param numbers
	 * @return
	 */
	public static int[] bubbleSort(int[] numbers) {
		if (numbers == null) {
			return null;
		}
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = 0; j < numbers.length - i - 1; j++) {
				if (numbers[j] > numbers[j + 1]) { // 升序
					int temp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = temp;
				}
			}
		}

		System.out.println("result:" + Arrays.toString(numbers));
		return numbers;
	}

	/**
	 * 选择排序
	 * 
	 * @param numbers
	 * @return
	 */
	public static int[] selectSort(int[] numbers) {
		if (numbers == null) {
			return null;
		}
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i; j < numbers.length; j++) {
				if (numbers[i] > numbers[j]) {// 升序
					int temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}
		System.out.println("result:" + Arrays.toString(numbers));
		return numbers;
	}

}
