/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2011 All Rights Reserved.
 */
package com.alipay.chonghuan;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * ����atomic��ͬ�����ԡ�
 * 
 * @author hongxin.xu
 * @version $Id: AtomicProcessor.java, v 0.1 2011-12-24 ����4:29:17 hongxin.xu Exp $
 */
public class AtomicProcessor implements Processor {

    /** ��Ҫͬ���Ļ�����Դ�� */
    private static boolean             flag          = false;

    /** atomicͬ������ */
    private final static AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    /**
     * �Ի�����Դʹ�õĴ�������
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
