package com.xjt.designMode.proAndCon;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 生产者--消费者，阻塞队列BlockingQueue的实现
 */
public class ProAndConDemo3 {

    private static int count = 0;
    private static final int FULL = 5;
    //创建一个阻塞队列
    private BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue(10);


    /**
     * 生产者
     */
    class Producer implements Runnable {
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    blockingQueue.put(1);
                    count++;
                    System.out.println(Thread.currentThread().getName()
                            + "生产者生产，目前总共有" + count);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 消费者
     */
    class Consumer implements Runnable {
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    blockingQueue.take();
                    count--;
                    System.out.println(Thread.currentThread().getName()
                            + "消费者消费，目前总共有" + count);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProAndConDemo3 demo = new ProAndConDemo3();
        new Thread(demo.new Producer()).start();
        new Thread(demo.new Consumer()).start();

    }
}
