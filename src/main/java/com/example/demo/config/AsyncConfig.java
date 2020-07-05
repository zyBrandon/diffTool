package com.example.demo.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor() {
        //线程池设置
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize( 8 );//核心线程
        taskExecutor.setMaxPoolSize( 16 );//最大线程
        taskExecutor.setQueueCapacity( 40 );//队列大小
        taskExecutor.setThreadNamePrefix( "async-service-" );
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        //直接返回 祖籍 AsyncUncaughtExceptionHandler 对象
        return AsyncConfigurer.super.getAsyncUncaughtExceptionHandler();
    }
}
