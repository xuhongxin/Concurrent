/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2011 All Rights Reserved.
 */
package com.alipay.chonghuan;

/**
 * 互斥锁的实例。
 * 
 * @author hongxin.xu
 * @version $Id: SynchronizedMutex.java, v 0.1 2011-12-17 下午1:26:34 hongxin.xu Exp $
 */
public class SynchronizedMutex {
    /** 互斥实例 */
    private Thread curOwner;

    /**
     * 同步获取互斥实例。
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
     * 同步释放互斥实例。
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
