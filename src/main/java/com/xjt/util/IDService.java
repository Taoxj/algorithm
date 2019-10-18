package com.xjt.util;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * id生成器
 * 
 * @author kevin
 * @date 2019-10-18 9:16
 */
public class IDService {
    private BlockingQueue<Long> queue = new LinkedBlockingQueue<Long>();
    private AtomicInteger swicth = new AtomicInteger(0);
    private CountDownLatch latch = new CountDownLatch(1);
    private IdWorker idWorker = new IdWorker();
    ExecutorService service = Executors.newCachedThreadPool();

    public Long generate() {
        swicth.decrementAndGet();
        if (swicth.get() < 200000) {
            latch = new CountDownLatch(1);
            service.submit(new Producer());
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return queue.poll();
    }

    class Producer implements Runnable {
        public void run() {
            for (int i = 0; i < 900000; i++) {
                queue.offer(idWorker.nextId());
            }
            swicth.addAndGet(900000);
            latch.countDown();
        }
    }
}
