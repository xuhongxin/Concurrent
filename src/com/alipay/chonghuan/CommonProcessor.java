/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2011 All Rights Reserved.
 */
package com.alipay.chonghuan;

/**
 * 没有采用同步方式的处理器。
 * 
 * @author hongxin.xu
 * @version $Id: CommonProcessor.java, v 0.1 2011-12-24 下午4:26:28 hongxin.xu Exp $
 */
public class CommonProcessor implements Processor {
    /** 需要同步的互斥资源。 */
    private static boolean flag = false;

    /**
     * 对互斥资源使用的处理器。
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
