package com.pib.util;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;


/**
* 多線程類
* @author weiceng1sheng
*/
public class ThreadUtil {
	private static final ExecutorService CACHE_POOL = Executors.newCachedThreadPool();
	private static ExecutorService fixPool = Executors.newFixedThreadPool(1000);
	private static ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(50);
	
	private static Map<String, ScheduledFuture<?>> scheduledFutureMap = new ConcurrentHashMap<>();

	/**
	 * 超过线程池容量限制会等待
	 * @param callable callable
	 * @return Future
	 */
	public static <T> Future<T> run(Callable<T> callable) {
		autoSetUpThreadPool();
		if (fixPool == null) {
			return CACHE_POOL.submit(callable);
		}
		return fixPool.submit(callable);
	}
	
	public static void run(Runnable runnable) {
		autoSetUpThreadPool();
		if (fixPool == null) {
			CACHE_POOL.submit(runnable);
		}
		fixPool.submit(runnable);
	}
	
	/**
	 * 无容量限制的线程池，可能会导致内存不足
	 * @param <T> Callable
	 * @param callable callable
	 * @return Future
	 */
	public static <T> Future<T> runUrgent(Callable<T> callable) {
		autoSetUpThreadPool();
		return CACHE_POOL.submit(callable);
	}
	public static void runUrgent(Runnable runnable) {
		autoSetUpThreadPool();
		CACHE_POOL.submit(runnable);
	}
	
	/**
	 * 
	 * @param name 用于停止时候的指定的名称
	 * @param runnable runnable
 	 * @param second 以秒为单位
	 */
	public static void runInterval(String name, Runnable runnable, long second) {
		ScheduledFuture<?> scheduledFuture = scheduledThreadPool.scheduleWithFixedDelay(runnable, 0, second, TimeUnit.SECONDS);
		scheduledFutureMap.put(name, scheduledFuture);
	}
	public static boolean cancelInterval(String name) {
		boolean result = scheduledFutureMap.get("name").cancel(true);
		if (result) {
			scheduledFutureMap.remove(name);
		}
		return result;
	}
	
	public static void setMaxThread(int count) {
		fixPool = Executors.newFixedThreadPool(count);
	}
	private static void autoSetUpThreadPool() {
		if (fixPool == null) {
			CACHE_POOL.execute(() -> {
				setMaxThread(1000);
			});
		}
	}
}
