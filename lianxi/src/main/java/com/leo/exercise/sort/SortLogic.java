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

    public static int[] insertSort1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        for (int i = 1; i < nums.length; i++) {
            int value = nums[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (nums[j] > value) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = value;
        }
        return nums;
    }

    /**
     * // 快速排序，A是数组，n表示数组的大小
     * quick_sort(A, n) {
     * quick_sort_c(A, 0, n-1)
     * }
     * // 快速排序递归函数，p,r为下标
     * quick_sort_c(A, p, r) {
     * if p >= r then return
     * <p>
     * q = partition(A, p, r) // 获取分区点
     * quick_sort_c(A, p, q-1)
     * quick_sort_c(A, q+1, r)
     * }
     */
    public static void quickSort(int[] A, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int mid = partition(A, begin, end);
        quickSort(A, begin, mid - 1);
        quickSort(A, mid + 1, end);
    }

    //对数组进行一次排序，找到分割点
    private static int partition(int[] A, int begin, int end) {
        //选一个分割元素
        int x = A[end];
        //指针，标记分割点
        int i = begin;
        //使用插入排序的思想把数组分为大于X和小于X的两部分
        for (int j = i; j < end; j++) {
            if (A[j] < x) {
                swap(A, i, j);
                i++;
            }
        }
        swap(A, i, end);
        return i;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void quickSortB(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        if (a == null || a.length == 1) {
            return;
        }
        int pivot = a[low];
        int left = low;
        int right = high;
        if (left < right) {
            while (left < right) {
                //因为先进行的左侧赋值，所以需要先从右侧开始比较
                while (left < right && pivot <= a[right]) {
                    right--;
                }
                a[left] = a[right];
                while (left < right && pivot >= a[left]) {
                    left++;
                }
                a[right] = a[left];
            }
            a[left] = pivot;

            quickSortB(a, low, left - 1);
            quickSortB(a, left + 1, high);
        }
    }

    public static void mergeSort(int[] a, int begin, int end) {
        if (begin >= end) {
            return;
        }
        if (a == null || a.length == 1) {
            return;
        }
        int mid = (begin + end) / 2;
        mergeSort(a, begin, mid);
        mergeSort(a, mid + 1, end);
        merge(a, begin, mid, end);
    }

    /**
     * 合并两个有序数组
     *
     * @param array
     * @param begin l1有序数组的开始
     * @param mid   l1有序数组的结束 l1和l2的分界点
     * @param end   l2数组的结束
     */
    private static void merge(int[] array, int begin, int mid, int end) {
        int[] temp = new int[end - begin + 1];
        int k = 0;
        int l1 = begin;
        int l2 = mid + 1;
        while (l1 <= mid && l2 <= end) {
            if (array[l1] <= array[l2]) {
                temp[k++] = array[l1];
                l1++;
            } else {
                temp[k++] = array[l2];
                l2++;
            }
        }
        int restStartIndex = 0;
        int restEndIndex = 0;
        if (l1 > mid) {
            restStartIndex = l2;
            restEndIndex = end;
        } else {
            restStartIndex = l1;
            restEndIndex = mid;
        }
        while (restStartIndex <= restEndIndex) {
            temp[k++] = array[restStartIndex++];
        }
        for (int i = 0; i < end - begin + 1; i++) {
            array[begin + i] = temp[i];
        }
    }
}
