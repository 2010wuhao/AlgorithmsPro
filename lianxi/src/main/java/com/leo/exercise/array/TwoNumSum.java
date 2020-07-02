package com.leo.exercise.array;

import java.util.HashMap;
import java.util.Map;

public class TwoNumSum {

    public int[] twoSum(int[] nums, int target) {
        int[] indexs = new int[2];
        for (int i = 0; i < nums.length; i++) {
            indexs[0] = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    indexs[1] = j;
                    return indexs;
                }
            }
        }
        return indexs;
    }

    public int[] twoSumUseMap(int[] nums, int target) {
        Map<Integer, Integer> hashmap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            //每次计算需要的target值，如果存在map中则返回map的值
            if (hashmap.containsKey(x)) {
                return new int[]{hashmap.get(x), i};
            }
            //不存在则把当前的值和下标存入map
            hashmap.put(nums[i], i);
        }
        return null;
    }

    /**
     * 获取数组的一个分界点，使得左右两边和相等
     * 先逐个加一遍，然后再次遍历，每次遍历的时候减去当前元素，
     * 判断是否为原来的一半
     *
     * @return
     */
    public int longestMidIndex(int[] nums) {
        int mid = 0;
        int leftSum = 0;
        int rightSum = 0;

        return mid;
    }
}
