package com.leetcode.multi_threading_2.zero_even_odd;

/**
 * @author BlueStar
 * @date 2021/5/20 20:49
 * @Description: TO print even number
 */
public class PrintZero implements Runnable{
    private InSequence inSequence;

    public PrintZero(InSequence inSequence) {
        this.inSequence = inSequence;

    }

    @Override
    public void run() {
        while (true){
            synchronized (inSequence.getLock()){
                // 判断打印次数 不为0 才打印
                if (inSequence.times > 0){
                    // 判断 flag 开关 false就等待 true打印偶数
                    if (inSequence.getFlag() == 0){
                        // 打印偶数
                        System.out.println(0);
                        if (inSequence.times % 4 == 0){
                            inSequence.setFlag(2);
                        } else {
                            inSequence.setFlag(1);
                        }
                        inSequence.times--;

                        inSequence.getLock().notifyAll();

                    } else {
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
