/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2011 All Rights Reserved.
 */
package com.alipay.chonghuan.atomic;

import com.alipay.chonghuan.AtomicProcessor;
import com.alipay.chonghuan.CommonProcessor;
import com.alipay.chonghuan.Processor;
import com.alipay.chonghuan.SynchronizedProcessor;

/**
 * 采用atomic实现的并发控制。
 * 
 * @author hongxin.xu
 * @version $Id: AtomicSample.java, v 0.1 2011-12-24 下午4:12:45 hongxin.xu Exp $
 */
public class ConcurrentSample extends Thread {

    private Processor        processor;

    private final static int NUM = 1000;

    public ConcurrentSample(Processor processor) {
        this.processor = processor;
    }

    /**
     * @see java.lang.Thread#run()
     */
    @Override
    public void run() {
        try {

            processor.process();

        } catch (Exception e) {

        }
    }

    public static void main(String[] args) throws InterruptedException {

        // 执行普通处理器。
        CommonProcessor common = new CommonProcessor();
        long start = System.currentTimeMillis();
        for (int i = 0; i < NUM; i++) {
            new ConcurrentSample(common).run();
        }
        long elapse = System.currentTimeMillis() - start;
        System.out.println("不加锁的执行时间:" + elapse);

        // 执行synchronized处理器。
        Processor synch = new SynchronizedProcessor();
        start = System.currentTimeMillis();
        for (int i = 0; i < NUM; i++) {
            new ConcurrentSample(synch).run();
        }
        elapse = System.currentTimeMillis() - start;
        System.out.println("加Synchronized锁的执行时间:" + elapse);

        // 执行atomic处理器。
        // 执行synchronized处理器。
        Processor atomic = new AtomicProcessor();

        start = System.currentTimeMillis();
        for (int i = 0; i < NUM; i++) {
            new ConcurrentSample(atomic).run();
        }
        elapse = System.currentTimeMillis() - start;
        System.out.println("加Atomic锁的执行时间:" + elapse);
    }
}
