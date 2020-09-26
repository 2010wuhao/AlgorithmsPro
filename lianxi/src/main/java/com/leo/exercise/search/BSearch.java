package com.leo.exercise.search;

public class BSearch {

    /**
     * @param a
     * @param n     搜索范围
     * @param value 搜索的值
     * @return
     */
    public int bSearch(int[] a, int n, int value) {
        if (a == null) {
            return -1;
        }
        int low = 0;
        int height = n - 1;
        while (low <= height) {
            int mid = low + (height - low) / 2;
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                height = mid - 1;
            }
        }
        return -1;
    }

    public int bSearch2(int[] a, int n, int value) {
        return bSearchInternally(a, 0, n, value);
    }

    public int bSearchInternally(int[] a, int low, int height, int value) {
        if (low > height) {
            return -1;
        }
        int mid = low + ((height - low) >> 1);
        if (a[mid] == value) {
            return mid;
        } else {
            return a[mid] < value
                    ? bSearchInternally(a, mid + 1, height, value)
                    : bSearchInternally(a, low, mid - 1, value);
        }
    }


    //变体一：查找第一个值等于给定值的元素
    public int bsearch1(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                //如果 mid 等于 0，那这个元素已经是数组的第一个元素，那它肯定是我们要找的；
                //如果 mid 不等于 0，但 a[mid]的前一个元素 a[mid-1]不等于 value，
                //那也说明 a[mid]就是我们要找的第一个值等于给定值的元素。
                // 如果经过检查之后发现 a[mid]前面的一个元素 a[mid-1]也等于 value，
                // 那说明此时的 a[mid]肯定不是我们要查找的第一个值等于给定值的元素。
                // 那我们就更新 high=mid-1，因为要找的元素肯定出现在[low, mid-1]之间。
                if ((mid == 0) || (a[mid - 1] != value)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

}
