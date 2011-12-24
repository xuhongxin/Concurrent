/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2011 All Rights Reserved.
 */
package com.alipay.chonghuan;

/**
 * 采用传统的Sychronized同步的处理器。
 * 
 * @author hongxin.xu
 * @version $Id: SynchronizedProcessor.java, v 0.1 2011-12-24 下午4:19:54 hongxin.xu Exp $
 */
public class SynchronizedProcessor implements Processor {

    /** 需要同步的互斥资源。 */
    private static boolean flag = false;

    /**
     * 对互斥资源使用的处理器。
     * 
     * @throws InterruptedException
     */
    public void process() throws InterruptedException {

        synchronized (this) {
            if (flag == false) {
                System.out.println(Thread.currentThread().getId() + " get it");
                flag = true;
            }
        }
    }
}
