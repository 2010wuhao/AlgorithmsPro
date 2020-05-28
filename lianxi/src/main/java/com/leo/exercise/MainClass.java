package com.leo.exercise;

import com.leo.exercise.thread.ThreeThreadPrintA2Z;

public class MainClass {
    public static void main(String [] arg){
//        ThreeThreadPrintA2Z a2Z = new ThreeThreadPrintA2Z();
//        a2Z.print(3,26);

        DaYinZuiDaNWeiShu daYinZuiDaNWeiShu = new DaYinZuiDaNWeiShu();
        daYinZuiDaNWeiShu.printNum(3);
    }
}
