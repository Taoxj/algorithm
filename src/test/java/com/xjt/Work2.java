package com.xjt;

public class Work2 {
    static final Object object = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    for (int i = 1; i < 10; i += 2) {
                        System.out.println(Thread.currentThread().getName() + "    " + i);
                        object.notify();
                        try {
                            System.out.println("开始等待1");
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("拿到锁1");
                    }
                }
            }
        }, "t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    for (int i = 2; i < 10; i += 2) {
                        System.out.println(Thread.currentThread().getName() + "     " + i);
                        object.notify();
                        try {
                            System.out.println("开始等待2");
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("拿到锁2");
                    }
                }
            }
        }, "t2");
        t1.start();
        t2.start();
    }
}
