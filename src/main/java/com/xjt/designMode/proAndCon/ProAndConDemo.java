package com.xjt.designMode.proAndCon;

/**
 * 生产者--消费者，普通的wait()和notify()方法的实现
 */
public class ProAndConDemo {

    private static int count = 0;
    private static final int FULL = 5;
    private static String LOCK = "lock";

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
                synchronized (LOCK) {
                    while (count == FULL) {
                        try {
                            // 线程等待，消费者消费资源
                            LOCK.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产者生产，目前总共有" + count);
                    // 唤醒消费者，消费资源
                    LOCK.notifyAll();
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
                synchronized (LOCK) {
                    while (count == 0) {
                        try {
                            // 线程等待，生产者生产资源
                            LOCK.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费者消费，目前总共有" + count);
                    // 唤醒生产者，生产资源
                    LOCK.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProAndConDemo demo = new ProAndConDemo();
        new Thread(demo.new Producer()).start();
        new Thread(demo.new Consumer()).start();

    }
}
