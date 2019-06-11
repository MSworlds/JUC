package com.meng.juc;

import org.junit.Test;

import java.util.concurrent.*;

public class testxianhaolaing {


    /*
     * dountwatchdown  test
     *
     * */
    @Test
    public void test1() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        /*所有线程都运行完成才继续主线程*/

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {

                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();

        System.out.println("over");

    }

    public static void test2() throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {

                try {
                    System.out.println(1);
                    Thread.sleep(2000);

                    cyclicBarrier.await();
                    System.out.println("好");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        new Thread(() -> {

            try {
                System.out.println("last");
                Thread.sleep(5000);
                System.out.println("我来晚了抱歉我");
                cyclicBarrier.await();
                System.out.println("see you");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();


        System.out.println("main结束");

    }

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        test3();
    }


    public static  void test3() {
     /*信号量*/
        Semaphore semaphore=new Semaphore(3);
        for (int j=0;j<4;j++) {
            new Thread(() -> {
                for (int i = 0; i < 3; i++) {
                    try {
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName() + "come in");
                        TimeUnit.SECONDS.sleep(10);
                        semaphore.release();
                        System.out.println(Thread.currentThread().getName() + "come out");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }).start();
        }


    }
}
