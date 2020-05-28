package com.leo.exercise.sort;

public class SortLogic {
    //选择排序，每次从数组中找出最小的元素与指针元素兑换，然后指针前移一个位置
    public static int[] selectedSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        //创建一个指针，初始指向第一个元素，每次从数组中找出最小的元素和指针元素交换，然后指针前移
        int pointer = 0;
        for (int i = 0; i < nums.length; i++) {
            pointer = i;
            for (int j = pointer + 1; j < nums.length; j++) {
                //可以优化，减少交换次数
//                if (nums[j] < nums[pointer]) {
//                    int temp = nums[j];
//                    nums[j] = nums[pointer];
//                    nums[pointer] = temp;
//                }
                //第二种写法
                if (nums[j] < nums[pointer]) {
                    pointer = j;
                }
            }
            //优化后判断是否发生了交换，如果交换说明找到了最小值
            if (pointer != i) {
                int temp = nums[i];
                nums[i] = nums[pointer];
                nums[pointer] = temp;
            }
        }
        return nums;
    }

    //插入排序，把数组分成两部分，第一部分排好序的，第二部分待排序的，每次从待排序中取第一个元素插入到排好序的部分中
    public static int[] insertSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        for (int i = 1; i < nums.length; i++) {
            //在排好序的数组中把i元素插入合适的位置
            //第一种写法
//            for (int j = i; j > 0; j--) {
//                if (nums[j] < nums[j - 1]) {
//                    int temp = nums[j];
//                    nums[j] = nums[j - 1];
//                    nums[j - 1] = temp;
//                } else {
//                    //这个地方是与选择排序区别的地方，也是比选择排序快的地方，
//                    //如果发现i元素不再大于前一个元素证明已经排序好了，可以跳出循环
//                    break;
//                }
//            }

            //第二种写法，当i元素小于前一个元素时才进行交换，不小于证明已经排好序
            for (int j = i; j > 0 && nums[j] < nums[j - 1]; j--) {
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
            }
        }
        return nums;
    }
}
