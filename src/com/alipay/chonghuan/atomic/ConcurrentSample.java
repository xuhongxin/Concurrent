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
 * ����atomicʵ�ֵĲ������ơ�
 * 
 * @author hongxin.xu
 * @version $Id: AtomicSample.java, v 0.1 2011-12-24 ����4:12:45 hongxin.xu Exp $
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

        // ִ����ͨ��������
        CommonProcessor common = new CommonProcessor();
        long start = System.currentTimeMillis();
        for (int i = 0; i < NUM; i++) {
            new ConcurrentSample(common).run();
        }
        long elapse = System.currentTimeMillis() - start;
        System.out.println("��������ִ��ʱ��:" + elapse);

        // ִ��synchronized��������
        Processor synch = new SynchronizedProcessor();
        start = System.currentTimeMillis();
        for (int i = 0; i < NUM; i++) {
            new ConcurrentSample(synch).run();
        }
        elapse = System.currentTimeMillis() - start;
        System.out.println("��Synchronized����ִ��ʱ��:" + elapse);

        // ִ��atomic��������
        // ִ��synchronized��������
        Processor atomic = new AtomicProcessor();

        start = System.currentTimeMillis();
        for (int i = 0; i < NUM; i++) {
            new ConcurrentSample(atomic).run();
        }
        elapse = System.currentTimeMillis() - start;
        System.out.println("��Atomic����ִ��ʱ��:" + elapse);
    }
}
