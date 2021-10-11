package com.xjt;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author kevin
 * @date 2020/11/15
 */
public class ConditionDemo {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Thread tA = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("线程A加锁成功");
                System.out.println("线程A执行await被挂起");
                condition.await();
                System.out.println("线程A被唤醒成功");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println("线程A释放锁成功");
            }
        });

        Thread tB = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("线程B加锁成功");
                condition.signal();
                System.out.println("线程B唤醒线程A");
            } finally {
                lock.unlock();
                System.out.println("线程B释放锁成功");
            }
        });
        tA.start();
        tB.start();
    }
}
