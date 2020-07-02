package com.leo.exercise;


public class MainClass {
    public static int[] intArray = {1, 2, 3, 4, 3, 2, 1};
    public static String[] stringArray = {};

    public static void main(String[] arg) {
//        ThreeThreadPrintA2Z a2Z = new ThreeThreadPrintA2Z();
//        a2Z.print(3,26);

//        DaYinZuiDaNWeiShu daYinZuiDaNWeiShu = new DaYinZuiDaNWeiShu();
//        daYinZuiDaNWeiShu.printNum(3);

//        TwoNumSum twoNumSum = new TwoNumSum();
//        int mid = twoNumSum.longestMidIndex(intArray);
//        System.out.println(" mid = " + mid + " 9/2 " + 9/2 );

//        LengthOfLongestSubstring substring = new LengthOfLongestSubstring();
//        int length = substring.lengthOfLongestSubstring1("abba");
//        System.out.println(length);

//        int maxP = 3;
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        for (int i = 0; i < maxP; i++) {
//            Producer producer = new Producer("p" + i, linkedList, maxP);
//            producer.start();
//        }
//        int maxC = 3;
//        for (int i = 0; i < maxC; i++) {
//            Consumer consumer = new Consumer("c" + i, linkedList, maxC);
//            consumer.start();
//        }

//        ProducerAndCousumer producerAndCousumer = new ProducerAndCousumer();
//        producerAndCousumer.test();

        System.out.println(MainClass.testTryCatch());
    }

    public static String testTryCatch() {
        String result;
        try {
            System.out.println(" 执行 try");
//            System.out.println(1 / 0);
            return result = " try 代码块";
        } catch (Exception exception) {
            System.out.println(" 执行 catch");
            System.out.println(1 / 0);
            return result = " catch 代码块";
        } finally {
            System.out.println(" 执行 finally");
//            return result = " finally 代码块";
        }
//        result = " 结尾 ";
//        return result;
    }
}
