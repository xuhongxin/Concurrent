/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2011 All Rights Reserved.
 */
package com.alipay.chonghuan;

/**
 * û�в���ͬ����ʽ�Ĵ�������
 * 
 * @author hongxin.xu
 * @version $Id: CommonProcessor.java, v 0.1 2011-12-24 ����4:26:28 hongxin.xu Exp $
 */
public class CommonProcessor implements Processor {
    /** ��Ҫͬ���Ļ�����Դ�� */
    private static boolean flag = false;

    /**
     * �Ի�����Դʹ�õĴ�������
     * 
     * @throws InterruptedException
     */
    public void process() throws InterruptedException {

        if (flag == false) {
            System.out.println(Thread.currentThread().getId() + " get it");
            Thread.sleep(10000);
            flag = true;
        }
    }
}
