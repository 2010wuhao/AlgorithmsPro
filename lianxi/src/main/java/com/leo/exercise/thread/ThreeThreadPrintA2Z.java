package com.leo.exercise.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreeThreadPrintA2Z {
    AtomicInteger atomicInteger = new AtomicInteger(0);
    Object lock = new Object();
    int printCount = 0;
    int threadCount;
    int time = 0;

    class PrinterThread extends Thread {
        int id;
        PrinterThread(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println("thread" + id);
            while (atomicInteger.get() < printCount) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock) {
                    while ((atomicInteger.get() % threadCount) != id) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    time = atomicInteger.incrementAndGet();

                    if (time > printCount) {
                        return;
                    }
                    System.out.println("thread" + id + " print " + time );
                    lock.notifyAll();
                }
            }
        }
    }

    public void print(int threadCount, int printCount) {
        this.printCount = printCount;
        this.threadCount = threadCount;
        System.out.println("printCount = " + printCount + " threadCount = " + threadCount);
        for (int i = 0; i < threadCount; i++) {
            PrinterThread p0 = new PrinterThread(i);
            p0.start();
        }
    }
}

