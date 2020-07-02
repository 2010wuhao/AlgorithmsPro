package com.leo.exercise.array;

import com.leo.exercise.Utils;

public class SplitArray {

    /**
     * 分割数组，使数组左侧是负数，右侧是整数
     * 思想是创建一个负数指针，默认为0，从1开始遍历，碰到负数就和指针位置交换，然后指针前移
     *
     * @param arrays
     */
    public static void splitArray(int[] arrays) {
        if (arrays == null || arrays.length == 0) {
            return;
        }
        //第一种解法
//        int fuIndex = 0;
//        for (int i = 1; i < arrays.length; i++) {
//            if (arrays[i] < 0) {
//                Utils.swap(arrays, fuIndex, i);
//                fuIndex++;
//            }
//        }
        //第二种解法
        int left = 0;
        int right = arrays.length - 1;
        while (left < right) {
            while (left < right && arrays[left] < 0) {
                left++;
            }
            while (left < right && arrays[right] > 0) {
                right--;
            }
            if (left > right) {
                break;
            }
            Utils.swap(arrays, left, right);
            left++;
            right--;
        }
    }


    public static void main(String[] args) {
        int[] array = {-3, -6, -1};
        SplitArray.splitArray(array);
        Utils.printIntArray(array);
    }
}
