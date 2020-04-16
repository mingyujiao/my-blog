package com.my.blog.config;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2020/4/13 18:37
 */
public class RejectedExecutionHandlerImpl implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        try {
            executor.getQueue().put(r);
        }
        catch (InterruptedException e) {
            throw new RejectedExecutionException("There was an unexpected InterruptedException whilst waiting to add a Runnable in the executor's blocking queue", e);
        }
    }
}