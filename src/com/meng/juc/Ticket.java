package com.meng.juc;

/**
 * Created by Administrator on 2018-06-08.
 * 经典抢票demo
 */
class Ticket implements Runnable {

    private int num = 0; // 出票数
    private int count = 10; // 剩余票数

    boolean flag = false;

    @Override
    public void run() {

        while (true) {
//            synchronized (this) {
            // 没有余票时，跳出循环
            if (count <= 0) {
                break;
            }
            num++;
            count--;

            try {
                Thread.sleep(500);// 模拟网络延时
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("显示出票信息：" + Thread.currentThread().getName()
                    + "抢到第" + num + "张票，剩余" + count + "张票");
        }
    }
}

//}


class TicketTest {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Ticket ticket = new Ticket();
        // 　实例化几个抢票用户
        Thread mary = new Thread(ticket, "玛丽");

        Thread jack = new Thread(ticket, "杰克");

        mary.start();

        jack.start();

    }
}