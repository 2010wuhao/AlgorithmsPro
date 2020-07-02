package com.leo.exercise.thread;

import java.util.Queue;

public class Consumer extends BaseRunnable {
    public Consumer(String name, Queue queue, int maxSize) {
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
                while (queue.isEmpty()) {
                    try {
                        System.out.println(" Consumer:" + name + " wait ");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int temp = queue.poll();
                System.out.println(" Consumer:" + name + " 消费  car:" + temp);
                queue.notifyAll();
            }
        }
    }
}
