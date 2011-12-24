/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2011 All Rights Reserved.
 */
package com.alipay.chonghuan.atomic;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 采用Atomic实现的并发实例。
 * 
 * @author hongxin.xu
 * @version $Id: AtomicCounterSample.java, v 0.1 2011-12-17 下午3:45:48 hongxin.xu Exp $
 */
public class AtomicCounterSample extends Thread {

    private AtomicCounter atomicCounter;

    private AtomicJudge   atomicJudge;

    public AtomicCounterSample(AtomicCounter atomicCounter) {
        this.atomicCounter = atomicCounter;
    }

    public AtomicCounterSample(AtomicJudge atomicJudge) {
        this.atomicJudge = atomicJudge;
    }

    public void run() {
        // long sleepTime = (long) (Math.random() * 100);
        // try {
        // Thread.sleep(sleepTime);
        // } catch (InterruptedException e) {
        // e.printStackTrace();
        // }
        if (atomicCounter != null) {
            atomicCounter.counterIncrement();
        }

        if (atomicJudge != null) {
            try {
                atomicJudge.concurrentJudge();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        // AtomicCounter atomicCounter = new AtomicCounter();
        AtomicJudge atomicJudge = new AtomicJudge();

        // for (int i = 0; i < 5000; i++) {
        // new AtomicCounterSample(atomicCounter).start();
        // }
        //
        // Thread.sleep(3000);
        //
        // System.out.println("counter=" + atomicCounter.getCounter());

        for (int i = 0; i < 500000; i++) {
            new AtomicCounterSample(atomicJudge).start();
        }
    }

}

class AtomicCounter {

    private AtomicInteger counter = new AtomicInteger(0);

    public int getCounter() {
        return counter.get();
    }

    public void counterIncrement() {
        for (;;) {
            int current = counter.get();
            int next = current + 1;
            if (counter.compareAndSet(current, next)) {
                return;
            }
        }
    }
}

class AtomicJudge {

    /** 需要同步的临界资源。 */
    boolean               flag          = false;

    /**
     * 同步工具。
     * 
     * @throws InterruptedException
     */
    private AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    public void concurrentJudge() throws InterruptedException {
        // 首先判断临界资源状态。
        if (flag == false) {
            Thread.sleep(100);
            // 对临界资源进行同步操作。
            if (atomicBoolean.compareAndSet(false, true)) {
                Thread.sleep(10000);
                flag = true;
                System.out.println("update the resource");
            }
        }
    }
}