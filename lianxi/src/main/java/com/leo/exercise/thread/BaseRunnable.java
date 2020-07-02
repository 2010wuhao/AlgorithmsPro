package com.leo.exercise.thread;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class BaseRunnable extends Thread {
    String name;
    Queue<Integer> queue;
    int maxSize;
    Random random = new Random();
    public static AtomicInteger count = new AtomicInteger(0);

    public BaseRunnable(String name, Queue queue, int maxSize) {
        this.name = name;
        this.queue = queue;
        this.maxSize = maxSize;
    }
}
