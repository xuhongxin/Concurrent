/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2011 All Rights Reserved.
 */
package com.alipay.chonghuan;

/**
 * ģ��cas���롣
 * 
 * @author hongxin.xu
 * @version $Id: SimulatedCAS.java, v 0.1 2011-12-17 ����2:21:09 hongxin.xu Exp $
 */
public class SimulatedCAS {

    private int value;

    public int getValue() {
        return value;
    }

    public synchronized int compareAndSwap(int exceptedValue, int newValue) {
        int oldValue = value;

        // ֻ�е�oldValue����Ԥ�ڵ�ʱ�򣬲Ž��и���valueֵ�Ĳ�����
        if (oldValue == exceptedValue) {
            value = newValue;
        }

        // ����ͬ������֮ǰ��ֵ��
        return oldValue;
    }
}
