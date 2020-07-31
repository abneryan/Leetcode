package com.abner.yan.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Auther: yanguoqing
 * @Date: 2020/5/13 08:49
 * @Description: 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * <p>
 * 设置若干个桶，每个桶存储出现频率相同的数。桶的下标表示数出现的频率，即第 i 个桶中存储的数出现的频率为 i。
 * <p>
 * 把数都放到桶之后，从后向前遍历桶，最先得到的 k 个数就是出现频率最多的的 k 个数。
 */
public class 前K个高频元素 {
    public static void main(String[] args) {

    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequcecyFromNum = new HashMap<>();
        for (int num : nums) {
            frequcecyFromNum.put(num, frequcecyFromNum.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int key : frequcecyFromNum.keySet()) {
            int frequcecy = frequcecyFromNum.get(key);
            if (buckets[frequcecy] == null) {
                buckets[frequcecy] = new ArrayList<>();
            }
            buckets[frequcecy].add(key);
        }
        List<Integer> topK = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && topK.size() < k; i--) {
            if (buckets[i] == null) {
                continue;
            }
            if (buckets[i].size() <= (k - topK.size())) {
                topK.addAll(buckets[i]);
            } else {
                topK.addAll(buckets[i].subList(0, k - topK.size()));
            }
        }
        return topK;
    }
}
