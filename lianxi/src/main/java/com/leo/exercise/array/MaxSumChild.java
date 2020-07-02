package com.leo.exercise.array;

public class MaxSumChild {
    /**
     * 2.1 剑指 Offer 42. 连续子数组的最大和
     * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
     * 要求时间复杂度为O(n)。
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int sumA = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            nums[i] += Math.max(nums[i - 1], 0);
//            sumA = Math.max(nums[i], sumA);
//        }
//        return sumA;

        int maxSum = sumA;
        for (int i = 1; i < nums.length; i++) {
            sumA += nums[i];
            if (sumA < nums[i]) {
                sumA = nums[i];
            }
            maxSum = Math.max(maxSum, sumA);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] a = {1, -1, 3, -2, 5};
//        a = new int[]{1, -4, 9, -1, -2, 7};
        System.out.println(MaxSumChild.maxSubArray(a));
    }
}
