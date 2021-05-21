package com.leetcode.multi_threading.print_in_sequence;

/**
 * @author BlueStar
 * @date 2021/5/20 20:49
 * @Description: TO print even number
 */
public class PrintEven implements Runnable{
    int i = 2;
    private InSequence inSequence;

    public PrintEven(InSequence inSequence) {
        this.inSequence = inSequence;

    }

    @Override
    public void run() {
        while (true){
            synchronized (inSequence.getLock()){
                // 判断打印次数 不为0 才打印
                if (inSequence.times > 0){
                    // 判断 flag 开关 false就等待 true打印偶数
                    if (inSequence.isFlag()){
                        // 打印偶数
                        System.out.println(i);
                        i += 2;
                        inSequence.setFlag(false);
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
