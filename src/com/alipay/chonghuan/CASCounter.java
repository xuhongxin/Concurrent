/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2011 All Rights Reserved.
 */
package com.alipay.chonghuan;

/**
 * ģ��CASģʽ������ͬ����������
 * 
 * @author hongxin.xu
 * @version $Id: CASCounter.java, v 0.1 2011-12-17 ����2:31:10 hongxin.xu Exp $
 */
public class CASCounter {

    private SimulatedCAS value;

    public int getValue() {
        return value.getValue();
    }

    public int increment() {
        int oldValue = value.getValue();
        if (value.compareAndSwap(oldValue, oldValue + 1) != oldValue) {
            oldValue = value.getValue();
        }
        return oldValue + 1;
    }
}
