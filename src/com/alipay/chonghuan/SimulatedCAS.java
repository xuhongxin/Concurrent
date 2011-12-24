/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2011 All Rights Reserved.
 */
package com.alipay.chonghuan;

/**
 * 模拟cas代码。
 * 
 * @author hongxin.xu
 * @version $Id: SimulatedCAS.java, v 0.1 2011-12-17 下午2:21:09 hongxin.xu Exp $
 */
public class SimulatedCAS {

    private int value;

    public int getValue() {
        return value;
    }

    public synchronized int compareAndSwap(int exceptedValue, int newValue) {
        int oldValue = value;

        // 只有当oldValue符合预期的时候，才进行更新value值的操作。
        if (oldValue == exceptedValue) {
            value = newValue;
        }

        // 返回同步操作之前的值。
        return oldValue;
    }
}
