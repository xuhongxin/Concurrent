/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2011 All Rights Reserved.
 */
package com.alipay.chonghuan;

/**
 * ���ô�ͳ��Sychronizedͬ���Ĵ�������
 * 
 * @author hongxin.xu
 * @version $Id: SynchronizedProcessor.java, v 0.1 2011-12-24 ����4:19:54 hongxin.xu Exp $
 */
public class SynchronizedProcessor implements Processor {

    /** ��Ҫͬ���Ļ�����Դ�� */
    private static boolean flag = false;

    /**
     * �Ի�����Դʹ�õĴ�������
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
