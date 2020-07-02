package com.leo.exercise.array;

/**
 * 我们选择数组区间 A[0…n-1]的最后一个元素 A[n-1]作为 pivot，对数组 A[0…n-1]原地分区，
 * 这样数组就分成了三部分，A[0…p-1]、A[p]、A[p+1…n-1]。
 * 如果 p+1=K，那 A[p]就是要求解的元素；
 * 如果 K>p+1, 说明第 K 大元素出现在 A[p+1…n-1]区间，
 * 我们再按照上面的思路递归地在 A[p+1…n-1]这个区间内查找。
 * 同理，如果 K<p+1，那我们就在 A[0…p-1]区间查找。
 */
public class FindMaxNum {

    public int findKthLargest(int[] nums, int k) {
        if (nums == null) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int index = 0;
        while (true) {
            index = quickSort(nums, left, right);
            if (index + 1 == k) {
                return nums[index];
            } else if (index + 1 < k) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }

    }

    //一个从大到小的排序,然后返回中间节点的下标
    public int quickSort(int[] arrays, int begin, int end) {
        if (arrays == null || arrays.length == 1) {
            return begin;
        }

        if (begin >= end) {
            return begin;
        }

        int left = begin;
        int right = end;
        int p = arrays[left];
        //因为先进行的左侧赋值，所以需要先从右侧开始比较
        while (left < right) {
            while (left < right && p >= arrays[right]) {
                right--;
            }
            arrays[left] = arrays[right];

            while (left < right && arrays[left] >= p) {
                left++;
            }
            arrays[right] = arrays[left];
        }
        arrays[left] = p;
        return left;
    }


    public void swap(int[] a, int l, int r) {
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }

    public static void main(String args[]) {
        int[] ints = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        FindMaxNum findMaxNum = new FindMaxNum();
        int index = 6;
        System.out.println(" 第" + index + "大元素是 ： " + findMaxNum.findKthLargest(ints, index));
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
