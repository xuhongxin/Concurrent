/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2011 All Rights Reserved.
 */
package com.alipay.chonghuan;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 采用atomic的同步策略。
 * 
 * @author hongxin.xu
 * @version $Id: AtomicProcessor.java, v 0.1 2011-12-24 下午4:29:17 hongxin.xu Exp $
 */
public class AtomicProcessor implements Processor {

    /** 需要同步的互斥资源。 */
    private static boolean             flag          = false;

    /** atomic同步器。 */
    private final static AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    /**
     * 对互斥资源使用的处理器。
     * 
     * @throws InterruptedException
     */
    public void process() throws InterruptedException {

        if (atomicBoolean.compareAndSet(false, true)) {
            System.out.println(Thread.currentThread().getId() + " get it");
            flag = true;
        }
    }
}
