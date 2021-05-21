package com.leetcode.multi_threading_2.zero_even_odd;

/**
 * @author BlueStar
 * @date 2021/5/20 20:50
 * @Description: To print odd number
 */
public class PrintOdd implements Runnable {
    private InSequence inSequence;
    private int i = 1;

    public PrintOdd(InSequence inSequence) {
        this.inSequence = inSequence;
    }


    @Override
    public void run() {

        while (true) {
            synchronized (inSequence.getLock()) {
                // 判断打印次数是否用完
                if (inSequence.times > 0) {
                    // 判断flag 开关 true就等待 false才打印
                    if (inSequence.getFlag() == 1) {
                        System.out.println(i);
                        i += 2;
                        inSequence.setFlag(0);
                        inSequence.times--;
                        // 锁对象关联的对象notify
                        inSequence.getLock().notifyAll();

                    } else { //等待
                        try {
                            inSequence.getLock().wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                } else {
                    break;
                }
            }
        }
    }
}
