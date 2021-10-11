package com.xjt;

/**
 * 线程交替打印
 */
public class MultiThread {

    public static void main(String[] args) {
        final Object obj = new Object();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    while (true){
                        synchronized (obj){
                            obj.notifyAll();
                            obj.wait();
                            System.out.println(0);
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    while (true){
                        synchronized (obj){
                            obj.notifyAll();
                            obj.wait();
                            System.out.println(1);
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
    }
}
