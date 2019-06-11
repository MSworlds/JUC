package com.meng.juc;


import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018-06-06.
 */
public class TestVolatile {
    public /*volatile*/ boolean  flag = false;

    public void change() {
        System.out.println("改变");
        flag = true;
    }

    public static void main(String[] args) throws InterruptedException {
        TestVolatile testVolatile = new TestVolatile();

        new Thread(() -> {
            while (true) {
                if (testVolatile.flag) {
                    System.out.println("==================================");
                    break;
                }
            }

        }).start();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            testVolatile.change();


        }).start();


        System.out.println("over");
    }
}
