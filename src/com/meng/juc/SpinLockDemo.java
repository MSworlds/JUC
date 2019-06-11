package com.meng.juc;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class SpinLockDemo {


    public static void main(String[] args) {
        mylock mylock = new mylock();
        new Thread(() -> {
            mylock.lock();
            try {
                System.out.println("jdfksdfjkdsfjkdsjkdfskjhdfskhd");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mylock.unlock();
        }).start();

        new Thread(() -> {
            mylock.lock();
            System.out.println("nothing");
            mylock.unlock();
        }).start();
    }
}

class mylock {


    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void lock() {
        System.out.println(Thread.currentThread().getName() + "come in");
        while (!atomicReference.compareAndSet(null, Thread.currentThread())) {


        }
    }

    public void unlock() {
        System.out.println(Thread.currentThread().getName() + "out");
        atomicReference.compareAndSet(Thread.currentThread(), null);
    }


}
