/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2011 All Rights Reserved.
 */
package com.alipay.chonghuan;

/**
 * ��������ʵ����
 * 
 * @author hongxin.xu
 * @version $Id: SynchronizedMutex.java, v 0.1 2011-12-17 ����1:26:34 hongxin.xu Exp $
 */
public class SynchronizedMutex {
    /** ����ʵ�� */
    private Thread curOwner;

    /**
     * ͬ����ȡ����ʵ����
     * 
     * @throws InterruptedException
     */
    public synchronized void acquire() throws InterruptedException {
        if (Thread.interrupted()) {
            while (curOwner != null) {
                wait();
            }
            curOwner = Thread.currentThread();
        }
    }

    /**
     * ͬ���ͷŻ���ʵ����
     */
    public synchronized void release() {
        if (curOwner == Thread.currentThread()) {
            curOwner = null;
            notify();
        } else {
            throw new IllegalStateException("not owner of mutex");
        }
    }
}
