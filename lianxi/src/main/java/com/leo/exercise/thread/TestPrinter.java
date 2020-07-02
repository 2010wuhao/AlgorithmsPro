package com.leo.exercise.thread;

public class TestPrinter {
    String[] mPrintArray = {"A", "B", "C", "D"};
    int threadCount = 0;
    int maxThreadCount = 4;

    class PrintThread extends Thread {
        private String strArray[];
        private int id;

        public PrintThread(String[] arrays, int id) {
            strArray = arrays;
            this.id = id;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (strArray) {
                    if (id != (threadCount % maxThreadCount)) {
                        try {
                            strArray.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(strArray[threadCount % maxThreadCount]);
                    threadCount++;
                    strArray.notifyAll();
                }
            }
        }
    }

    public void printTest() {
        for (int i = 0; i < 4; i++) {
            PrintThread p = new PrintThread(mPrintArray, i);
            p.start();
        }
    }

    public static void main(String[] args) {
        TestPrinter main = new TestPrinter();
        main.printTest();
    }
}
