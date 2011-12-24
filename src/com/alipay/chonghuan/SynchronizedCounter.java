/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2011 All Rights Reserved.
 */
package com.alipay.chonghuan;

/**
 * 同步的计数器。
 * 
 * @author hongxin.xu
 * @version $Id: SynchronizedCounter.java, v 0.1 2011-12-17 下午12:58:25 hongxin.xu Exp $
 */
public class SynchronizedCounter {
    /** 定义计数变量。 */
    private int value;

    /**
     * 同步获取变量值。
     * 
     * @return
     */
    public synchronized int getValue() {
        return value;
    }

    /**
     * 同步增加。
     * 
     * @return
     */
    public synchronized int incrument() {
        return value++;
    }

    /**
     * 同步减少。
     * 
     * @return
     */
    public synchronized int decrument() {
        return value--;
    }
}
