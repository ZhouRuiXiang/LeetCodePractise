package com.leetcode.multi_threading_2.zero_even_odd;

/**
 * @author BlueStar
 * @date 2021/5/20 20:58
 * @Description:
 */
public class InSequence {
    private final Object lock = new Object();
    // flag 开关 false就打印奇数 true就打印偶数
    private int flag = 0;
    public int times;

    public InSequence(int times) {
        this.times = times * 2;
    }

    public Object getLock() {
        return lock;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }
}
