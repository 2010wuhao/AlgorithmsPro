package com.leo.exercise.string;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode48
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int lastLength = 0;//记录上一次不重复子串的长度
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char child = s.charAt(i);
            int lastIndex = map.getOrDefault(child, -1);
            //每次更新子串长度的时候,只可能是增加1，所以需要判断新旧不重复子串长度
            //新长度可能是"abba"型，所以每次新长度不都是重复子串之间的距离值
            lastLength = lastLength < i - lastIndex ? lastLength + 1 : i - lastIndex;
            map.put(child, i);
            maxLength = Math.max(lastLength, maxLength);
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        //记录上一次不重复子串长度
        int lastLength = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char child = s.charAt(i);
            int nowLength = i - map.getOrDefault(child, -1);
            //每次新长度最多增加1，所以需要判断两次长度大小，如果新长度大则可能是"abba"类型
            //所以只可能增加1，如果新长度小则使用新长度
            if (nowLength > lastLength) {
                lastLength++;
            } else {
                lastLength = nowLength;
            }
            map.put(child, i);
            maxLength = Math.max(lastLength, maxLength);
        }
        return maxLength;
    }

    /**
     * 使用left记录最左侧的重复子串的边界，每次遍历如果出现重复则更新左边界，计算左边界和右边解的距离
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s) {
        if (s == null) {
            return 0;
        }
        int left = -1;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char child = s.charAt(i);
            if (map.containsKey(child)) {
                //每次更新左侧边界，更新的时候需要比较上一次边界和这一次边界值，取最大的，
                //要不然边界会回退，比如"abba"，第一次边界是1，当最后一个重复时不能更新
                left = Math.max(left, map.get(child));
            }
            map.put(child, i);
            maxLength = Math.max(maxLength, i - left);
        }
        return maxLength;
    }
}
