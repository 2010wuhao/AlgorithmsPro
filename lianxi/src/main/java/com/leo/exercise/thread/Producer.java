package com.leo.exercise.thread;

import java.util.Queue;

public class Producer extends BaseRunnable {

    public Producer(String name, Queue queue, int maxSize) {
        super(name, queue, maxSize);
    }

    @Override
    public void run() {
        if (queue == null) {
            return;
        }
        while (true) {
            try {
                Thread.sleep(random.nextInt(3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (queue) {
                while (queue.size() == maxSize) {
                    try {
                        System.out.println(" Producer:" + name + " wait ");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int temp = count.incrementAndGet();
                queue.offer(temp);
                System.out.println(" Producer:" + name + " 生产 car:" + temp);
                queue.notifyAll();
            }
        }
    }
}
