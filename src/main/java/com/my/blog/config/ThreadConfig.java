package com.my.blog.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Executable;
import java.util.concurrent.Executor;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2020/4/13 17:39
 */
@Configuration
@EnableAsync
public class ThreadConfig implements AsyncConfigurer {

    /**
     * The {@link Executor} instance to be used when processing async
     * method invocations.
     */
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(30);
        /**
         *使用无界队列。即不指定队列的大小，因此它将能够容纳所有任务。线程释放后，将提交任务。
         * 提供一个RejectedExecutionHandler可以完成任务的任务。即在调用者线程上运行它们，或丢弃它们或其他（取决于用例）。
         * 还有一些人已经被Java等来提供CallerRunsPolicy，AbortPolicy，DiscardPolicy和DiscardOldestPolicy。
         * 您可以像使用一样指定它们executor#setRejectedExecutionHandler。
         * 提供您自己的阻塞线程池执行程序，该线程将阻塞直到有更多任务空间（使用信号量）为止
         */
        executor.setQueueCapacity(50);
        executor.setThreadNamePrefix("default_task_executor_thread");
        executor.setRejectedExecutionHandler(new RejectedExecutionHandlerImpl());
        executor.initialize();
        return executor;
    }

    /**
     * The {@link AsyncUncaughtExceptionHandler} instance to be used
     * when an exception is thrown during an asynchronous method execution
     * with {@code void} return type.
     */
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }
}