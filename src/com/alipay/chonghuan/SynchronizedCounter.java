/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2011 All Rights Reserved.
 */
package com.alipay.chonghuan;

/**
 * ͬ���ļ�������
 * 
 * @author hongxin.xu
 * @version $Id: SynchronizedCounter.java, v 0.1 2011-12-17 ����12:58:25 hongxin.xu Exp $
 */
public class SynchronizedCounter {
    /** ������������� */
    private int value;

    /**
     * ͬ����ȡ����ֵ��
     * 
     * @return
     */
    public synchronized int getValue() {
        return value;
    }

    /**
     * ͬ�����ӡ�
     * 
     * @return
     */
    public synchronized int incrument() {
        return value++;
    }

    /**
     * ͬ�����١�
     * 
     * @return
     */
    public synchronized int decrument() {
        return value--;
    }
}
