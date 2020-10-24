package com.panpan.walle.atguigu;

import java.util.concurrent.TimeUnit;

/**
 * -Xms128m -Xmx4096m -Xss1024k -XX:MetaspaceSize=512m -XX:+PrintCommandLineFlags -XX:+PrintGCDetail -XX:+UseSerialGC
 *
 */
public class HelloGC {
    public static void main(String[] args) throws InterruptedException {
        byte[] b = new byte[20 * 1024 *1024];
        //TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
    }
}
