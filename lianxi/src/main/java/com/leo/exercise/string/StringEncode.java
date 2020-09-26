package com.leo.exercise.string;

import java.util.LinkedList;

/**
 * 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 */
public class StringEncode {
    public static String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        LinkedList<Integer> nums = new LinkedList<>();
        LinkedList<String> characters = new LinkedList<>();
        LinkedList<String> temp = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            Character child = s.charAt(i);
            //判断是否是数字
            if (Character.isDigit(child)) {
//                //Char to int
//                nums.addLast(Character.getNumericValue(child));
                //解决连续数字的问题
                StringBuilder builder = new StringBuilder();
                while (Character.isDigit(s.charAt(i))) {
                    builder.append(s.charAt(i));
                    i++;
                }
                i--;
                nums.addLast(Integer.parseInt(builder.toString()));
            } else if (Character.isLowerCase(child)
                    || Character.isUpperCase(child)
                    //解决嵌套问题3[4b2[a]]
                    || '[' == child) {
                //判断是否是字母a-z A-Z
                characters.addLast(Character.toString(child));
            } else if (']' == child) {
                temp.clear();
                //字符栈出栈直到为空或者遇到做开始符号
                while (!characters.isEmpty()) {
                    String c = characters.removeLast();
                    System.out.println(" c = " + c);
                    if ("[".equals(c)) {
                        break;
                    }
                    temp.addFirst(c);
                }
                //拼接需要重复的字符串
                StringBuilder builder = new StringBuilder();
                while (!temp.isEmpty()) {
                    builder.append(temp.removeFirst());
                }
                String sub = builder.toString();
                //根据重复次数拼接，然后再存入字符栈
                //因为拼接的时候已经重复一次，所以需要n-1
                int n = nums.removeLast() - 1;
                for (int j = 0; j < n; j++) {
                    builder.append(sub);
                }
                String t = builder.toString();
                System.out.println(" sub = " + sub + " n = " + n + " t = " + t);
                characters.addLast(t);
                System.out.println("-------------" + characters.size());
            }
        }

        StringBuilder builder = new StringBuilder();
        while (!characters.isEmpty()) {
            String s1 = characters.removeFirst();
            System.out.println(" s1 = " + s1);
            builder.append(s1);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String test = "10[wuhao]";
        String result = StringEncode.decodeString(test);
        System.out.println(" result = " + result);
    }
}
