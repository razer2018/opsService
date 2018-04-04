package com.coindemo.common.thread;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author boli
 */
public class MyThreadPool {
	final static Logger logger = LoggerFactory.getLogger(MyThreadPool.class);
	static int cpu_core_size = Runtime.getRuntime().availableProcessors();
	static ExecutorService executorService;
	static {
		executorService = getThreadPoolExector();
	}

	public static ExecutorService getExecutorService() {
		return executorService;
	}

	private static ThreadPoolExecutor getThreadPoolExector() {
		final ThreadPoolExecutor result = new ThreadPoolExecutor(cpu_core_size * 2, cpu_core_size * 4, 5,
				TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(cpu_core_size * 6),
				new ThreadPoolExecutor.CallerRunsPolicy());
		result.setThreadFactory(new ThreadFactory() {
			@Override
			public Thread newThread(Runnable r) {
				Thread t = new Thread(r);
				t.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
					@Override
					public void uncaughtException(Thread t, Throwable e) {
						e.printStackTrace();
						logger.error("Thread exception: " + t.getName(), e);
						//result.shutdown();
					}
				});
				return t;
			}
		});
		return result;
	}

	private MyThreadPool() {
	}
}
