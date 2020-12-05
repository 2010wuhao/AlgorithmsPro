package com.leo.exercise.java;

public class TestAssignment {

    public static void test() {
        int a = 3;
        Integer b = 100;
        Integer c = 100;
        String text1 = "java";
        String text2 = new String("python");
        int[] arr1 = new int[]{4};
//        text1 = null;
        change(a, b, c, text1, text2, arr1);
        System.out.println(a);//3
        System.out.println(b == c); //true
        System.out.println(b.equals(c));//true
        System.out.println(text1);//java
        System.out.println(text2);//python
        System.out.println(arr1[0]);//4
    }

    //String和数组当参数传递，传递的是地址的copy，如果在方法体中重新进行了赋值，不会改变原有的内存地址。
    public static void change(int a, Integer b, Integer c, String s1, String s2, int[] arr1) {
        a = 9;
        s1 = "android";
        s2 = String.valueOf("go");
        arr1 = new int[1];
        arr1[0] = 9;
    }

    public static void main(String[] args) {
        test();
    }
}
