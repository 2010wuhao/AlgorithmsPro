package com.leo.exercise;

public class DaYinZuiDaNWeiShu {
    int num = 0;

    void printNum(int n) {
        int x = 1;
        for (int i = 0; i < n; i++) {
            x = x * 10;
        }
        x = x - 1;
        for (int i = 0; i < x; i++) {
            num++;
            System.out.println(num);
        }
    }
}
