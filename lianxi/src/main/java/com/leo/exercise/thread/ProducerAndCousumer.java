package com.leo.exercise.thread;

public class ProducerAndCousumer {
    private Object lock = new Object();
    private int count;
    private int FULL = 5;

    public void test() {
        for (int i = 0; i < 3; i++) {
            P p = new P();
            p.start();
        }

        for (int i = 0; i < 3; i++) {
            C c = new C();
            c.start();
        }
    }

    class P extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock) {
                    while (count == FULL) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产者生产，目前总共有" + count);
                    lock.notifyAll();
                }
            }
        }
    }

    class C extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock) {
                    while (count == 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费者消费，目前总共有" + count);
                    lock.notifyAll();
                }
            }
        }
    }
}
